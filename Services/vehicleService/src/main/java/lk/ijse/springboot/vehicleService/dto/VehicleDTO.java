package lk.ijse.springboot.vehicleService.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VehicleDTO {
    private String vehicleId;
    private String vehicleBrand;
    private String fuelType;
    private String hybrid_or_Non_Hybrid;
    private int fuelUsage;
    private String transmissionType;
    private byte[] driverLicenseImage;
    private String contactNo;
    private String DriverName;
    private byte[] ImagesVehicle;
    private int SeatCapacity;
    private String remarks;
    private String vehicleType;

}
