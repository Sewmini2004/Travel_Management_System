package lk.ijse.springboot.apigateway.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class HotelDTO {
    private String hotelId;
    private String hotelName;
    private String hotelLocation;
    private String address;
    private String hotelEmail;
    private String contactNumber_1;
    private String contactNumber_2;
    private double hotelFee;
    private String petsAllowedOrNot;
    private String remarks;
}
