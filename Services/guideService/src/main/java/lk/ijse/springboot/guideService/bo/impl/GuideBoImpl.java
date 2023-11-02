package lk.ijse.springboot.guideService.bo.impl;

import lk.ijse.springboot.guideService.bo.GuideBO;
import lk.ijse.springboot.guideService.bo.exception.AlreadyExistException;
import lk.ijse.springboot.guideService.bo.exception.NotFoundException;
import lk.ijse.springboot.guideService.dto.GuideDTO;
import lk.ijse.springboot.guideService.entity.Guide;
import lk.ijse.springboot.guideService.repository.GuideRepo;
import lk.ijse.springboot.guideService.util.EntityDTOConversion;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Base64;
import java.util.List;


@Service
@Transactional
public class GuideBoImpl implements GuideBO {
    private final GuideRepo guideRepo;

    private final EntityDTOConversion entityDTOConversion;

    private final ModelMapper modelMapper;

    public GuideBoImpl(GuideRepo guideRepo, EntityDTOConversion entityDTOConversion, ModelMapper modelMapper) {
        this.guideRepo = guideRepo;
        this.entityDTOConversion = entityDTOConversion;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(GuideDTO guideDTO) throws IOException {
        if(!guideRepo.existsById(guideDTO.getGuideId())){
            Guide guideEntity = guideRepo.save(entityDTOConversion.getGuideEntity(guideDTO));
            String imgBase64 = Base64.getEncoder().encodeToString(guideDTO.getGuideIdImage().getBytes());
            guideEntity.setGuideIdImage(imgBase64);

            String imgBase64F = Base64.getEncoder().encodeToString(guideDTO.getNicImageFrontEnd().getBytes());
            guideEntity.setNicImageFrontEnd(imgBase64F);

            String imgBase64B = Base64.getEncoder().encodeToString(guideDTO.getNicImageBackEnd().getBytes());
            guideEntity.setNicImageBackEnd(imgBase64B);

            guideRepo.save(guideEntity);

        }else {
            throw new AlreadyExistException("Id already exists. Id is " +guideDTO.getGuideId());

        }
    }

    @Override
    public void delete(String id) {
        if (guideRepo.existsById(Long.valueOf(id))){
            guideRepo.deleteById(Long.valueOf(id));
        }
    }

    @Override
    public void update(String id, GuideDTO guideDTO) throws IOException {
        if (guideRepo.existsById(Long.valueOf(id))){
            Guide guideEntity = guideRepo.save(entityDTOConversion.getGuideEntity(guideDTO));

            String imgBase64 = Base64.getEncoder().encodeToString(guideDTO.getGuideIdImage().getBytes());
            guideEntity.setGuideIdImage(imgBase64);

            String imgBase64F = Base64.getEncoder().encodeToString(guideDTO.getNicImageFrontEnd().getBytes());
            guideEntity.setNicImageFrontEnd(imgBase64F);

            String imgBase64B = Base64.getEncoder().encodeToString(guideDTO.getNicImageBackEnd().getBytes());
            guideEntity.setNicImageBackEnd(imgBase64B);

            guideRepo.save(guideEntity);
        }else {
            throw new NotFoundException("Id not found . Id is " +id );

        }
    }

    @Override
    public GuideDTO search(String id) {
       if (guideRepo.existsById(Long.valueOf(id))){
           Guide guide = guideRepo.findById(Long.valueOf(id)).get();
           GuideDTO guideDTO = entityDTOConversion.getGuideDTO(guide);
           return guideDTO;
       }
       return null;
    }

    @Override
    public List<GuideDTO> getAll() {
        List<Guide> all = guideRepo.findAll();
        List<GuideDTO> guideDTOList = modelMapper.map(all, new TypeToken<List<GuideDTO>>() {
        }.getType());
        return guideDTOList;
    }
}
