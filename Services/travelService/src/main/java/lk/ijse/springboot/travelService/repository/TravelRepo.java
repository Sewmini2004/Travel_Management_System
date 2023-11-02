package lk.ijse.springboot.travelService.repository;

import lk.ijse.springboot.travelService.entity.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRepo extends JpaRepository<Travel,Long> {

}
