package lk.ijse.springboot.vehicleService.repository;

import lk.ijse.springboot.vehicleService.entity.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehicleCategoryRepo extends JpaRepository<VehicleCategory,Long> {

}
