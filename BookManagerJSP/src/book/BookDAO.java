package book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

  public int insertBook(Book book) {
    JDBConnection jdbc = new JDBConnection();

    // sql문 만들기
    String sql = "INSERT INTO BOOK (ID, TITLE, AUTHOR, PUBLISHER, PRICE, INSTOCK) VALUES (book_seq.NEXTVAL, ?, ?, ?, ?, ?)";

    int result = 0;

    try {
      // PreparedStatement 객체 생성
      jdbc.pstmt = jdbc.conn.prepareStatement(sql);

      // SQL문 매개변수에 값 추가
      jdbc.pstmt.setString(1, book.getTitle());
      jdbc.pstmt.setString(2, book.getAuthor());
      jdbc.pstmt.setString(3, book.getPublisher());
      jdbc.pstmt.setInt(4, book.getPrice());
      jdbc.pstmt.setInt(5, book.getInstock());

      // SQL문 실행
      result = jdbc.pstmt.executeUpdate();
      if (result == 1) {
        System.out.println(result + "행 추가됨.");
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      jdbc.close();
    }

    return result;
  }

  public Book selectBook(int id) {
    JDBConnection jdbc = new JDBConnection();

    // PreparedStatement 변수 선언, ResultSet 변수 선언
    jdbc.pstmt = null;
    jdbc.rs = null;

    // sql문 만들기
    String sql = "SELECT * FROM BOOK WHERE ID = ?";
    Book book = null;

    try {
      // PreparedStatement 객체 생성
      jdbc.pstmt = jdbc.conn.prepareStatement(sql);

      // SQL문 실행
      jdbc.pstmt.setInt(1, id);
      jdbc.rs = jdbc.pstmt.executeQuery();

      // ResultSet 객체에서 결과값 가져와서 출력하기
      while (jdbc.rs.next()) {
        book = new Book(jdbc.rs.getString("id"), jdbc.rs.getString("title"), jdbc.rs.getString("author"),
        jdbc.rs.getString("publisher"), jdbc.rs.getInt("price"), jdbc.rs.getInt("instock"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 자원 객체 닫기
      jdbc.close();
    }

    return book;
  }

  public List<Book> selectBookAll() {
    JDBConnection jdbc = new JDBConnection();

    // sql문 만들기
    String sql = "SELECT * FROM BOOK";

    // 결과를 저장할 List 객체
    List<Book> bookList = new ArrayList<>();

    try {
      // PreparedStatement 객체 생성
      jdbc.pstmt = jdbc.conn.prepareStatement(sql);
      // SQL문 실행
      jdbc.rs = jdbc.pstmt.executeQuery();

      // ResultSet 객체에서 결과값 가져와서 출력하기
      while (jdbc.rs.next()) {
        bookList.add(new Book(jdbc.rs.getString("id"), jdbc.rs.getString("title"), jdbc.rs.getString("author"),
        jdbc.rs.getString("publisher"), jdbc.rs.getInt("price"), jdbc.rs.getInt("instock")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      jdbc.close();
    }
    return bookList;
  }

  public int updateBook(Book book) {
    JDBConnection jdbc = new JDBConnection();

    String sql = "UPDATE BOOK SET TITLE = ?, AUTHOR = ?, PUBLISHER = ?, PRICE = ?, INSTOCK = ? WHERE ID = ?";

    int result = 0;

    try {
      jdbc.pstmt = jdbc.conn.prepareStatement(sql);
      jdbc.pstmt.setString(1, book.getTitle());
      jdbc.pstmt.setString(2, book.getAuthor());
      jdbc.pstmt.setString(3, book.getPublisher());
      jdbc.pstmt.setInt(4, book.getPrice());
      jdbc.pstmt.setInt(5, book.getInstock());
      jdbc.pstmt.setString(6, book.getId());

      result = jdbc.pstmt.executeUpdate();

      System.out.println(result + "행이 수정되었습니다.");
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      jdbc.close();
    }
    return result;
  }

  public int deleteBook(int id) {
    JDBConnection jdbc = new JDBConnection();

    String sql = "DELETE BOOK WHERE ID = ?";

    int result = 0;

    try {
      jdbc.pstmt = jdbc.conn.prepareStatement(sql);

      jdbc.pstmt.setInt(1, id);

      result = jdbc.pstmt.executeUpdate();

      if (result == 1) {
        System.out.println("'ID = " + id + "' 행 삭제됨.");
      } else {
        System.out.println("없는 행입니다.");
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      jdbc.close();
    }

    return result;
  }

}
