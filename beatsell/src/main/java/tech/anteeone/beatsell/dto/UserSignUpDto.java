package tech.anteeone.beatsell.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Data
@Validated
public class UserSignUpDto {
    @Email(message = "Email is not correct")
    @NotBlank(message = "Please fill the email")
    private String email;

    @NotBlank(message = "Please fill the password")
    private String password;
    private String password2;

}
