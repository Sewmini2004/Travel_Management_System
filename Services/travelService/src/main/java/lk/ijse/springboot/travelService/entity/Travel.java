package lk.ijse.springboot.travelService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long packageId;
    private long userId;
    private long hotelId;
    private long guideId;
    private long vehicleId;
    @Embedded
    private DurationDto travelDurationDto;
    @NotNull(message = "TravelArea shouldn't be null")
    private String travelArea;
    @Positive(message = " Adult count shouldn't be empty")
    @Min(value = 1, message = "Adult count shouldn't be less than 1")
    @Positive(message = " Child count shouldn't be empty")
    @Min(value = 0, message = "Child  count shouldn't be less than 0")
    private int noOfChildren;
    @NotNull(message = " User's NIC images BackEnd shouldn't be empty")
    @Column(columnDefinition = "LONGTEXT")
    private String userNIC_images;
    @NotEmpty(message = " need Guide Or No shouldn't be empty")
    private String needGuideOrNo;
    @Positive(message = " Total head count shouldn't be empty")
    @Min(value = 1, message = "Total head count shouldn't be less than 1")
    private int totalHeadcount;
    @NotEmpty(message = " With Pets Or No shouldn't be empty")
    private boolean withPetsOrNo;
    @Positive(message = " paid Value shouldn't be empty")
    @Min(value = 0, message = "paid Value shouldn't be less than 0")
    private double paidValue;
    @Embedded
    private  PackageValue packageValue;
}
