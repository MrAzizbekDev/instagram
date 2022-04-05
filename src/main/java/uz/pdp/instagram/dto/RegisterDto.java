package uz.pdp.instagram.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    @Size(min = 3, max = 50) @NotNull
    private String fullName;

    @Size(min = 12,max = 12) @NotNull
    private String phone;

    private Integer attachmentId=1;
    @Email
    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String prePassword;

    public RegisterDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
