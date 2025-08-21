package Ch08;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C05Select {

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
		
		
		
		
		pstmt = conn.prepareStatement("SELECT * tbl_a");
	rs =	pstmt.executeQuery();//표 형태의 객체를 그대로 받아오겠다. rs가 가리키고 있는 위치는 맨위 속성명
	if(rs!=null) {
		while(rs.next()) {//rs.next()는 rs가 가리키고 있는 다음 행으로 위치를 이동시킨다
			System.out.print(rs.getInt("no")+".");//no가 int형이기 떄문에 getInt()
			System.out.println(rs.getString("name"));//name은 char이기 때문에 getString()
		}
	}
	
		
	}catch(ClassNotFoundException e1) {
		System.out.println("클래스 부재 예외발생");
		
	}catch(SQLException e2) {
//			System.out.println("SQL예외발생");
			e2.printStackTrace();
		}finally {//사용하는 자원 제거합니다.
			try{rs.close();} catch(SQLException e ) {e.printStackTrace();}//가장 나중에 만든 객채부터 삭제한다.
			try{pstmt.close();} catch(SQLException e ) {e.printStackTrace();}
			try{conn.close();} catch(SQLException e ) {e.printStackTrace();}
		}

}
}