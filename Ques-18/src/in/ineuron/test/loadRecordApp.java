package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class loadRecordApp {

	public static void main(String[] args) {

		Session session = null;
		boolean flag = false;
		int id = 2;
		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				Student std=session.get(Student.class, id);
				if(std!=null) {
					System.out.println("STUDENT ID IS :: "+std.getSid());
					
					System.in.read();
					
					System.out.println("STUDENT NAME IS :: "+std.getSname());
					System.out.println("STUDENT ADDRESS IS :: "+std.getSaddress());
					System.out.println("STUDENT AGE IS :: "+std.getSage());
				}
				else {
					System.out.println("record not found");
				}
				
				
			}
		} catch (HibernateException e) {

		} catch (Exception e) {

		} finally {

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
