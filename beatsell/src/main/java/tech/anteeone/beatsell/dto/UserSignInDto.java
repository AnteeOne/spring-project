package tech.anteeone.beatsell.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class UserSignInDto {
    @Email(message = "Email is not correct")
    @NotNull(message = "Please fill the email")
    @Max(value = 128, message = "Email too long")
    private String email;

    @NotNull(message = "Please fill the password")
    @Min(value = 8, message = "The password must contain at least 8 characters ")
    @Max(value = 128, message = "Password too long")
    private String password;
}
