package lk.ijse.springboot.hotelService.util;

import lk.ijse.springboot.hotelService.dto.HotelDTO;
import lk.ijse.springboot.hotelService.entity.Hotel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConversion {
    private final ModelMapper modelMapper;


    EntityDTOConversion(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Hotel getUserEntity(HotelDTO hotelDTO){
        return modelMapper.map(hotelDTO, Hotel.class);
    }

    public HotelDTO getUserDTO(Hotel hotel){
        return modelMapper.map(hotel, HotelDTO.class);
    }

}
