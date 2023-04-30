package com.bridgelabz.BookStore.services;

import com.bridgelabz.BookStore.dto.CartDto;
import com.bridgelabz.BookStore.dto.ResponceDto;
import com.bridgelabz.BookStore.exception.CustomeException;
import com.bridgelabz.BookStore.model.BookStore;
import com.bridgelabz.BookStore.model.Cart;
import com.bridgelabz.BookStore.model.UserModel;
import com.bridgelabz.BookStore.repo.CartRepo;
import com.bridgelabz.BookStore.repo.UserRepo;
import com.bridgelabz.BookStore.util.JWTToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImp  implements  CartService{
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private JWTToken jwtToken;

    @Override
    public ResponceDto addCart(CartDto cartDto) {
        int user_id = jwtToken.decodeToken(cartDto.getToken());
        Optional<UserModel> user = userRepo.findById(user_id);//
        if (user.isPresent()) {
//            Cart cart = cartRepo.findDataById(user_id);
            Cart dataBaseBookId=cartRepo.findBookid((int) cartDto.book_id,user_id);
            System.out.println("the data is ---------"+dataBaseBookId);
//            Optional<Cart> cartData=cartRepo.findById(cart.getCart_id());
            if (dataBaseBookId !=null) {
                System.out.println("the Book is present in " + user_id);
                Optional<Cart> data = cartRepo.findDataByBookId(cartDto.book_id);
                System.out.println("the cart data is + " + data);
                data.get().setQuantity((int) (data.get().getQuantity() + cartDto.getQuantity()));
                return new ResponceDto("the cart is added ", cartRepo.save(data.get()));
            } else {
                BookStore book = bookService.getById((int) cartDto.getBook_id());
                Cart cartDta = new Cart(user.get(), book, (int) cartDto.quantity);

                return new ResponceDto("", cartRepo.save(cartDta));
            }
        }
        else {
            return new ResponceDto("The cart is not added ", " The data is not present with user ");
        }

    }

    @Override
    public ResponceDto removeCartById(long cartId) {
        cartRepo.deleteById(cartId);
        return new ResponceDto("The items deleted ","id"+cartId);
    }

    @Override
    public Cart getById(long cart_Id) {
        return cartRepo.findById(cart_Id).orElseThrow(() -> new CustomeException(" Data Not found .. wih id: "+ cart_Id));
    }
    @Override
    public ResponceDto getCartByToken(String token) {
        int id=jwtToken.decodeToken(token);
        System.out.println(id+"  id");
        List<Cart> cartid=cartRepo.findDataByToken(id);
//        System.out.println(cartid.getCart_id() +"cart id");
        if(!cartid.isEmpty()){
            return new ResponceDto("the data ",cartid);
        }else {
            return new ResponceDto("no data present with token ",null);
        }
    }

    @Override
    public ResponceDto updateBytoken(String token,long cart_id,long quantity) {
        int id=jwtToken.decodeToken(token);
        System.out.println(id+"  id");
//        Cart cartid=cartRepo.findDataById(id);
//        System.out.println(cartid+"  cart id");
        Optional<Cart> data=cartRepo.findById(cart_id);
        if((data!=null) && data.get().getUserModel().getId()==id){
            data.get().setQuantity((int) quantity);
            return new ResponceDto("the qunatity Updated ",cartRepo.save(data.get()));
        }
        return null;
    }

    @Override
    public List<Cart> getAlldata() {
        return cartRepo.findAll();

    }
}