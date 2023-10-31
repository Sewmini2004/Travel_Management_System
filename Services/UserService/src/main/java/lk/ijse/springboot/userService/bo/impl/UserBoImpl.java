package lk.ijse.springboot.userService.bo.impl;

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
            userRepo.save(entityDTOConversion.getUserEntity(userDTO));
        }
    }

    @Override
    public void delete(String id) {
        if (userRepo.existsById(id)){
            userRepo.deleteById(id);
        }
    }

    @Override
    public void update(String id, UserDTO userDTO) {
        if (userRepo.existsById(id)){
            userRepo.save(entityDTOConversion.getUserEntity(userDTO));
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
