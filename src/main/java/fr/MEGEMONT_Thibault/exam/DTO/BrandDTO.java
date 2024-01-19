package fr.MEGEMONT_Thibault.exam.DTO;

import fr.MEGEMONT_Thibault.exam.repository.BrandRepository;
import fr.MEGEMONT_Thibault.exam.validator.annotation.UniqueName;
import fr.MEGEMONT_Thibault.exam.validator.group.ValidationGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BrandDTO {

    @NotBlank(
            message = "The name must have a value",
            groups = ValidationGroup.OnPutItem.class
    )
    @UniqueName(
            repositoryClass = BrandRepository.class,
            groups = ValidationGroup.OnPostItem.class
    )
    private String name;

}
