package lk.ijse.springboot.apigateway.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

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
    private MultipartFile driverLicenseImage;
    private String contactNo;
    private String DriverName;
    private MultipartFile ImagesVehicle;
    private int SeatCapacity;
    private String remarks;
    private String vehicleType;

}
