package lk.ijse.springboot.apigateway.dto;

import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class TravelDTO {

    private String packageId;
    private Duration travelDuration;
    private String travelArea;
    private int noOfAdults;
    private int noOfChildren;
    private byte[] userNIC_images;
    private String needGuideOrNo;
    private int totalHeadcount;
    private boolean withPetsOrNo;
    @Embedded
    private PackageValue packageValue;

}