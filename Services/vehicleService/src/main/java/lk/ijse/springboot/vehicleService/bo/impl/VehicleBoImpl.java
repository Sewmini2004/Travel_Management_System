package lk.ijse.springboot.vehicleService.bo.impl;


import lk.ijse.springboot.vehicleService.bo.VehicleBO;


import lk.ijse.springboot.vehicleService.bo.exception.AlreadyExistException;
import lk.ijse.springboot.vehicleService.bo.exception.NotFoundException;
import lk.ijse.springboot.vehicleService.dto.VehicleDTO;
import lk.ijse.springboot.vehicleService.entity.Vehicle;
import lk.ijse.springboot.vehicleService.repository.VehicleRepo;
import lk.ijse.springboot.vehicleService.util.EntityDTOConversion;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@Transactional
public class VehicleBoImpl implements VehicleBO {
    private final VehicleRepo vehicleRepo;

    private final EntityDTOConversion entityDTOConversion;

    private final ModelMapper modelMapper;

    public VehicleBoImpl(VehicleRepo vehicleRepo, EntityDTOConversion entityDTOConversion, ModelMapper modelMapper) {
        this.vehicleRepo = vehicleRepo;
        this.entityDTOConversion = entityDTOConversion;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(VehicleDTO vehicleDTO) throws IOException {
        if(!vehicleRepo.existsById(vehicleDTO.getVehicleId())){
            Vehicle vehicleEntity = vehicleRepo.save(entityDTOConversion.getVehicleEntity(vehicleDTO));
            String imgBase64 = Base64.getEncoder().encodeToString(vehicleDTO.getDriverLicenseImage().getBytes());
            String imgBase64B = Base64.getEncoder().encodeToString(vehicleDTO.getImagesVehicle().getBytes());
            vehicleEntity.setDriverLicenseImage(imgBase64);
           vehicleEntity.setImagesVehicle(imgBase64B);
            vehicleRepo.save(vehicleEntity);

        }  else {
        throw new AlreadyExistException("VehicleId already exists. VehicleId is " +vehicleDTO.getVehicleId() );

    }
    }

    @Override
    public void delete(String id) {
        if (vehicleRepo.existsById(Long.valueOf(id))){
            vehicleRepo.deleteById(Long.valueOf(id));
        }  else {
            throw new AlreadyExistException("VehicleId already exists. VehicleId is " +id);

        }
    }

    @Override
    public void update(long id, VehicleDTO vehicleDTO) throws IOException {
        if (vehicleRepo.existsById(id)){
            String imgBase64 = Base64.getEncoder().encodeToString(vehicleDTO.getDriverLicenseImage().getBytes());
            entityDTOConversion.getVehicleEntity(vehicleDTO).setDriverLicenseImage(imgBase64);
            String imgBase64B = Base64.getEncoder().encodeToString(vehicleDTO.getImagesVehicle().getBytes());
            entityDTOConversion.getVehicleEntity(vehicleDTO).setImagesVehicle(imgBase64B);
            vehicleRepo.save(entityDTOConversion.getVehicleEntity(vehicleDTO));
        }else {
            throw new NotFoundException("VehicleId not found.VehicleId is " + id);

        }
    }

    @Override
    public VehicleDTO search(String id) {
       if (vehicleRepo.existsById(Long.valueOf(id))){
           Vehicle vehicle = vehicleRepo.findById(Long.valueOf(id)).get();
           VehicleDTO vehicleDTO = entityDTOConversion.getVehicleDTO(vehicle);
           return vehicleDTO;
       }else {
           throw new NotFoundException("VehicleId not found.VehicleId is " + id);

       }


    }

    @Override
    public List<VehicleDTO> getAll() {
        List<Vehicle> all = vehicleRepo.findAll();
        List<VehicleDTO> vehicleDTOList = modelMapper.map(all, new TypeToken<List<VehicleDTO>>() {
        }.getType());
        return vehicleDTOList;
    }
}
