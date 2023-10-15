package lk.ijse.springboot.hotelService.bo;


import lk.ijse.springboot.hotelService.dto.HotelDTO;

import java.util.List;

public interface HotelBO {
    void save(HotelDTO hotelDTO);
    void delete(String id);
    void update(String id, HotelDTO hotelDTO);
    HotelDTO search(String id);
    List<HotelDTO> getAll();

}
