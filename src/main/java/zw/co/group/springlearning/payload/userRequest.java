package zw.co.group.springlearning.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class userRequest {

    private String username;
    private String password;

    @Override
    public String toString() {
        return "userRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
