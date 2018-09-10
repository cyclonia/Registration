package in.cyclonia.register.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cyclonia.register.model.Student;
import in.cyclonia.register.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository repository;
	
	@Autowired
	public void setRepository(StudentRepository repository) {
		this.repository = repository;
	}

	@Override
	public Iterable<Student> listAllStudents() {
		
		return repository.findAll();
	}

	@Override
	public Student getStudentById(Integer id) {
		
		return repository.findOne(id);
	}

	@Override
	public Student saveStudent(Student student) {
		
		
		return repository.save(student);
	}

	@Override
	public void deleteStudent(Integer id) {
		repository.delete(id);
		
	}

}
