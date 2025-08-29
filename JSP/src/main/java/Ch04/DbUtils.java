package Ch04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Ch02.MemberDto;


public class DbUtils {
	// 속성(DB연결 관련 된 멤버)
	// DB CONN DATA
	private static String id = "root";
	private static String pw = "1234";
	private static String url = "jdbc:mysql://localhost:3306/opendatadb";

	// JDBC참조변수
	private static Connection conn = null; // DBMS 의 특정 DB와 연결되는 객체
	private static PreparedStatement pstmt = null; // SQL Query 전송용 객체
	private static ResultSet rs = null; // Select 결과물 담을 객체
	// 싱글톤 패턴 처리

	public static void conn() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loading Success...");
		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("DB CONNECTED...");
	}

	public static void disConn() throws Exception {
		// rs / pstmt / conn close ó��
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}

	public static int insertMember(MemberDto memberDto) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_member values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		pstmt.setString(1, memberDto.getUserid());
		pstmt.setString(2, memberDto.getPassword());
		pstmt.setString(3, memberDto.getRePassword());
		pstmt.setString(4, memberDto.getUsername());
		pstmt.setString(5, memberDto.getZipcode());
		pstmt.setString(6, memberDto.getAddr1());
		pstmt.setString(7, memberDto.getAddr2());
		pstmt.setString(8, memberDto.getPhone1());
		pstmt.setString(9, memberDto.getPhone2());
		pstmt.setString(10, memberDto.getPhone3());
		pstmt.setString(11, memberDto.getTel1());
		pstmt.setString(12, memberDto.getTel2());
		pstmt.setString(13, memberDto.getTel3());
		pstmt.setString(14, memberDto.getEmail());
		pstmt.setString(15, memberDto.getYear());
		pstmt.setString(16, memberDto.getMonth());
		pstmt.setString(17, memberDto.getDay());
		int result = pstmt.executeUpdate();
		return result;
	}

	public static MemberDto selectMember(String userid) throws Exception {
		pstmt = conn.prepareStatement("select * from tbl_member where userid = ?");
		
		pstmt.setString(1, userid);//executeQuery전에 해줘야하는 이유
		rs = pstmt.executeQuery();
		
		
		MemberDto dto = null;
		if (rs != null && rs.next()) {
			dto = new MemberDto();
			dto.setUserid(rs.getString("rePassword"));
			dto.setUsername(rs.getString("username"));
			dto.setZipcode(rs.getString("zipcode"));
			dto.setAddr1(rs.getString("addr1"));
			dto.setAddr2(rs.getString("addr2"));
			dto.setPhone1(rs.getString("phone1"));
			dto.setPhone2(rs.getString("phone2"));
			dto.setPhone3(rs.getString("phone3"));
			dto.setTel1(rs.getString("tel1"));
			dto.setTel2(rs.getString("tel2"));
			dto.setTel3(rs.getString("tel3"));
			dto.setEmail(rs.getString("email"));
			dto.setYear(rs.getString("year"));
			dto.setMonth(rs.getString("month"));
			dto.setDay(rs.getString("day"));

		}

		rs.close();
		pstmt.close();
	
		return dto;
		
		
		
		
		
	}
	// Tx.start()
	public static void TxStart() throws Exception {
	    if (conn != null) {
	        conn.setAutoCommit(false);
	        System.out.println("트랜잭션 시작!!!!");
	    }
	}

	//Tx.Commit()
	public static void TxCommit() throws Exception {
	    if (conn != null) {
	        conn.commit();
	        conn.setAutoCommit(true); // 원래 상태로 돌려놓기
	        System.out.println("트랜잭션 커밋!!!!");
	    }
	}

	// Tx.rollback()
	public static void TxRollBack() throws Exception {
	    if (conn != null) {
	        conn.rollback();
	        conn.setAutoCommit(true);
	        System.out.println("문제 발생 트랜잭션 롤백!!!!");
	    }
	}
	    //Tx.End()
	    public static void TxEnd() throws Exception {
	        if (conn != null) {
	            try {
	                conn.setAutoCommit(true);  // 다시 기본 상태로 돌려놓음
	            } catch (Exception e) {
	                e.printStackTrace();
	            } finally {
	                disConn();  // 자원 정리 (rs, pstmt, conn)
	                System.out.println("트랜잭션 종료!!!");
	            }
	        }
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
