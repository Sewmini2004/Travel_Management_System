package lk.ijse.springboot.hotelService.bo.impl;


import lk.ijse.springboot.hotelService.bo.HotelBO;
import lk.ijse.springboot.hotelService.dto.RequestDTO;
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
    public void save(RequestDTO requestDTO) {
        if(!hotelRepo.existsById(requestDTO.getHotelId())){
            hotelRepo.save(entityDTOConversion.getUserEntity(requestDTO));
        }
    }

    @Override
    public void delete(String id) {
        if (hotelRepo.existsById(id)){
            hotelRepo.deleteById(id);
        }
    }

    @Override
    public void update(String id, RequestDTO requestDTO) {
        if (hotelRepo.existsById(id)){
            hotelRepo.save(entityDTOConversion.getUserEntity(requestDTO));
        }
    }

    @Override
    public RequestDTO search(String id) {
       if (hotelRepo.existsById(id)){
           Hotel hotel = hotelRepo.findById(id).get();
           RequestDTO requestDTO = entityDTOConversion.getUserDTO(hotel);
           return requestDTO;
       }
       return null;
    }

    @Override
    public List<RequestDTO> getAll() {
        List<Hotel> all = hotelRepo.findAll();
        List<RequestDTO> requestDTOList = modelMapper.map(all, new TypeToken<List<RequestDTO>>() {
        }.getType());
        return requestDTOList;
    }
}
