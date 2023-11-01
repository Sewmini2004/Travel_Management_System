package lk.ijse.springboot.userService.bo.impl;

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
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.List;
@Service
@Transactional
public class UserBoImpl implements UserBO {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private EntityDTOConversion entityDTOConversion;
    @Autowired
    private ModelMapper modelMapper;



    @Override
    public void save(UserDTO userDTO) {
        if(!userRepo.existsById(String.valueOf(userDTO.getUserId()))){

            String imgBase64 = Base64.getEncoder().encodeToString(userDTO.getUserNICImagesFrontEnd().getBytes());
            entityDTOConversion.getUserEntity(userDTO).setUserNICImagesFrontEnd(imgBase64);

            String imgBase64B = Base64.getEncoder().encodeToString(userDTO.getUserNIC_imagesBackEnd().getBytes());
            entityDTOConversion.getUserEntity(userDTO).setUserNICImagesFrontEnd(imgBase64B);

            userRepo.save(entityDTOConversion.getUserEntity(userDTO));
        }else {
            throw new AlreadyExistException("UserId already exists. UserId is " + userDTO.getUserId());

        }
    }

    @Override
    public void delete(String id) {
        if (userRepo.existsById(id)){
            userRepo.deleteById(id);
        }else {
            throw new NotFoundException("Id not found. Id is " + id);

        }
    }

    @Override
    public void update(String id, UserDTO userDTO) {
        if (userRepo.existsById(id)){

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
       if (userRepo.existsById(id)){
           User user = userRepo.findById(id).get();
           UserDTO userDTO = entityDTOConversion.getUserDTO(user);
           return userDTO;
       }
       return null;
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> all = userRepo.findAll();
        List<UserDTO> userDTOList = modelMapper.map(all, new TypeToken<List<UserDTO>>() {
        }.getType());
        return userDTOList;
    }
}
