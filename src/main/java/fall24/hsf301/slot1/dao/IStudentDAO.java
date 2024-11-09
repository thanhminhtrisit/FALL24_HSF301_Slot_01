package fall24.hsf301.slot1.dao;

import java.util.List;

import fall24.hsf301.slot1.pojo.Student;

public interface IStudentDAO {
	public void save(Student student);

	public List<Student> getStudents();

	public void delete(int studentID);

	public Student findById(int studentID);

	public void update(Student student);
}
