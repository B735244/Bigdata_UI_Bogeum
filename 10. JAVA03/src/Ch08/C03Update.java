package Ch08;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C03Update {

	public static void main(String[] args) {
		String id = "root";
		String pw = "1234";
		String url =  "jdbc:mysql://localhost:3306/opendatadb";//DBMS종류/DBMS위치/DB명
		
		
		//JDBC 참조변수
		Connection conn = null;//DBMS의 특정 DB와 연결되는 객체
		PreparedStatement pstmt = null;//SQL Query 전송용 객체
		ResultSet rs = null;//Select 결과물을 담을 객체

		
		//연결작업
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");//JDBC 드라이버 로딩 
		System.out.println("Driver Loading Success...");
		conn = DriverManager.getConnection(url,id,pw);
		System.out.println("DB CONNECTED...");
		//sql query 객체 생성
		
		
		
		
		pstmt = conn.prepareStatement("update tbl_a set name = ? where no =?");
	
		pstmt.setString(1, args[1]);
		pstmt.setInt(2, Integer.parseInt(args[0]));
		
		
		
		//sql을 DBMS로 전달
		int result = pstmt.executeUpdate();
		//Select를 제외한 DML문 
		//결과값으로 java에서 처리함
		if(result>0)
			System.out.println("UPDATE 성공");
		else
			System.out.println("UPDATE 실패");
	}catch(ClassNotFoundException e1) {
		System.out.println("클래스 부재 예외발생");
		
	}catch(SQLException e2) {
//			System.out.println("SQL예외발생");
			e2.printStackTrace();
		}finally {
			try{conn.close();} catch(SQLException e ) {e.printStackTrace();}
		}

}
}