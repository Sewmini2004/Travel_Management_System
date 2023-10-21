package lk.ijse.springboot.travelService.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lk.ijse.springboot.travelService.dto.DurationDto;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity

public class Travel implements Super {
    @Id

    private String packageId;
    private String userId;
    private String hotelId;
    private String guideId;
    private String vehicleId;
    @Embedded
    private DurationDto travelDurationDto;
    private String travelArea;
    private int noOfAdults;
    private int noOfChildren;
    private byte[] userNIC_images;
    private String needGuideOrNo;
    private int totalHeadcount;
    private boolean withPetsOrNo;
    private double paidValue;
    @Embedded
    private  PackageValue packageValue;
}
