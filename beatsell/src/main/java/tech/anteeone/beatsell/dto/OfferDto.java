package tech.anteeone.beatsell.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
@Data
public class OfferDto {
    @NotNull(message = "Please fill the title")
    private String title;
    @NotNull(message = "Please fill the description")
    private String description;
}
