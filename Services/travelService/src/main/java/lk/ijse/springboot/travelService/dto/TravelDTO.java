package lk.ijse.springboot.travelService.dto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
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

    private long packageId;
    private long userId;
    private long hotelId;
    private long guideId;
    private long vehicleId;
    private DurationDto travelDurationDto;
    @NotNull(message = "TravelArea shouldn't be null")
    private String travelArea;
    @Positive(message = " Adult count shouldn't be empty")
    @Min(value = 1, message = "Adult count shouldn't be less than 1")
    private int noOfAdults;
    @Positive(message = " Child count shouldn't be empty")
    @Min(value = 0, message = "Child  count shouldn't be less than 0")
    private int noOfChildren;
    @NotNull(message = " User's NIC images BackEnd shouldn't be empty")
    @Column(columnDefinition = "LONGTEXT")
    private MultipartFile userNIC_images;
    @NotNull(message = " need Guide Or No shouldn't be empty")
    private boolean needGuideOrNo;
    @Positive(message = " Total head count shouldn't be empty")
    @Min(value = 1, message = "Total head count shouldn't be less than 1")
    private int totalHeadcount;
    @NotNull(message = " With Pets Or No shouldn't be empty")
    private boolean withPetsOrNo;
    @Positive(message = " paid Value shouldn't be empty")
    @Min(value = 0, message = "paid Value shouldn't be less than 0")
    private double paidValue;
    private PackageValueDto packageValue;

}