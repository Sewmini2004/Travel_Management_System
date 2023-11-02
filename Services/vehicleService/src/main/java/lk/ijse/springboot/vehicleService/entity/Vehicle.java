package lk.ijse.springboot.vehicleService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.awt.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity

public class Vehicle implements Super {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long vehicleId;
    @NotBlank(message = "Vehicle Brand shouldn't be blank")
    private String vehicleBrand;
    @NotNull(message = "FuelType shouldn't be empty")
    private String fuelType;
    private String hybrid_or_Non_Hybrid;
    @Positive(message = "Fuel Usage shouldn't be empty")
    @Min(value = 1, message = "fuel Usage shouldn't be less than 1")
    @Max(value = 200, message = "fuel Usage shouldn't be greater than 100")
    private int fuelUsage;
    @NotEmpty(message = "TransmissionType shouldn't be empty")
    private String transmissionType;
    @NotNull(message = "Driver License Image shouldn't be empty")
    @Column(columnDefinition = "LONGTEXT")
    private String driverLicenseImage;
    @NotBlank(message = "ContactNo shouldn't be blank")
    @Pattern(regexp ="^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$" , message = "Invalid contact number")
    private String contactNo;
    @NotNull(message = "Driver's name shouldn't be null")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$" , message ="Invalid driver's name")
    private String DriverName;
    @NotNull(message = "Vehicle Image shouldn't be empty")
    @Column(columnDefinition = "LONGTEXT")
    private String ImagesVehicle;
    @Positive(message = "Seat Capacity shouldn't be empty")
    @Min(value = 4, message = "Seat Capacity shouldn't be less than 4")
    @Max(value = 200, message = "Seat Capacity shouldn't be greater than 40")
    private int SeatCapacity;
    @NotEmpty(message = "Remarks shouldn't be empty")
    private String remarks;
    @NotEmpty(message = "vehicle Type shouldn't be empty")
    private String vehicleType;
    @ManyToOne
    private VehicleCategory vehicleCategory;
}
