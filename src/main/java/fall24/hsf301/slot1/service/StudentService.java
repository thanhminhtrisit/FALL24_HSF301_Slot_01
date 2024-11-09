package fall24.hsf301.slot1.service;

import java.util.List;
import java.util.Scanner;

import fall24.hsf301.slot1.pojo.Book;
import fall24.hsf301.slot1.pojo.Student;
import fall24.hsf301.slot1.repository.IStudentRepo;
import fall24.hsf301.slot1.repository.StudentRepo;

public class StudentService implements IStudentService {

	private IStudentRepo studentRepo;

	public StudentService(String jpaName,int type) {
		studentRepo = new StudentRepo(jpaName,type);
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentRepo.save(student);
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentRepo.getStudents();
	}

	@Override
	public void delete(int studentID) {
		// TODO Auto-generated method stub
		studentRepo.delete(studentID);
	}

	@Override
	public Student findById(int studentID) {
		// TODO Auto-generated method stub
		return studentRepo.findById(studentID);
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		studentRepo.update(student);
	}

	@Override
	public Student readInputStudentInfomation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("First Name : ");
		String firstName  = sc.nextLine();
		System.out.println("Last Name : ");
		String lastName  = sc.nextLine();
		
		System.out.println("Marks : ");
		int mark  = sc.nextInt();
		
		return new Student(firstName,lastName,mark);
	}

	

}
