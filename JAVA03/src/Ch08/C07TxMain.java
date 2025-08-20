package Ch08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C07TxMain {

	public static void main(String[] args) {
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/opendatadb";// DBMS종류/DBMS위치/DB명

		// JDBC 참조변수
		Connection conn = null;// DBMS의 특정 DB와 연결되는 객체
		PreparedStatement pstmt = null;// SQL Query 전송용 객체
		ResultSet rs = null;// Select 결과물을 담을 객체

		// 연결작업
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// JDBC 드라이버 로딩
			System.out.println("Driver Loading Success...");
			conn = DriverManager.getConnection(url, id, pw);// connection이 만들어진 이후에 트랜잭션을 묶어준다.
			System.out.println("DB CONNECTED...");
			// sql query 객체 생성

			// Transcation
			// Start-----------------------------------------------------------------------
			conn.setAutoCommit(false);// autocommit을 일딴꺼 -> 그럼 임시저장이 됨.

			// INSERT
			pstmt = conn.prepareStatement("insert into tbl_a values(1,'bogeum')");
			pstmt.executeUpdate();

			pstmt = conn.prepareStatement("insert into tbl_a values(2,'bogdong')");
			pstmt.executeUpdate();

			pstmt = conn.prepareStatement("insert into tbl_a values(1,'geumdong')");
			pstmt.executeUpdate();

			pstmt = conn.prepareStatement("insert into tbl_a values(4,'kyudong')");
			pstmt.executeUpdate();
			// INSERT

			// Transaction
			// End---------------------------------------------------------------------------
			conn.commit();

		} catch (ClassNotFoundException e1) {
			System.out.println("클래스 부재 예외발생");

		} catch (SQLException e2) {
//		System.out.println("SQL예외발생");
			e2.printStackTrace();
			try {
				System.out.println("ROLLBACK!!!");
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			} // 트랜잭션 롤백!
		}
//		catch(SQLIntegrityConstraintViolationException e3) 
//		{
//	System.out.println("SQL 제약조건에 위배되는 .......... 위에 SQL예외에 다 포함되어 있음");
//		e3.printStackTrace();
//		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}