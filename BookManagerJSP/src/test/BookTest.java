package test;

import java.util.List;

import book.Book;
import book.BookDAO;
import book.BookService;

public class BookTest {
  public static void main(String[] args) {
    BookService service = new BookService(new BookDAO());
    List<Book> bookList = service.listAll();

    for (Book m : bookList) {
      System.out.println(m.toString());
    }


    // Book book = service.read(1);
    // if (book != null) {
    //   System.out.println(book.toString());
    // }

    // book = new Book("이름1", "저자1", "출판사1", 2, 2);
    // if (service.regist(book)) {
    //   System.out.println("회원 등록 성공.");
    // } else {
    //   System.out.println("회원 등록 실패");
    // }


    // Book book = new Book("2", 3);
    // service.edit(book);


    // service.remove(2);
  }
}
