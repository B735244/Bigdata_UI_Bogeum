package Ch04;

import java.sql.Connection;// DB와 Eclipse를 연결해준다.
import java.sql.DriverManager;// DB 접속을 관리해주는 DriverManager
import java.sql.PreparedStatement;// SQL쿼리문을 사용할 준비해주는 PreparedStatement
import java.sql.ResultSet; // Select문에서 While문으로 돌면서 데이터 추출

import Ch02.MemberDto;// Ch02.MemberDto를 쓰겠다.

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

	public static void conn() throws Exception {// 예외는 다 던지고 DBMS와 DB연결!!!
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loading Success...");
		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("DB CONNECTED...");
	}

	public static void disConn() throws Exception {// 연결을 끊는 함수를 하나 만들어서 묶어서 처리했다.
		// rs / pstmt / conn close
		// 닫지 않고 계속 켜두면 메모리를 잡아먹기 때문에 반드시 닫아줘야 합니다.
		if (rs != null)
			rs.close();//
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}

//DB에 입력받은 값을 저장하는 함수.
	public static int insertMember(MemberDto memberDto) throws Exception {

		pstmt = conn.prepareStatement("insert into tbl_member values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		// pstmt라는 객체를 만들어 두고
		// 나중에 뒤에 오는 getter/setter 함수를 통해서 순서대로 입력받은 값을 저장한다!
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
		// DB에서 실제로 몇개의 행이 실행했는지 보여주는 result 값이다.
		// result값을 반환하면 나중에 회원가입의 성공 여부를 판단할 때,
		// result값이 0보다 작거나 같으면 회원가입에 실패했다고 판단 할 수 있다.
	}

	public static MemberDto selectMember(String userid) throws Exception {
		pstmt = conn.prepareStatement("select * from tbl_member where userid = ?");

		pstmt.setString(1, userid);
		// 우선 ? 값에 입력받은 userid를 저장해주어야 그 다음이 실행되는것이지 아니면 실행이 불가능함.
		// 흐름을 이해해 두는것이 중요.
		rs = pstmt.executeQuery();

		MemberDto dto = null;
		// 아직 dto 변수만 선언해두고 null로 초기화 시킨다.
		// DB조회 결과를 모르기때문!

		if (rs != null && rs.next()) {
			// resultset이 있는지 확인하고 + 다음에 오는 행에 값이 있는지 확인
			dto = new MemberDto();
			// 조건문이 맞으면 이제 MemberDto객체를 만들고 값을 저장한다!
			// rs객체에서 속성값들을 꺼내서 dto에 각각 저장한다!!
			dto.setUserid(rs.getString("userid"));
			dto.setPassword(rs.getString("password"));
			dto.setRePassword(rs.getString("rePassword"));
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
//메모리를 잡아먹기 때문에 닫아줍니다. 가장 최근에 만든 순서대로 닫아야 합니다!
		rs.close();
		pstmt.close();
//return값이 MemberDto이기에 dto객체를 return 해줍니다.
		return dto;

	}

	// Tx.start()
 
	public static void TxStart() throws Exception {
		if (conn != null) {
			conn.setAutoCommit(false);
			System.out.println("트랜잭션 시작!!!!");
		}
	}

	

	// Tx.rollback()
	// 값을 다 입력받고 이제 문제없이 DB에 저장을 하려고 할 때
	// 동일한 계정이 있는 지, insertMember에서 insert에 실패해서 result값이 
	// 0보다 작거나 같을 떄 트랜잭션을 Rollback 해줍니다.
	public static void TxRollBack() throws Exception {
		if (conn != null) {
			conn.rollback();
			conn.setAutoCommit(true);
			System.out.println("문제 발생 트랜잭션 롤백!!!!");
		}
	}

	// Tx.End()
	// 회원가입 처리가 완료되었다면
	// 트랜잭션을 끝내는 TxEnd()를 호출하여
	// 트랙잭션을 끝내고 할당받은 메모리까지 전부 닫아주어
	// 트랜잭션을 끝내줍니다.
	public static void TxEnd() throws Exception {
		if (conn != null) {
			try {
				conn.setAutoCommit(true); 
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				disConn(); // 할당받은 자원, 메모리 삭제시키기!
				System.out.println("트랜잭션 종료!!!");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
