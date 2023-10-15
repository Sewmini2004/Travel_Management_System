package lk.ijse.springboot.hotelService.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity

public class Hotel implements Super {
    @Id
    private String hotelId;
    private String hotelName;
    private String hotelLocation;
    private String address;
    private String hotelEmail;
    @Embedded
    private Contact contactNumber;
    private double hotelFee;
    private String hotelCategory;
    private String petsAllowedOrNot;
    private String remarks;

}
