package lk.ijse.springboot.travelService.bo.impl;

import lk.ijse.springboot.travelService.bo.TravelBO;
import lk.ijse.springboot.travelService.dto.TravelDTO;
import lk.ijse.springboot.travelService.entity.Travel;
import lk.ijse.springboot.travelService.repository.TravelRepo;
import lk.ijse.springboot.travelService.util.EntityDTOConversion;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TravelBoImpl implements TravelBO {
    @Autowired
    TravelRepo travelRepo;

    @Autowired
    EntityDTOConversion entityDTOConversion;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void save(TravelDTO travelDTO) {
        if(!travelRepo.existsById(travelDTO.getPackageId())){
            travelRepo.save(entityDTOConversion.getTravelEntity(travelDTO));
        }
    }

    @Override
    public void delete(String id) {
        if (travelRepo.existsById(id)){
            travelRepo.deleteById(id);
        }
    }

    @Override
    public void update(String id, TravelDTO travelDTO) {
        if (travelRepo.existsById(id)){
            travelRepo.save(entityDTOConversion.getTravelEntity(travelDTO));
        }
    }

    @Override
    public TravelDTO search(String id) {
       if (travelRepo.existsById(id)){
           Travel travel = travelRepo.findById(id).get();
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
