package book;

public class Book {
  private String id;
  private String title;
  private String author;
  private String publisher;
  private int price;
  private int instock;

  public Book(String id, String title, String author, String publisher, int price, int instock) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.price = price;
    this.instock = instock;
  }

  public Book(String title, String author, String publisher, int price, int instock) {
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.price = price;
    this.instock = instock;
  }

  public String getAuthor() {
    return author;
  }
  public String getId() {
    return id;
  }
  public String getTitle() {
    return title;
  }
  public int getPrice() {
    return price;
  }
  public String getPublisher() {
    return publisher;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
  public void setId(String id) {
    this.id = id;
  }
  public void setTitle(String name) {
    this.title = name;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }
  public int getInstock() {
    return instock;
  }
  public void setInstock(int instock) {
    this.instock = instock;
  }

  @Override
  public String toString() {
    return "[" + id  + ", " + title + ", " + author + ", " + publisher + ", " + price + ", " + instock + "]";
  }
}
