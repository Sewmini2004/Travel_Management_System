package lk.ijse.springboot.travelService.bo.impl;

import lk.ijse.springboot.travelService.bo.TravelBO;
import lk.ijse.springboot.travelService.bo.exception.AlreadyExistException;
import lk.ijse.springboot.travelService.bo.exception.NotFoundException;
import lk.ijse.springboot.travelService.dto.TravelDTO;
import lk.ijse.springboot.travelService.entity.Travel;
import lk.ijse.springboot.travelService.repository.TravelRepo;
import lk.ijse.springboot.travelService.util.EntityDTOConversion;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@Transactional
public class TravelBoImpl implements TravelBO {
    private final TravelRepo travelRepo;

    private final EntityDTOConversion entityDTOConversion;

    private final ModelMapper modelMapper;

    public TravelBoImpl(TravelRepo travelRepo, EntityDTOConversion entityDTOConversion, ModelMapper modelMapper) {
        this.travelRepo = travelRepo;
        this.entityDTOConversion = entityDTOConversion;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(TravelDTO travelDTO) throws IOException {
        if(!travelRepo.existsById(travelDTO.getPackageId())){
            Travel travelEntity = travelRepo.save(entityDTOConversion.getTravelEntity(travelDTO));
            String imgBase64 = Base64.getEncoder().encodeToString(travelDTO.getUserNIC_images().getBytes());
            travelEntity.setUserNIC_images(imgBase64);
            travelRepo.save(travelEntity);
        } else {
            throw new AlreadyExistException("Id already exists. Id is " +travelDTO.getPackageId() );

        }
    }

    @Override
    public void delete(String id) {
        if (travelRepo.existsById(Long.valueOf(id))){
            travelRepo.deleteById(Long.valueOf(id));
        }
    }

    @Override
    public void update(String id, TravelDTO travelDTO) throws IOException {
        if (travelRepo.existsById(Long.valueOf(id))){
            String imgBase64 = Base64.getEncoder().encodeToString(travelDTO.getUserNIC_images().getBytes());
            entityDTOConversion.getTravelEntity(travelDTO).setUserNIC_images(imgBase64);

            travelRepo.save(entityDTOConversion.getTravelEntity(travelDTO));


        }else {
            throw new NotFoundException("Id not found . Id is " +id);

        }
    }

    @Override
    public TravelDTO search(String id) {
       if (travelRepo.existsById(Long.valueOf(id))){
           Travel travel = travelRepo.findById(Long.valueOf(id)).get();
           TravelDTO travelDTO = entityDTOConversion.getTravelDTO(travel);
           return travelDTO;
       }
       return null;
    }

    @Override
    public List<TravelDTO> getAll() {
        List<Travel> all = travelRepo.findAll();
        List<TravelDTO> travelDTOList = modelMapper.map(all, new TypeToken<List<TravelDTO>>() {
        }.getType());
        return travelDTOList;
    }
}
