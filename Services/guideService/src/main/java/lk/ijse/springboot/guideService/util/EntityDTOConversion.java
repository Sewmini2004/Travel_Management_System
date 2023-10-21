package lk.ijse.springboot.guideService.util;

import lk.ijse.springboot.guideService.dto.ResponseDTO;
import lk.ijse.springboot.guideService.entity.Guide;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConversion {
    private final ModelMapper modelMapper;


    EntityDTOConversion(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Guide getGuideEntity(ResponseDTO responseDTO){
        return modelMapper.map(responseDTO, Guide.class);
    }

    public ResponseDTO getGuideDTO(Guide guide){
        return modelMapper.map(guide, ResponseDTO.class);
    }

}
