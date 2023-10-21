package lk.ijse.springboot.hotelService.util;

import lk.ijse.springboot.hotelService.dto.RequestDTO;
import lk.ijse.springboot.hotelService.entity.Hotel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConversion {
    private final ModelMapper modelMapper;


    EntityDTOConversion(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Hotel getUserEntity(RequestDTO requestDTO){
        return modelMapper.map(requestDTO, Hotel.class);
    }

    public RequestDTO getUserDTO(Hotel hotel){
        return modelMapper.map(hotel, RequestDTO.class);
    }

}
