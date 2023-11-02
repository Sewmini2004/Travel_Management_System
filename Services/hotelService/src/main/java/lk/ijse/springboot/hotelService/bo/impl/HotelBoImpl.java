package lk.ijse.springboot.hotelService.bo.impl;


import lk.ijse.springboot.hotelService.bo.HotelBO;
import lk.ijse.springboot.hotelService.bo.exception.AlreadyExistException;
import lk.ijse.springboot.hotelService.bo.exception.NotFoundException;
import lk.ijse.springboot.hotelService.dto.HotelDTO;
import lk.ijse.springboot.hotelService.entity.Hotel;
import lk.ijse.springboot.hotelService.repository.HotelRepo;
import lk.ijse.springboot.hotelService.util.EntityDTOConversion;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Base64;
import java.util.List;

@Service
@Transactional
public class HotelBoImpl implements HotelBO {
    private final HotelRepo hotelRepo;

    private final EntityDTOConversion entityDTOConversion;

    private final ModelMapper modelMapper;

    public HotelBoImpl(HotelRepo hotelRepo, EntityDTOConversion entityDTOConversion, ModelMapper modelMapper) {
        this.hotelRepo = hotelRepo;
        this.entityDTOConversion = entityDTOConversion;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(HotelDTO hotelDTO) {
        if(!hotelRepo.existsById(hotelDTO.getHotelId())){
           hotelRepo.save(entityDTOConversion.getUserEntity(hotelDTO));
        } else {
            throw new AlreadyExistException("Id already exists. Id is " +hotelDTO.getHotelId());

        }
    }

    @Override
    public void delete(String id) {
        if (hotelRepo.existsById(Long.valueOf(id))){
            hotelRepo.deleteById(Long.valueOf(id));
        }
    }

    @Override
    public void update(String id, HotelDTO hotelDTO) {
        if (hotelRepo.existsById(Long.valueOf(id))){
            hotelRepo.save(entityDTOConversion.getUserEntity(hotelDTO));
        }else {
            throw new NotFoundException("Id not found . Id is " +id);

        }
    }

    @Override
    public HotelDTO search(String id) {
       if (hotelRepo.existsById(Long.valueOf(id))){
           Hotel hotel = hotelRepo.findById(Long.valueOf(id)).get();
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
