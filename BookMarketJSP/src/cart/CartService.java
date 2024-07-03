package cart;

import java.util.List;

public class CartService {
  private CartDAO cartDao;

  public CartService(CartDAO cartDao) {
    this.cartDao = cartDao;
  }

  public boolean regist(Cart cart) {
    int result = cartDao.insertCart(cart);
    return result == 1? true : false;
  }

  public Cart read(int no) {
    return cartDao.selectCart(no);
  }

  public List<Cart> listAll(int memberNo) {
    return cartDao.selectCartAll(memberNo);
  }

  public boolean edit(Cart Cart) {
    if (Cart == null) return false;
    return cartDao.updateCart(Cart) == 1 ? true : false;
  }

  public boolean remove(int no) {
    if (cartDao.selectCart(no) == null) return false;
    return cartDao.deleteCart(no) == 1 ? true : false;
  }
}
