package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class UpdateApp {

	public static void main(String[] args) throws IOException {
	


		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
             Student student = new Student();
             student.setSid(1);
             student.setSaddress("Mumbai");
             student.setSage(24);
             student.setSname("Amar");
             session.update(student);
				flag = true;
		    student = session.load(Student.class , 1);
				System.out.println("Student id is : "+student.getSid());
		    	System.out.println("Student name is : "+student.getSname());
		    	System.out.println("Student age is : "+student.getSage());
		    	System.out.println("Student address is : "+student.getSaddress());	
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				System.in.read();
				transaction.commit();
				System.out.println("Object updated to database....");
		
			} else {
				transaction.rollback();
				System.out.println("Object not updated to database...");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
