package in.cyclonia.register.repository;

import org.springframework.data.repository.CrudRepository;

import in.cyclonia.register.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
