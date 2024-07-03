package cart;

import java.sql.Date;

public class Cart {
  private int id;
  private int memberNo;
  private int bookId;
  private int quantity;
  private Date regdate;
  
  public Cart(int id, int memberNo, int bookId, int quantity, Date regdate) {
    this.id = id;
    this.memberNo = memberNo;
    this.bookId = bookId;
    this.quantity = quantity;
    this.regdate = regdate;
  }

  public Cart(int memberNo, int bookId, int quantity) {
    this.memberNo = memberNo;
    this.bookId = bookId;
    this.quantity = quantity;
  }

  public int getBookId() {
    return bookId;
  }
  public int getId() {
    return id;
  }
  public int getMemberNo() {
    return memberNo;
  }
  public int getQuantity() {
    return quantity;
  }
  public Date getRegdate() {
    return regdate;
  }
  public void setBookId(int bookId) {
    this.bookId = bookId;
  }
  public void setId(int id) {
    this.id = id;
  }
  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
  }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  public void setRegdate(Date regdate) {
    this.regdate = regdate;
  }

  @Override
  public String toString() {
    return "[" + id + ", " + memberNo + ", " + bookId + ", " + quantity + ", " + regdate + "]";
  }
}
