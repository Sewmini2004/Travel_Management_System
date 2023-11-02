package lk.ijse.springboot.vehicleService.bo.impl;

import lk.ijse.springboot.vehicleService.bo.VehicleCategoryBO;
import lk.ijse.springboot.vehicleService.dto.VehicleCategoryDto;
import lk.ijse.springboot.vehicleService.entity.VehicleCategory;
import lk.ijse.springboot.vehicleService.repository.VehicleCategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VehicleCategoryBoImple implements VehicleCategoryBO {
    private VehicleCategoryRepo repo;
    private ModelMapper mapper;

    @Autowired
    public VehicleCategoryBoImple(VehicleCategoryRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public void saveCategories(ArrayList<VehicleCategoryDto> vehicleCategoryDtos) {
        vehicleCategoryDtos.forEach(
                vehicleCategoryDto -> repo.save(mapper.map(vehicleCategoryDto, VehicleCategory.class))
        );
    }

    @Override
    public boolean isEmpty() {
        return repo.findAll().size() == 0;
    }
}
