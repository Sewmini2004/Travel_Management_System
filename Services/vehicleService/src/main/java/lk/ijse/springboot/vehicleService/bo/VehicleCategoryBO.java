package lk.ijse.springboot.vehicleService.bo;

import lk.ijse.springboot.vehicleService.dto.VehicleCategoryDto;

import java.util.ArrayList;

public interface VehicleCategoryBO {
    public void saveCategories(ArrayList<VehicleCategoryDto> vehicleCategoryDtos);
    public boolean isEmpty();
}
