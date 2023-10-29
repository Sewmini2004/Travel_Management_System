package lk.ijse.springboot.hotelService.bo.impl;


import lk.ijse.springboot.hotelService.bo.HotelBO;
import lk.ijse.springboot.hotelService.dto.HotelDTO;
import lk.ijse.springboot.hotelService.entity.Hotel;
import lk.ijse.springboot.hotelService.repository.HotelRepo;
import lk.ijse.springboot.hotelService.util.EntityDTOConversion;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class HotelBoImpl implements HotelBO {
    @Autowired
    HotelRepo hotelRepo;

    @Autowired
    EntityDTOConversion entityDTOConversion;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void save(HotelDTO hotelDTO) {
        if(!hotelRepo.existsById(hotelDTO.getHotelId())){
            hotelRepo.save(entityDTOConversion.getUserEntity(hotelDTO));
        }
    }

    @Override
    public void delete(String id) {
        if (hotelRepo.existsById(id)){
            hotelRepo.deleteById(id);
        }
    }

    @Override
    public void update(String id, HotelDTO hotelDTO) {
        if (hotelRepo.existsById(id)){
            hotelRepo.save(entityDTOConversion.getUserEntity(hotelDTO));
        }
    }

    @Override
    public HotelDTO search(String id) {
       if (hotelRepo.existsById(id)){
           Hotel hotel = hotelRepo.findById(id).get();
           HotelDTO hotelDTO = entityDTOConversion.getUserDTO(hotel);
           return hotelDTO;
       }
       return null;
    }

    @Override
    public List<HotelDTO> getAll() {
        List<Hotel> all = hotelRepo.findAll();
        List<HotelDTO> requestDTOList = modelMapper.map(all, new TypeToken<List<HotelDTO>>() {
        }.getType());
        return requestDTOList;
    }
}
