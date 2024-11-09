package fall24.hsf301.slot1.repository;

import java.util.List;

import fall24.hsf301.slot1.dao.HStudentDAO;
import fall24.hsf301.slot1.dao.IStudentDAO;
import fall24.hsf301.slot1.dao.StudentDAO;
import fall24.hsf301.slot1.pojo.Student;

public class StudentRepo implements IStudentRepo {

	private IStudentDAO studentDAO;

	public StudentRepo(String jpaName, int type) {
		if (type == 2) {
			studentDAO = new StudentDAO(jpaName);
		} else {
			studentDAO = new HStudentDAO(jpaName);
		}
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentDAO.save(student);
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentDAO.getStudents();
	}

	@Override
	public void delete(int studentID) {
		// TODO Auto-generated method stub
		studentDAO.delete(studentID);
	}

	@Override
	public Student findById(int studentID) {
		// TODO Auto-generated method stub
		return studentDAO.findById(studentID);
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		studentDAO.update(student);
	}

}
