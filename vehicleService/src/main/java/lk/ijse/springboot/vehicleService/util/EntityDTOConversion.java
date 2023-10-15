package lk.ijse.springboot.vehicleService.util;

import lk.ijse.springboot.vehicleService.dto.VehicleDTO;
import lk.ijse.springboot.vehicleService.entity.Vehicle;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConversion {
    private final ModelMapper modelMapper;


    EntityDTOConversion(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Vehicle getVehicleEntity(VehicleDTO vehicleDTO){
        return modelMapper.map(vehicleDTO, Vehicle.class);
    }

    public VehicleDTO getVehicleDTO(Vehicle vehicle){
        return modelMapper.map(vehicle, VehicleDTO.class);
    }

}
