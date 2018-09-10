package in.cyclonia.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.cyclonia.register.model.Student;
import in.cyclonia.register.services.StudentService;

@Controller
public class StudentController {
	
	private StudentService service;
	
	@Autowired
	public void setService(StudentService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public String listStudents(Model model) {
		
		model.addAttribute("students",service.listAllStudents());
		return "students";
		
	}
	
	@RequestMapping(value="/students/{id}")
	public String listStudentById(@PathVariable Integer id, Model model) {
		
		model.addAttribute("student",service.getStudentById(id));
		return "studentshow";
		
	}

	@RequestMapping(value="/students/edit/{id}")
	public String editStudentById(@PathVariable Integer id, Model model) {
		
		model.addAttribute("student",service.getStudentById(id));
		return "studentform";
		
	}

	@RequestMapping("/student/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        return "studentform";
    }
	
	@RequestMapping(value = "student", method = RequestMethod.POST)
    public String saveStudent(Student student) {
        service.saveStudent(student);
        return "redirect:/students";
    }

   
    @RequestMapping("student/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteStudent(id);
        return "redirect:/students";
    }

}
