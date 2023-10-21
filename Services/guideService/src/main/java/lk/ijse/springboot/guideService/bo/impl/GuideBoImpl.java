package lk.ijse.springboot.guideService.bo.impl;

import lk.ijse.springboot.guideService.bo.GuideBO;
import lk.ijse.springboot.guideService.dto.ResponseDTO;
import lk.ijse.springboot.guideService.entity.Guide;
import lk.ijse.springboot.guideService.repository.GuideRepo;
import lk.ijse.springboot.guideService.util.EntityDTOConversion;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class GuideBoImpl implements GuideBO {
    @Autowired
    GuideRepo guideRepo;

    @Autowired
    EntityDTOConversion entityDTOConversion;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void save(ResponseDTO responseDTO) {
        if(!guideRepo.existsById(responseDTO.getGuideId())){
            guideRepo.save(entityDTOConversion.getGuideEntity(responseDTO));
        }
    }

    @Override
    public void delete(String id) {
        if (guideRepo.existsById(id)){
            guideRepo.deleteById(id);
        }
    }

    @Override
    public void update(String id, ResponseDTO responseDTO) {
        if (guideRepo.existsById(id)){
            guideRepo.save(entityDTOConversion.getGuideEntity(responseDTO));
        }
    }

    @Override
    public ResponseDTO search(String id) {
       if (guideRepo.existsById(id)){
           Guide guide = guideRepo.findById(id).get();
           ResponseDTO responseDTO = entityDTOConversion.getGuideDTO(guide);
           return responseDTO;
       }
       return null;
    }

    @Override
    public List<ResponseDTO> getAll() {
        List<Guide> all = guideRepo.findAll();
        List<ResponseDTO> responseDTOList = modelMapper.map(all, new TypeToken<List<ResponseDTO>>() {
        }.getType());
        return responseDTOList;
    }
}
