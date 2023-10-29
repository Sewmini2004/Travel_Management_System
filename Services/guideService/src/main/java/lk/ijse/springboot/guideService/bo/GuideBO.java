package lk.ijse.springboot.guideService.bo;



import lk.ijse.springboot.guideService.dto.GuideDTO;

import java.util.List;

public interface GuideBO {
    void save(GuideDTO guideDTO);
    void delete(String id);
    void update(String id, GuideDTO guideDTO);
    GuideDTO search(String id);
    List<GuideDTO> getAll();

}
