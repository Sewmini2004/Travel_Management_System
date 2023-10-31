package lk.ijse.springboot.userService.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDTO {
    private long userId;
    private String username;
    private String userNIC;
    private String address;
    private String userNICImagesFrontEnd;
    private String userNIC_imagesBackEnd;
    private String gender;
    private String email;
    private String role;
    private String remarks;

}
