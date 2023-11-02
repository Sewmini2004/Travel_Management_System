package lk.ijse.springboot.vehicleService.bo;



import lk.ijse.springboot.vehicleService.dto.VehicleDTO;

import java.io.IOException;
import java.util.List;

public interface VehicleBO {
    void save(VehicleDTO vehicleDTO) throws IOException;
    void delete(String id);
    void update(long id, VehicleDTO vehicleDTO) throws IOException;
    VehicleDTO search(String id);
    List<VehicleDTO> getAll();

}
