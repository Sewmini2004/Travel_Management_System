package lk.ijse.springboot.apigateway.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDTO {
    private String userId;
    private String username;
    private String userNIC;
    private String address;
    private byte[] userNIC_images;
    private String gender;
    private String email;
    private String remarks;
}
