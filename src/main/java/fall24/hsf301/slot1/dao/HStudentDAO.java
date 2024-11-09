package fall24.hsf301.slot1.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import fall24.hsf301.slot1.pojo.Student;



public class HStudentDAO implements IStudentDAO{
	private SessionFactory sessionFactory;
	private Configuration cf;
	public HStudentDAO(String hibernateConfig) {
		cf = new Configuration().configure(hibernateConfig);
		sessionFactory = cf.buildSessionFactory();
	}
	public void save(Student student) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(student);
			t.commit();
			System.out.println("Successfully saved");
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			System.out.println("Error" + e.getMessage());
		} finally {
			//sessionFactory.close();
			//session.close();
		}
	}
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();
		Session session = sessionFactory.openSession();
		try {
			students = session.createQuery("from Student", Student.class).list();

		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		} finally {
		}
		return students;
	}
	public void delete(int studentId) {
		Session session = sessionFactory.openSession();
		Student student = (Student) session.get(Student.class,studentId);
		session.delete(student);
	//	t.commit();
		System.out.println("Delete saved");
	}
	
	public Student findById(int studentId) {
		Session session = sessionFactory.openSession();
		return (Student) session.get(Student.class,studentId);
	}
	
	public void update(Student student) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(student);
			t.commit();
			System.out.println("Update successfully");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error "+e.getMessage());
		} finally {
			//sessionFactory.close();
			//session.close();
		}
	}
}
