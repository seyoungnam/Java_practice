//ClientDAO의 역할 : client 명부 DB이자, DB에서 수행 가능한 crud 기능 정의
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.ClientDTO;
import model.util.DBUtil;

public class ClientDAO {
	//singleton 생성
	private static ClientDAO instance = new ClientDAO();	
	private ClientDAO() {}
	public static ClientDAO getInstance() {
		return instance;
	}
	

	//DB 내 모든 정보 불러오기
	public ArrayList<ClientDTO> getAll() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ClientDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from clientlist");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<ClientDTO>();
			while(rset.next()) {
				list.add(new ClientDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4)));
			}
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	
	//create(insert) 기능 : 신규회원 등록
	public boolean addClinet(ClientDTO clientInfo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into clientlist values(clientlist_id_seq.nextval, ?, ?, ?)");
			pstmt.setString(1, clientInfo.getName());
			pstmt.setString(2, clientInfo.getCountry());
			pstmt.setInt(3, clientInfo.getAge());
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return true;
			}
		}finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	
	//read(search) 기능 : 회원 이름 검색하면 해당 회원 나머지 정보 return
	public ClientDTO getClientInfo(String name) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ClientDTO info = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from clientlist where name=?");
			pstmt.setString(1, name);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				info = new ClientDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4));
			}
			
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return info;
	}
	
	
	//update 기능 : 회원정보 수정(이름을 검색한 후 country와 age를 수정)
	public boolean updateClientInfo(ClientDTO clientInfo) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update clientlist set country=?, age=? where name=?");
			pstmt.setString(1, clientInfo.getCountry());
			pstmt.setInt(2, clientInfo.getAge());
			pstmt.setString(3, clientInfo.getName());
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return true;
			}
		}finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//delete 기능 : 회원 삭제
	public boolean deleteClientInfo(String name) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from clientlist where name=?");
			pstmt.setString(1, name);
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return true;
			}
		}finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
}
