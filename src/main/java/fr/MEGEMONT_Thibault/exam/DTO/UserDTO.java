package fr.MEGEMONT_Thibault.exam.DTO;

import fr.MEGEMONT_Thibault.exam.validator.annotation.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    @Email(message = "Please, give a valid email")
    @NotBlank(message = "Please, give an email")
    // On peut réécrire les valeurs des champs de l'annotation
    @UniqueEmail(example = "TOTO, MAIS DU DTO")
    private String email;

    @NotBlank(message = "Please, the password must have a value")
    @Size(message = "The password must have at least 8 characters", min = 8)
    private String password;

    private String roles;

}
