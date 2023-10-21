package lk.ijse.springboot.hotelService.bo;


import lk.ijse.springboot.hotelService.dto.RequestDTO;

import java.util.List;

public interface HotelBO {
    void save(RequestDTO requestDTO);
    void delete(String id);
    void update(String id, RequestDTO requestDTO);
    RequestDTO search(String id);
    List<RequestDTO> getAll();

}
