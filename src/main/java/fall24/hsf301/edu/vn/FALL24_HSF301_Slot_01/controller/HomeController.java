package fall24.hsf301.edu.vn.FALL24_HSF301_Slot_01.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fall24.hsf301.slot1.pojo.Student;
import fall24.hsf301.slot1.service.IStudentService;
import fall24.hsf301.slot1.service.StudentService;

@Controller
public class HomeController {

	private IStudentService iStudentService ;
	
	public HomeController() {
		
	}
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		iStudentService = new StudentService("JPAs", 2);
		ModelAndView model =  new ModelAndView("home");
		List<Student> studentList = iStudentService.getStudents();
		System.out.println(studentList.size());
		model.addObject("studentList",studentList);
		return model;
	}
	
	@RequestMapping(value="/manageStudent")
	public String manageStudent(HttpServletRequest request) throws IOException{
		iStudentService = new StudentService("JPAs", 2);
		String actionValue = request.getParameter("btnManageStudent");
		int id= Integer.parseInt(request.getParameter("txtID"));
		String firstName = request.getParameter("txtFirstName");
		String lastName = request.getParameter("txtLastName");
		int mark = Integer.parseInt(request.getParameter("txtMark"));
		Student student = new Student(id, firstName, lastName, mark);
		switch (actionValue) {
		case "add":
			iStudentService.save(student);
			break;
		case "update":
			iStudentService.update(student);
			break;
		case "delete":
			iStudentService.delete(id);
			break;
		default:
			break;
		}
		return "redirect:/";
	}
	
	
}
