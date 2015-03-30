package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import user.common.JDBCUtil;
import user.vo.UserVO;

public class UserDAOImpl_JDBC implements UserDAO {

	@Override
	public UserVO login(String userid, String userpwd) {

		// 필요한 변수 선언
		Connection con = null;
		PreparedStatement ps = null;
		String loginSql = "select * from userinfo where userid=? and userpwd = ?";
		ResultSet rs = null;
		UserVO vo = null;

		// 1.DB 연결
		con = JDBCUtil.getConnection();

		// 2. sql 쿼리 삽업
		try {
			ps = con.prepareStatement(loginSql);
			// 3. 데이터 바인딩
			ps.setString(1, userid);
			ps.setString(2, userpwd);
			// 4. 쿼리 실행
			rs = ps.executeQuery();
			// 5. select 한 데이터 추출
			while (rs.next()) {
				vo = new UserVO();
				// 6. vo 객체에 조회한 데이터를 set 함
				vo.setUserid(rs.getString("userid"));
				vo.setUserpwd(rs.getString("userpwd"));
				vo.setUsername(rs.getString("username"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 7. 할당한 자원을 반납하는 작업을 진행(필수)
			JDBCUtil.close(rs , ps , con);
		}

		// TODO Auto-generated method stub
		return vo;
	}

}
