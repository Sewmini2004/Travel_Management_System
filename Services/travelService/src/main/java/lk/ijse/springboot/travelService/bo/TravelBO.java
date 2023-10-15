package lk.ijse.springboot.travelService.bo;


import lk.ijse.springboot.travelService.dto.TravelDTO;

import java.util.List;

public interface TravelBO {
    void save(TravelDTO travelDTO);
    void delete(String id);
    void update(String id, TravelDTO travelDTO);
    TravelDTO search(String id);
    List<TravelDTO> getAll();

}
