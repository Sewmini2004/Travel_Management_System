package lk.ijse.springboot.hotelService.bo;


import lk.ijse.springboot.hotelService.dto.HotelDTO;



import java.util.List;

public interface HotelBO {
    void save(HotelDTO hotelDTO);
    void delete(long id);
    void update(long id, HotelDTO hotelDTO);
    HotelDTO search(long id);
    List<HotelDTO> getAll();

}
