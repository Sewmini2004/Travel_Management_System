package lk.ijse.springboot.hotelService.repository;

import lk.ijse.springboot.hotelService.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel,Long> {

}
