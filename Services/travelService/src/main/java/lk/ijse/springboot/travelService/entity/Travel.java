package lk.ijse.springboot.travelService.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lk.ijse.springboot.travelService.dto.DurationDto;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity

public class Travel implements Super {
    @Id
    @GeneratedValue
    private String packageId;
    private String userId;
    private String hotelId;
    private String guideId;
    private String vehicleId;
    @Embedded
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
    private String userNIC_images;
    @NotEmpty(message = " need Guide Or No shouldn't be empty")
    private String needGuideOrNo;
    @NotEmpty(message = " Total head count shouldn't be empty")
    @Negative
    @Min(value = 1, message = "Total head count shouldn't be less than 1")
    private int totalHeadcount;
    @NotEmpty(message = " With Pets Or No shouldn't be empty")
    private boolean withPetsOrNo;
    @NotEmpty(message = " paid Value shouldn't be empty")
    @Negative(message = " paid Value shouldn't be empty")
    @Min(value = 0, message = "paid Value shouldn't be less than 0")
    private double paidValue;
    @Embedded
    private  PackageValue packageValue;
}
