package git.flavia.PlataformaReduque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import git.flavia.PlataformaReduque.model.Student;
import git.flavia.PlataformaReduque.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Student> getAllUsers() {
        return userRepository.findAll();
    }

    public Student getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Student getUserByName(String name) {
        return userRepository.findByName(name);
    }
    
    public Student createUser(Student user) {
        return userRepository.save(user);
    }

    public Student updateUser(Long id, Student updatedUser) {
        return userRepository.findById(id)
            .map(user -> {
                user.setName(updatedUser.getName());
                user.setSurname(updatedUser.getSurname());
                user.setEmail(updatedUser.getEmail());
                user.setPassword(updatedUser.getPassword());
                return userRepository.save(user);
            })
            .orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}