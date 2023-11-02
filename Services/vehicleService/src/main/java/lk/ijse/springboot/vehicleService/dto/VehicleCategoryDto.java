package lk.ijse.springboot.vehicleService.dto;


import lk.ijse.springboot.vehicleService.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VehicleCategoryDto {
    private String category;
    private List<Vehicle> vehicles;
}
