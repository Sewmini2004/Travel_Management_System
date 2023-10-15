package lk.ijse.springboot.travelService.util;


import lk.ijse.springboot.travelService.dto.TravelDTO;
import lk.ijse.springboot.travelService.entity.Travel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConversion {
    private final ModelMapper modelMapper;


    EntityDTOConversion(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Travel getTravelEntity(TravelDTO travelDTO){
        return modelMapper.map(travelDTO, Travel.class);
    }

    public TravelDTO getTravelDTO(Travel travel){
        return modelMapper.map(travel, TravelDTO.class);
    }

}
