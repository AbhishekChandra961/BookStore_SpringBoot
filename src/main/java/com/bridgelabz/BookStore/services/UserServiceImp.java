package com.bridgelabz.BookStore.services;

import com.bridgelabz.BookStore.dto.Login;
import com.bridgelabz.BookStore.dto.ResponseDto;
import com.bridgelabz.BookStore.dto.UserDto;
import com.bridgelabz.BookStore.dto.Verification;
import com.bridgelabz.BookStore.exception.CustomException;
import com.bridgelabz.BookStore.model.UserModel;
import com.bridgelabz.BookStore.repo.UserRepo;
import com.bridgelabz.BookStore.util.EmailService;
import com.bridgelabz.BookStore.util.JWTToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JWTToken jwtToken;
    @Autowired
    private EmailService emailService;



    @Override
    public ResponseDto login(Login login) {
        String email =login.getEmail();
        String password=login.getPassword();
        String varifyPassword=userRepo.getPassword(email);
        String token=userRepo.getVarifyOtp(email);
        if (password.equals(varifyPassword) &&token!=null ){
            return new ResponseDto("login successfull..... for "+ "token \n "+token,login.getEmail());
        }
        else{
            if(varifyPassword!=null &&token == null){
                return new ResponseDto("The validation not done ","Validate the otp to login");
            }else {
                return new ResponseDto(" check the email and password", "The incorrect credentials");
            }
        }
    }

    @Override
    public ResponseDto varify(Verification verification) {
        String email=verification.getEmail();
        int id =userRepo.findIdByEmail(email);
        Optional<UserModel> data=userRepo.findById(id);
        if (verification.getOtp()==data.get().getOtp()){
            String token=jwtToken.createToken(id);
            data.get().setVarifyOtp(true);
            data.get().setToken(token);
            userRepo.save(data.get());
            return new ResponseDto("The data registerd succsusfully  and genarated token ", "Token is :- "+token);
        }else {
            return new ResponseDto("Varification not done check the mail ","give correct data");
        }

    }

    @Override
    public ResponseDto register(UserDto userDto) {
        String email=userDto.getEmail();
        String mail=userRepo.findEmail(email);
        if(mail!=null){
            return new ResponseDto("Enter the unique Email id ",userDto.getEmail());
        }else {
            UserModel userData=new UserModel(userDto);
            int genarateOtp=(int) ((Math.random() * 999999) % 899998) + 100001;
            userData.setOtp(genarateOtp);
            userRepo.save(userData);
            emailService.sendEmail(userData.getEmail(),"The is Register done OTP sent  ","hi....."+userData.getFirstName()+userData.getLastName() + "\n The OTP is "+genarateOtp + " ");
            return new ResponseDto("The data rigisterd succsusfully",userDto) ;
        }
    }

    /*
    The Curd opporations
     */
    @Override
    public UserModel getById(int id) {
        return userRepo.findById(id).orElseThrow(() -> new CustomException(" Employee Not found .. wih id: "+ id));

    }
    @Override
    public List<UserModel> getAllData() {
        return userRepo.findAll();
    }
    @Override
    public UserModel UpdateEmployee(int id, UserDto userDto) {
        UserModel addressBookData =this.getById(id);
        addressBookData.updateData(userDto);
        return userRepo.save(addressBookData);
    }


    @Override
    public void delete(int id) {
        UserModel addressBookData =this.getById(id);
        userRepo.delete(addressBookData);
    }
    @Override
    public UserModel getdataByToken(String token) {
        int id= jwtToken.decodeToken(token);
        System.out.println(id+"id -------------");
        return userRepo.findById(id).orElseThrow(() -> new CustomException("Employee Not found :- "+id));
    }

    @Override
    public String deletedataByToken(String token) {
        int id= jwtToken.decodeToken(token);
        UserModel userData =this.getById(id);
        userRepo.delete(userData);
        return "The data is deleted";
    }

}
