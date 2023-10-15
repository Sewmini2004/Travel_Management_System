package lk.ijse.springboot.apigateway.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GuideDTO {
    private String guideId;
    private String guideName;
    private String guideAddress;
    private byte[] guideIdImage;
    private String gender;
    private String contactNumber;
    private byte[] nicImage;
    private String Experience;
    private int manDayValue;
    private String remarks;
}
