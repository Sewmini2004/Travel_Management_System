package lk.ijse.springboot.vehicleService.bo.impl;


import lk.ijse.springboot.vehicleService.bo.VehicleBO;


import lk.ijse.springboot.vehicleService.dto.VehicleDTO;
import lk.ijse.springboot.vehicleService.entity.Vehicle;
import lk.ijse.springboot.vehicleService.repository.VehicleRepo;
import lk.ijse.springboot.vehicleService.util.EntityDTOConversion;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleBoImpl implements VehicleBO {
    @Autowired
    VehicleRepo vehicleRepo;

    @Autowired
    EntityDTOConversion entityDTOConversion;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void save(VehicleDTO vehicleDTO) {
        if(!vehicleRepo.existsById(vehicleDTO.getVehicleId())){
            vehicleRepo.save(entityDTOConversion.getVehicleEntity(vehicleDTO));
        }
    }

    @Override
    public void delete(String id) {
        if (vehicleRepo.existsById(id)){
            vehicleRepo.deleteById(id);
        }
    }

    @Override
    public void update(String id, VehicleDTO vehicleDTO) {
        if (vehicleRepo.existsById(id)){
            vehicleRepo.save(entityDTOConversion.getVehicleEntity(vehicleDTO));
        }
    }

    @Override
    public VehicleDTO search(String id) {
       if (vehicleRepo.existsById(id)){
           Vehicle vehicle = vehicleRepo.findById(id).get();
           VehicleDTO vehicleDTO = entityDTOConversion.getVehicleDTO(vehicle);
           return vehicleDTO;
       }

       return null;
    }

    @Override
    public List<VehicleDTO> getAll() {
        List<Vehicle> all = vehicleRepo.findAll();
        List<VehicleDTO> vehicleDTOList = modelMapper.map(all, new TypeToken<List<VehicleDTO>>() {
        }.getType());
        return vehicleDTOList;
    }
}
