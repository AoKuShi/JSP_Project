package test;

import java.util.List;

import cart.Cart;
import cart.CartDAO;
import cart.CartService;

public class CartTest {
    public static void main(String[] args) {
    CartService service = new CartService(new CartDAO());
    List<Cart> cartList = service.listAll();

    for (Cart m : cartList) {
      System.out.println(m.toString());
    }

    // Cart cart = service.read(1);
    // if (cart != null) {
    //   System.out.println(cart.toString());
    // }

    // Cart cart = new Cart(8, 7, 10);
    // if (service.regist(cart)) {
    //   System.out.println("등록 성공.");
    // } else {
    //   System.out.println("등록 실패");
    // }

    // Cart cart = new Cart(3, 40, 1, 50, null);
    // service.edit(cart);

    //service.remove(3);


  }
}

