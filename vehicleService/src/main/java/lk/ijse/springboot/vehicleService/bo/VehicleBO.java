package lk.ijse.springboot.vehicleService.bo;



import lk.ijse.springboot.vehicleService.dto.VehicleDTO;

import java.util.List;

public interface VehicleBO {
    void save(VehicleDTO vehicleDTO);
    void delete(String id);
    void update(String id, VehicleDTO vehicleDTO);
    VehicleDTO search(String id);
    List<VehicleDTO> getAll();

}
