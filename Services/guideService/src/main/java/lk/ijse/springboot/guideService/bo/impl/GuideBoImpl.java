package lk.ijse.springboot.guideService.bo.impl;

import lk.ijse.springboot.guideService.bo.GuideBO;
import lk.ijse.springboot.guideService.dto.GuideDTO;
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
    public void save(GuideDTO guideDTO) {
        if(!guideRepo.existsById(guideDTO.getGuideId())){
            guideRepo.save(entityDTOConversion.getGuideEntity(guideDTO));
        }
    }

    @Override
    public void delete(String id) {
        if (guideRepo.existsById(id)){
            guideRepo.deleteById(id);
        }
    }

    @Override
    public void update(String id, GuideDTO guideDTO) {
        if (guideRepo.existsById(id)){
            guideRepo.save(entityDTOConversion.getGuideEntity(guideDTO));
        }
    }

    @Override
    public GuideDTO search(String id) {
       if (guideRepo.existsById(id)){
           Guide guide = guideRepo.findById(id).get();
           GuideDTO guideDTO = entityDTOConversion.getGuideDTO(guide);
           return guideDTO;
       }
       return null;
    }

    @Override
    public List<GuideDTO> getAll() {
        List<Guide> all = guideRepo.findAll();
        List<GuideDTO> guideDTOList = modelMapper.map(all, new TypeToken<List<GuideDTO>>() {
        }.getType());
        return guideDTOList;
    }
}
