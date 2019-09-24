//ClientDAO�� ���� : client ��� DB����, DB���� ���� ������ crud ��� ����
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.ClientDTO;
import model.util.DBUtil;

public class ClientDAO {
	//singleton ����
	private static ClientDAO instance = new ClientDAO();	
	private ClientDAO() {}
	public static ClientDAO getInstance() {
		return instance;
	}
	

	//DB �� ��� ���� �ҷ�����
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
	
	
	//create(insert) ��� : �ű�ȸ�� ���
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
	
	
	//read(search) ��� : ȸ�� �̸� �˻��ϸ� �ش� ȸ�� ������ ���� return
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
	
	
	//update ��� : ȸ������ ����(�̸��� �˻��� �� country�� age�� ����)
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
	
	//delete ��� : ȸ�� ����
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
