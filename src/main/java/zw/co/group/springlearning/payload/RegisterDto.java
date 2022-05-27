package zw.co.group.springlearning.payload;

import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String firstname;
    private String lastName;
    private String email;
    private String phone;
}
