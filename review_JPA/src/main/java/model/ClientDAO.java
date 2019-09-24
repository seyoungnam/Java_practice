//ClientDAO의 역할 : client 명부 DB이자, DB에서 수행 가능한 crud 기능 정의
package model;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.domain.ClientDTO;
import model.util.DBUtil;

public class ClientDAO {
	//singleton 생성
	private static ClientDAO instance = new ClientDAO();	
	private ClientDAO() {}
	public static ClientDAO getInstance() {
		return instance;
	}
	
	
	//기존 회원 정보 DB에 저장
	public boolean inputClientInfo(List<ClientDTO> clients) throws SQLException {
		EntityManagerFactory factory = DBUtil.getFactory();
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		boolean result = false;
		
		tx.begin();
		em.flush();
		em.clear();
		
		try {
			for (ClientDTO v : clients) {
				em.persist(v);
			}
			tx.commit();
			result = true;
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		return result;
	}
	

	//DB 내 모든 정보 불러오기
	public List<ClientDTO> getAll() throws SQLException{
		EntityManagerFactory factory = DBUtil.getFactory();
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		List<ClientDTO> result = null;
		
		tx.begin();
		em.flush();
		em.clear();
		
		try {
			result = em.createQuery("select m from clientlist m", ClientDTO.class).getResultList();
			
		}catch(Exception s) {
			s.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		return result;
	}
	
	
	//create(insert) 기능 : 신규회원 등록
	public boolean addClinet(ClientDTO clientInfo) throws SQLException {
		EntityManagerFactory factory = DBUtil.getFactory();
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		boolean result = false;
		
		tx.begin();
		em.flush();
		em.clear();
		
		try {
			em.persist(clientInfo);
			tx.commit();
			result = true;
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		return result;
	}
	
	
	//read(search) 기능 : 회원 이름 검색하면 해당 회원 나머지 정보 return
	public ClientDTO getClientInfo(String name) throws SQLException {
		EntityManagerFactory factory = DBUtil.getFactory();
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		ClientDTO result = null;
		
		tx.begin();
		em.flush();
		em.clear();
		
		try {
			List<ClientDTO> clients = em.createQuery("select m from clientlist m where name = :v", ClientDTO.class).setParameter("v", name).getResultList();
			for(ClientDTO client : clients) {
				result = em.find(ClientDTO.class, client.getId());
			}
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		return result;
	}
	
	
	//update 기능 : 회원정보 수정(이름을 검색한 후 country와 age를 수정)
	public boolean updateClientInfo(ClientDTO clientInfo) throws SQLException{
		EntityManagerFactory factory = DBUtil.getFactory();
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		ClientDTO info = null;
		boolean result = false;
		
		tx.begin();
		em.flush();
		em.clear();
		
		try {
			List<ClientDTO> clients = em.createQuery("select m from clientlist m where name = :v", ClientDTO.class).setParameter("v", clientInfo.getName()).getResultList();
			for(ClientDTO client : clients) {
				info = em.find(ClientDTO.class, client.getId());
				info.setCountry(clientInfo.getCountry());
				info.setAge(clientInfo.getAge());
			}
			tx.commit();
			result = true;
		}catch(Exception s) {
			s.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		return result;
	}
	
	//delete 기능 : 회원 삭제
	public boolean deleteClientInfo(String name) throws SQLException {
		EntityManagerFactory factory = DBUtil.getFactory();
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		ClientDTO target = null;
		boolean result = false;
		
		tx.begin();
		em.flush();
		em.clear();
		
		try {
			List<ClientDTO> clients = em.createQuery("select m from clientlist m where name = :v", ClientDTO.class).setParameter("v", name).getResultList();
			for(ClientDTO client : clients) {
				target = em.find(ClientDTO.class, client.getId());
				em.remove(target);
			}
			tx.commit();
			result = true;
		}catch(Exception s) {
			s.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		return result;
	}
}
