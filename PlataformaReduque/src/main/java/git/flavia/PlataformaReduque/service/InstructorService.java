package git.flavia.PlataformaReduque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import git.flavia.PlataformaReduque.model.Instructor;
import git.flavia.PlataformaReduque.repository.InstructorRepository;


@Service
public class InstructorService {
	
	 @Autowired
	    private InstructorRepository instructorRepository;

	    public List<Instructor> getAllInstructor() {
	        return instructorRepository.findAll();
	    }

	    public Instructor getInstructorById(Long id) {
	        return instructorRepository.findById(id).orElse(null);
	    }

	    public Instructor getInstructorByName(String nameInstructor) {
	        return instructorRepository.findByName(nameInstructor);
	    }
	    
	    public Instructor createInstructor(Instructor instructor) {
	        return instructorRepository.save(instructor);
	    }

	    public Instructor updateInstructor(Long id, Instructor updateinstructor) {
	        return instructorRepository.findById(id)
	            .map(instructor -> {
	            	instructor.setNameInstructor(updateinstructor.getNameInstructor());
	            	instructor.setSurnameInstructor(updateinstructor.getSurnameInstructor());
	            	instructor.setEmailInstructor(updateinstructor.getEmailInstructor());
	            	instructor.setFormacao(updateinstructor.getFormacao());
	                return instructorRepository.save(instructor);
	            })
	            .orElse(null);
	    }

	    public void deleteInstructor(Long id) {
	        instructorRepository.deleteById(id);
	    }
	}


