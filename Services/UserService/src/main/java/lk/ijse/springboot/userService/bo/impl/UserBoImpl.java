package lk.ijse.springboot.userService.bo.impl;

import jakarta.transaction.Transactional;
import lk.ijse.springboot.userService.bo.exception.AlreadyExistException;
import lk.ijse.springboot.userService.bo.exception.NotFoundException;
import lk.ijse.springboot.userService.dto.UserDTO;
import lk.ijse.springboot.userService.bo.UserBO;

import lk.ijse.springboot.userService.entity.User;
import lk.ijse.springboot.userService.repository.UserRepo;
import lk.ijse.springboot.userService.util.EntityDTOConversion;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@Transactional
public class UserBoImpl implements UserBO {


    private UserRepo userRepo;
    private EntityDTOConversion entityDTOConversion;
    private ModelMapper modelMapper;

    @Autowired
    public UserBoImpl(UserRepo userRepo, EntityDTOConversion entityDTOConversion, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.entityDTOConversion = entityDTOConversion;
        this.modelMapper = modelMapper;
    }


    @Override
    public void save(UserDTO userDTO) throws IOException {
        if(!userRepo.existsById(userDTO.getUserId())){
            User userEntity = entityDTOConversion.getUserEntity(userDTO);
            String imgBase64 = Base64.getEncoder().encodeToString(userDTO.getUserNICImagesFrontEnd().getBytes());
            String imgBase64B = Base64.getEncoder().encodeToString(userDTO.getUserNIC_imagesBackEnd().getBytes());
            userEntity.setUserNICImagesFrontEnd(imgBase64);
            userEntity.setUserNIC_imagesBackEnd(imgBase64B);
            userRepo.save(userEntity);
        }else {
            throw new AlreadyExistException("UserId already exists. UserId is " + userDTO.getUserId());

        }
    }

    @Override
    public void delete(String id) {

        if (userRepo.existsById(Long.valueOf(id))){
            userRepo.deleteById(Long.valueOf(id));
        }else {
            throw new NotFoundException("Id not found. Id is " + id);

        }
    }

    @Override
    public void update(String id, UserDTO userDTO) throws IOException {
        if (userRepo.existsById(Long.valueOf(id))){

            String imgBase64 = Base64.getEncoder().encodeToString(userDTO.getUserNICImagesFrontEnd().getBytes());
            entityDTOConversion.getUserEntity(userDTO).setUserNICImagesFrontEnd(imgBase64);

            String imgBase64B = Base64.getEncoder().encodeToString(userDTO.getUserNIC_imagesBackEnd().getBytes());
            entityDTOConversion.getUserEntity(userDTO).setUserNICImagesFrontEnd(imgBase64B);

            userRepo.save(entityDTOConversion.getUserEntity(userDTO));
        }else {
            throw new NotFoundException("UserId already exists. UserId is " + userDTO.getUserId());

        }
    }

    @Override
    public UserDTO search(String id) {
       if (userRepo.existsById(Long.valueOf(id))){
           User user = userRepo.findById(Long.valueOf(id)).get();
           UserDTO userDTO = entityDTOConversion.getUserDTO(user);
           return userDTO;
       }else {
           throw new NotFoundException("UserId already exists. UserId is " +id);

       }
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> all = userRepo.findAll();
        List<UserDTO> userDTOList = modelMapper.map(all, new TypeToken<List<UserDTO>>() {
        }.getType());
        return userDTOList;
    }
}
