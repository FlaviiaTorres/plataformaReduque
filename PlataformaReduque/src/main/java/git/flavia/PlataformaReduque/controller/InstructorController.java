package git.flavia.PlataformaReduque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import git.flavia.PlataformaReduque.model.Instructor;

import git.flavia.PlataformaReduque.service.InstructorService;


@RestController
@RequestMapping("/instructor")
public class InstructorController {
	
	@Autowired
    private InstructorService instructorService;

    @GetMapping
    public List<Instructor> getAllInstructor() {
        return instructorService.getAllInstructor();
    }

    @GetMapping("/byInstructor/{id}")
    public Instructor getInstructorById(@PathVariable Long id) {
        return instructorService.getInstructorById(id);
    }
    
    @GetMapping("/byName/{name}")
    public Instructor getUserByInstructorName(@PathVariable String nameInstructor) {
        return instructorService.getInstructorByName(nameInstructor);
    }

    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return instructorService.createInstructor(instructor);
    }

    @PutMapping("/updateInstructor/{id}")
    public Instructor updateInstructor(@PathVariable Long id, @RequestBody Instructor instructor) {
        return instructorService.updateInstructor(id, instructor);
    }

    @DeleteMapping("/deleteInstructor/{id}")
    public void deleteInstructor(@PathVariable Long id) {
    	instructorService.deleteInstructor(id);
    }
}


