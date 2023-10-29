package lk.ijse.springboot.guideService.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GuideDTO {
    private String guideId;
    private String guideName;
    private String guideAddress;
    private MultipartFile guideIdImage;
    private String gender;
    private String contactNumber;
    private  MultipartFile nicImage;
    private String Experience;
    private int manDayValue;
    private String remarks;
}
