package fr.MEGEMONT_Thibault.exam.rest_controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.MEGEMONT_Thibault.exam.DTO.UserDTO;
import fr.MEGEMONT_Thibault.exam.entity.User;
import fr.MEGEMONT_Thibault.exam.json_views.JsonViews;
import fr.MEGEMONT_Thibault.exam.repository.UserRepository;
import fr.MEGEMONT_Thibault.exam.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user/")
public class UserRestController {

    private UserRepository Repository;

    private UserService userService;

    @GetMapping
    @JsonView(JsonViews.UserListView.class)
    public List<User> list() {
        return this.Repository.findAll();
    }

    @GetMapping(path = "/{id}")
    @JsonView(JsonViews.UserListView.class)
    public Optional<User> show(@PathVariable Long id) {
            return this.Repository.findById(id);
    }

    @PostMapping
    @JsonView(JsonViews.UserListView.class)
    User create(@Valid @RequestBody UserDTO userDTO) {
        return userService.create(userDTO);
    }

    @PutMapping(path = "/{id}")
    @JsonView(JsonViews.UserListView.class)
    User edit(@Valid @RequestBody UserDTO userDTO, @PathVariable Long id) {
        return userService.edit(id, userDTO);
    }

}
