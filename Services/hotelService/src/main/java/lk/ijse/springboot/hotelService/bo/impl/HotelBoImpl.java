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
        if(hotelRepo.findByHotelEmail(hotelDTO.getHotelEmail())==null){
           hotelRepo.save(entityDTOConversion.getUserEntity(hotelDTO));
        } else {
            throw new AlreadyExistException("Hotel is already exists " +hotelDTO.getHotelEmail());
        }
    }

    @Override
    public void delete(long id) {
        if (hotelRepo.existsById(id)){
            hotelRepo.deleteById(id);
        }else throw new NotFoundException("Hotel not found " +id);
    }

    @Override
    public void update(long id, HotelDTO hotelDTO) {
        if (hotelRepo.existsById(id)){
            hotelRepo.save(entityDTOConversion.getUserEntity(hotelDTO));
        }else {
            throw new NotFoundException("Hotel not found " +id);
        }
    }

    @Override
    public HotelDTO search(long id) {
       if (hotelRepo.existsById(id)){
           Hotel hotel = hotelRepo.findById(id).get();
           return entityDTOConversion.getUserDTO(hotel);
       }else
           throw new NotFoundException("Hotel not found " +id);
    }

    @Override
    public List<HotelDTO> getAll() {
        List<Hotel> all = hotelRepo.findAll();
        return modelMapper.map(all, new TypeToken<List<HotelDTO>>() {
        }.getType());
    }
}
