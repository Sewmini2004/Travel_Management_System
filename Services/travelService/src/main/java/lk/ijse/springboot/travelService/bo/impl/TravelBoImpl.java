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

//        TODO: check vehicle,guide,user,hotel form other services
//         1-> user
//         2-> hotel vehicle
//         3-> guide

        travelDTO.setPackageId(generateNextId());
        Travel travelEntity = travelRepo.save(entityDTOConversion.getTravelEntity(travelDTO));
        String imgBase64 = Base64.getEncoder().encodeToString(travelDTO.getUserNIC_images().getBytes());
        travelEntity.setUserNIC_images(imgBase64);
        travelRepo.save(travelEntity);
    }

    @Override
    public void delete(String id) {
        if (travelRepo.existsById(id)) {
            travelRepo.deleteById(id);
        } else throw new NotFoundException("Package is not found. " + id);
    }

    @Override
    public void update(String id, TravelDTO travelDTO) throws IOException {
        if (travelRepo.existsById(id)) {
            String imgBase64 = Base64.getEncoder().encodeToString(travelDTO.getUserNIC_images().getBytes());
            entityDTOConversion.getTravelEntity(travelDTO).setUserNIC_images(imgBase64);
            travelRepo.save(entityDTOConversion.getTravelEntity(travelDTO));
        } else throw new NotFoundException("Package is not found. " + id);
    }

    @Override
    public TravelDTO search(String id) {
        if (travelRepo.existsById(id)) {
            Travel travel = travelRepo.findById(id).get();
            return entityDTOConversion.getTravelDTO(travel);
        } else throw new NotFoundException("Package is not found. " + id);
    }

    @Override
    public List<TravelDTO> getAll() {
        List<Travel> all = travelRepo.findAll();
        return modelMapper.map(all, new TypeToken<List<TravelDTO>>() {
        }.getType());
    }

    @Override
    public String generateNextId() {
        return String.format("NEXT_%06d", travelRepo.findAll().size()+1);
    }
}
