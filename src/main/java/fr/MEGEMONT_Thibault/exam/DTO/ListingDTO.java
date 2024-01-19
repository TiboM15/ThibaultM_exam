package fr.MEGEMONT_Thibault.exam.DTO;

import fr.MEGEMONT_Thibault.exam.validator.annotation.PastDate;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ListingDTO {

    @NotBlank(message = "The title has to have a value")
    private String title;


    @NotBlank(message = "The description has to have a value")
    private String description ;

    @NotNull(message = "The produced year has to be a proper year")
    private int producedYear;

    @DecimalMin(message = "The mileage has to be > 0", value = "1")
    @NotNull(message = "The mileage  has to be a proper value")
    private Long mileage;

    @DecimalMin(message = "The price has to be > 0", value = "1")
    @DecimalMax(message = "The country id has to be < 99999999", value = "99999999")
    @NotNull(message = "The price  has to be a proper price")
    private double price;

    @NotNull(message = "The image has to be a proper image")
    private String image;

    @NotNull(message = "The model_id year has to be a proper id")
    private Long model_id;

    @NotNull(message = "The user_id year has to be a proper id")
    private Long user_id;
}
