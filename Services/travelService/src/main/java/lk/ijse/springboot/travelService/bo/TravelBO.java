package lk.ijse.springboot.travelService.bo;


import lk.ijse.springboot.travelService.dto.TravelDTO;

import java.io.IOException;
import java.util.List;

public interface TravelBO {
    void save(TravelDTO travelDTO) throws IOException;
    void delete(String id);
    void update(String id, TravelDTO travelDTO) throws IOException;
    TravelDTO search(String id);
    List<TravelDTO> getAll();
    String generateNextId();

}
