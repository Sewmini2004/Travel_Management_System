package lk.ijse.springboot.guideService.dto;
import jakarta.validation.constraints.*;
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

    private long guideId;
    @NotNull(message = "Guide name shouldn't be null")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$" , message ="Invalid guide name")
    private String guideName;
    String nicNumber;
    @NotNull(message = "Guide address shouldn't be null ")
   /* @Pattern(regexp ="^[a-zA-Z0-9\\\\s,.'-]+[a-zA-Z0-9\\\\s,.'-]+[a-zA-Z0-9\\\\s,.'-]+$"
    , message = "Invalid  guide address")*/
    private String guideAddress;
    @NotNull(message = "Guide's Id images shouldn't be empty")
    private MultipartFile guideIdImage;
    @NotEmpty(message = "Gender shouldn't be empty")
    private String gender;
    @NotBlank(message = "Contact No shouldn't be blank")
    @Pattern(regexp ="^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$" , message = "Invalid contact number")
    private String contactNumber;
    @NotNull(message = "Guide's NIC Images FrontEnd shouldn't be empty")
    private MultipartFile nicImageFrontEnd;
    @NotNull(message = "Guide's NIC Images BackEnd shouldn't be empty")
    private MultipartFile nicImageBackEnd;
    @NotEmpty(message = "Experience shouldn't be empty")
    private String Experience;
    @Positive(message = " Man day value shouldn't be empty")
    @Min(value = 0, message = "Man day value shouldn't be less than 0")
    private int manDayValue;
    @NotEmpty(message = "Remarks shouldn't be empty")
    private String remarks;

}
