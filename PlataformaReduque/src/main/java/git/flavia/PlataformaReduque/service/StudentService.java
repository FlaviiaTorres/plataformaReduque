package git.flavia.PlataformaReduque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import git.flavia.PlataformaReduque.model.Student;
import git.flavia.PlataformaReduque.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student getStudentByName(String name) {
        return studentRepository.findByName(name);
    }
    
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        return studentRepository.findById(id)
            .map(student -> {
            	student.setName(updatedStudent.getName());
            	student.setSurname(updatedStudent.getSurname());
            	student.setEmail(updatedStudent.getEmail());
            	student.setPassword(updatedStudent.getPassword());
                return studentRepository.save(student);
            })
            .orElse(null);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}