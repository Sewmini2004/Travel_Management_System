package lk.ijse.springboot.vehicleService.repository;


import lk.ijse.springboot.vehicleService.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle,String> {

}
