package lk.ijse.springboot.guideService.util;

import lk.ijse.springboot.guideService.dto.GuideDTO;
import lk.ijse.springboot.guideService.entity.Guide;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConversion {
    private final ModelMapper modelMapper;


    EntityDTOConversion(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Guide getGuideEntity(GuideDTO guideDTO){
        return modelMapper.map(guideDTO, Guide.class);
    }

    public GuideDTO getGuideDTO(Guide guide){
        return modelMapper.map(guide, GuideDTO.class);
    }

}
