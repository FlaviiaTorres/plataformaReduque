package git.flavia.PlataformaReduque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Instructor {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 private String nameInstructor;
	 private String surnameInstructor;
	 private String emailInstructor;
	 private String formacao;

}
