package lk.ijse.springboot.guideService.bo;



import lk.ijse.springboot.guideService.dto.GuideDTO;

import java.io.IOException;
import java.util.List;

public interface GuideBO {
    void save(GuideDTO guideDTO) throws IOException;
    void delete(String id);
    void update(String id, GuideDTO guideDTO) throws IOException;
    GuideDTO search(String id);
    List<GuideDTO> getAll();

}
