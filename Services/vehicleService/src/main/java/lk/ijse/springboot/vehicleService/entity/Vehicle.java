package lk.ijse.springboot.vehicleService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.awt.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity

public class Vehicle implements Super {
    @Id
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
    @ManyToOne
    private VehicleCategory vehicleCategory;




}
