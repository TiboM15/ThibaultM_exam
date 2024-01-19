package fr.MEGEMONT_Thibault.exam.service;

import fr.MEGEMONT_Thibault.exam.DTO.UserDTO;
import fr.MEGEMONT_Thibault.exam.entity.Brand;
import fr.MEGEMONT_Thibault.exam.entity.User;
import fr.MEGEMONT_Thibault.exam.exception.NotFoundCentralishException;
import fr.MEGEMONT_Thibault.exam.repository.UserRepository;
import fr.MEGEMONT_Thibault.exam.service.interfaces.DAOServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements DAOServiceInterface<User> {

    private UserRepository userRepository;


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User getObjectById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundCentralishException("User", "id", id);
        }
        return optionalUser.get();
    }

    public User create(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail().toLowerCase());
        user.setPassword(userDTO.getPassword());

        return userRepository.saveAndFlush(user);
    }

    public User edit(Long id, UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.orElseThrow(() -> new NotFoundCentralishException("User", "id", id));
        User user = optionalUser.get();
        if (!userDTO.getPassword().isEmpty()) {
            user.setPassword(userDTO.getPassword());
        }
        user.setRoles(userDTO.getRoles());

        userRepository.flush();
        return user;
    }
}