package lk.ijse.springboot.travelService.dto;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.*;
import lk.ijse.springboot.travelService.entity.PackageValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class TravelDTO {

    private String packageId;
    private String userId;
    private String hotelId;
    private String guideId;
    private String vehicleId;
    private DurationDto travelDurationDto;
    @NotNull(message = "TravelArea shouldn't be null")
    private String travelArea;
    @NotEmpty(message = " Adult count shouldn't be empty")
    @Min(value = 1, message = "Adult count shouldn't be less than 1")
    private int noOfAdults;
    @NotEmpty(message = " Child count shouldn't be empty")
    @Min(value = 0, message = "Child  count shouldn't be less than 0")
    private int noOfChildren;
    @NotEmpty(message = " User's NIC images BackEnd shouldn't be empty")
    private MultipartFile userNIC_images;
    @NotEmpty(message = " need Guide Or No shouldn't be empty")
    private boolean needGuideOrNo;
    @NotEmpty(message = " Total head count shouldn't be empty")
    @Min(value = 1, message = "Total head count shouldn't be less than 1")
    private int totalHeadcount;
    @NotEmpty(message = " With Pets Or No shouldn't be empty")
    private boolean withPetsOrNo;
    @NotEmpty(message = " paid Value shouldn't be empty")
    @Min(value = 0, message = "paid Value shouldn't be less than 0")
    private double paidValue;
    private PackageValueDto packageValue;

}