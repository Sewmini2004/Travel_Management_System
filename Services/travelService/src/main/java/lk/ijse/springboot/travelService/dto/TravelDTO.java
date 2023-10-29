package lk.ijse.springboot.travelService.dto;
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
    private DurationDto travelDurationDto;
    private String travelArea;
    private int noOfAdults;
    private int noOfChildren;
    private MultipartFile userNIC_images;
    private String needGuideOrNo;
    private int totalHeadcount;
    private boolean withPetsOrNo;
    private PackageValue packageValue;

}