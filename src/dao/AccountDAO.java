package dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.JDBCException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Account;

import factory.HibernateUtil;


public class AccountDAO {
	HibernateUtil util = new HibernateUtil();
	
	// 保存用户
	public void saveAccount(Account account) throws SQLException{
		Session session = util.getSession();
		Transaction tr = null;
		try{
			tr = session.beginTransaction();
			session.save(account);
			tr.commit();
		}catch(JDBCException ex){
			if(ex != null){
				tr.rollback();
				throw ex.getSQLException();
			}
		}finally{
			util.closeSession(session);
		}
	}
	
	
	
	public Account loginByRenren(String renrenid){
//		password = new MD5(password).compute();
		Session session = util.getSession();
		try {
			Query query = session.createQuery("from Account a where a.renrenid = ?");
			query.setString(0, renrenid);
			List<Account> list = query.list();
			if (null == list || 0 == list.size()) {
				return null;
			}
			return list.get(0); 
		} catch (Exception e) {
			System.out.println("Account loginByRenren(String renrenid) 方法发生异常:");
			e.printStackTrace();
			return null;
		} finally {
			util.closeSession(session);
		}	
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Account a = new Account();
		new AccountDAO().saveAccount(a);
	}

}
