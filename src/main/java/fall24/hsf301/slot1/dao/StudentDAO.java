package fall24.hsf301.slot1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fall24.hsf301.slot1.pojo.Student;


public class StudentDAO implements IStudentDAO{
	private static EntityManager em;
	private static EntityManagerFactory emf;

	public StudentDAO(String persistanceName) {
		emf = Persistence.createEntityManagerFactory(persistanceName);
	}

	public void save(Student student) {
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(student);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			System.out.println("Error " + ex.getMessage());
		} finally {
			//em.close();

		}

	}

	public List<Student> getStudents() {
		List<Student> students = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			students = em.createQuery("from Student").getResultList();
		} catch (Exception ex) {

			System.out.println("Error " + ex.getMessage());
		} finally {
			//em.close();
		}
		return students;

	}

	public void delete(int studentID) {
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Student s = em.find(Student.class, studentID);
			em.remove(s);
			em.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
		} finally {
			//em.close();
		}
	}

	public Student findById(int studentID) {
		Student student = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			student = em.find(Student.class, studentID);
		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
		} finally {
			//em.close();
		}
		return student;

	}

	public void update(Student student) {
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Student s = em.find(Student.class, student.getId());
			if (s != null) {
				s.setFirstName(student.getFirstName());
				s.setLastName(student.getLastName());
				s.setMark(student.getMark());
				em.getTransaction().commit();
			}
		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
		} finally {
			//em.close();
		}
	}
}
