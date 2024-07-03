package cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

  public int deleteCart(int no) {

    JDBConnection jdbc = new JDBConnection();

    // sql문 만들기
    String sql = "DELETE CART WHERE ID = ?";

    int result = 0;

    try {
      // PreparedStatement 객체 생성
      jdbc.pstmt = jdbc.conn.prepareStatement(sql);

      // SQL문 매개변수에 값 추가
      jdbc.pstmt.setInt(1, no);

      result = jdbc.pstmt.executeUpdate();

      // SQL문 실행
      if (result == 1) {
        System.out.println(no + "행 삭제됨.");
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

  public int updateCart(Cart cart) {

    // DB 연결
    JDBConnection jdbc = new JDBConnection();

    // sql문 만들기
    String sql = "UPDATE CART SET MEMBER_NO = ?, BOOK_ID = ?, QUANTITY = ? WHERE ID = ?";

    int result = 0;

    try {
      // PreparedStatement 객체 생성
      jdbc.pstmt = jdbc.conn.prepareStatement(sql);

      // SQL문 실행
      jdbc.pstmt.setInt(1, cart.getMemberNo());
      jdbc.pstmt.setInt(2, cart.getBookId());
      jdbc.pstmt.setInt(3, cart.getQuantity());
      jdbc.pstmt.setInt(4, cart.getId());

      result = jdbc.pstmt.executeUpdate();

      System.out.println(result + "행이 수정되었습니다.");
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      jdbc.close();
    }

    return result;
  }

  public int insertCart(Cart cart) {
    // DB 연결
    JDBConnection jdbc = new JDBConnection();

    // sql문 만들기
    String sql = "INSERT INTO CART (ID, MEMBER_NO, BOOK_ID, QUANTITY, REGDATE) VALUES (cart_seq.NEXTVAL, ?, ?, ?, SYSDATE)";

    int result = 0;

    try {
      // PreparedStatement 객체 생성
      jdbc.pstmt = jdbc.conn.prepareStatement(sql);

      // SQL문 매개변수에 값 추가
      jdbc.pstmt.setInt(1, cart.getMemberNo());
      jdbc.pstmt.setInt(2, cart.getBookId());
      jdbc.pstmt.setInt(3, cart.getQuantity());

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

  public List<Cart> selectCartAll(int memberNo) {

    // DB 연결
    JDBConnection jdbc = new JDBConnection();

    // sql문 만들기
    String sql = "select * from CART WHERE MEMBER_NO = ?";
    
    // 결과를 저장할 List 객체
    List<Cart> CartList = new ArrayList<>();

    try {
      // PreparedStatement 객체 생성
      jdbc.pstmt = jdbc.conn.prepareStatement(sql);

      jdbc.pstmt.setInt(1, memberNo);

      // SQL문 실행
      jdbc.rs = jdbc.pstmt.executeQuery();

      // ResultSet 객체에서 결과값 가져와서 출력하기
      while (jdbc.rs.next()) {
        CartList.add(new Cart(jdbc.rs.getInt("id"), 
        jdbc.rs.getInt("MEMBER_NO"), 
        jdbc.rs.getInt("BOOK_ID"), 
        jdbc.rs.getInt("QUANTITY"), 
        jdbc.rs.getDate("regdate")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      jdbc.close();
    }

    return CartList;
  }

  public Cart selectCart(int no) {
    // DB 연결
    JDBConnection jdbc = new JDBConnection();

    // PreparedStatement 변수 선언, ResultSet 변수 선언
    jdbc.pstmt = null;
    jdbc.rs = null;

    // sql문 만들기
    String sql = "SELECT * FROM CART WHERE ID = ? ORDER BY ID";
    Cart Cart = null;

    try {
      // PreparedStatement 객체 생성
      jdbc.pstmt = jdbc.conn.prepareStatement(sql);

      // SQL문 실행
      jdbc.pstmt.setInt(1, no);
      jdbc.rs = jdbc.pstmt.executeQuery();

      // ResultSet 객체에서 결과값 가져와서 출력하기
      while (jdbc.rs.next()) {
        Cart = new Cart(jdbc.rs.getInt("id"), 
        jdbc.rs.getInt("MEMBER_NO"), 
        jdbc.rs.getInt("BOOK_ID"), 
        jdbc.rs.getInt("QUANTITY"), 
        jdbc.rs.getDate("regdate"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 자원 객체 닫기
      jdbc.close();
    }

    return Cart;
  }

  public Cart selectCart(String memNo, String boId) {
    // DB 연결
    JDBConnection jdbc = new JDBConnection();

    // PreparedStatement 변수 선언, ResultSet 변수 선언
    jdbc.pstmt = null;
    jdbc.rs = null;

    // sql문 만들기
    String sql = "select * from cart where MEMBER_NO=? and BOOK_ID=?";
    Cart Cart = null;

		try {
			// PreparedStatement 객체 생성
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setString(1, memNo);
			jdbc.pstmt.setString(2, boId);
			
			// SQL문 실행
			jdbc.rs = jdbc.pstmt.executeQuery();

			// ResultSet 객체에서 결과값 가져와서 출력하기
			if (jdbc.rs.next()) {
				Cart = new Cart(
					jdbc.rs.getInt("id"), 
          jdbc.rs.getInt("MEMBER_NO"), 
          jdbc.rs.getInt("BOOK_ID"), 
          jdbc.rs.getInt("QUANTITY"), 
					jdbc.rs.getDate("regdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 자원 객체 닫기
		jdbc.close();

		return Cart;
  }

}