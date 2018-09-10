package in.cyclonia.register.services;

import in.cyclonia.register.model.Student;

public interface StudentService {
	
	Iterable<Student> listAllStudents();
	Student getStudentById(Integer id);
	Student saveStudent(Student student);
	void deleteStudent(Integer id);

}
