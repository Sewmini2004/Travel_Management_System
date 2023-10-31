package lk.ijse.springboot.userService.util;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class ResponseUtil {
    private int code;
    private String massage;
    private Object data;

}
