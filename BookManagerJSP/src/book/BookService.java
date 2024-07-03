package book;

import java.util.List;

public class BookService {
  private BookDAO bookDao;

  public BookService(BookDAO bookDao) {
    this.bookDao = bookDao;
  }

  public boolean regist(Book book) {
    if (book == null) return false;
    return bookDao.insertBook(book) == 1 ? true : false;
  }

  public Book read(int id) {
    return bookDao.selectBook(id);
  }

  public List<Book> listAll() {
    return bookDao.selectBookAll();
  }

  public boolean edit(Book book) {
    if (book == null) return false;
    return bookDao.updateBook(book) == 1 ? true : false;
  }

  public boolean remove(int id) {
    if (bookDao.selectBook(id) == null) return false;
    return bookDao.deleteBook(id) == 1 ? true : false;
  }

}
