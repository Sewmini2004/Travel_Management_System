package lk.ijse.springboot.guideService.bo;



import lk.ijse.springboot.guideService.dto.ResponseDTO;

import java.util.List;

public interface GuideBO {
    void save(ResponseDTO responseDTO);
    void delete(String id);
    void update(String id, ResponseDTO responseDTO);
    ResponseDTO search(String id);
    List<ResponseDTO> getAll();

}
