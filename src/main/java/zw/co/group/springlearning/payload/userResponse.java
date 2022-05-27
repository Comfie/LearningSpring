package zw.co.group.springlearning.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class userResponse<T> {
    private int code;
    private String description;
    private T data;

    public userResponse(int code, String description, T data) {
        this.code = code;
        this.description = description;
        this.data = data;
    }
}
