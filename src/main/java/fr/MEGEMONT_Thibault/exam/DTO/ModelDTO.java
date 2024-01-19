package fr.MEGEMONT_Thibault.exam.DTO;

import fr.MEGEMONT_Thibault.exam.repository.BrandRepository;
import fr.MEGEMONT_Thibault.exam.validator.annotation.UniqueName;
import fr.MEGEMONT_Thibault.exam.validator.group.ValidationGroup;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ModelDTO {

    @NotBlank(
            message = "The name must have a value",
            groups = ValidationGroup.OnPutItem.class
    )
    @UniqueName(
            repositoryClass = BrandRepository.class,
            groups = ValidationGroup.OnPostItem.class
    )
    private String name;

    @NotNull(message = "The Brand is required")
    @Positive(message = "The brand id has to be positive")
    private Long brand_id;
}
