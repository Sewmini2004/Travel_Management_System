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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@Transactional
public class UserBoImpl implements UserBO {

    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final EntityDTOConversion entityDTOConversion;
    private final ModelMapper modelMapper;

    @Autowired
    public UserBoImpl(PasswordEncoder passwordEncoder, UserRepo userRepo, EntityDTOConversion entityDTOConversion, ModelMapper modelMapper) {
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
        this.entityDTOConversion = entityDTOConversion;
        this.modelMapper = modelMapper;
    }


    @Override
    public void save(UserDTO userDTO) throws IOException {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        if (userRepo.findByUsername(userDTO.getUsername()) == null) {
            User userEntity = entityDTOConversion.getUserEntity(userDTO);
            String imgBase64 = Base64.getEncoder().encodeToString(userDTO.getUserNICImagesFrontEnd().getBytes());
            String imgBase64B = Base64.getEncoder().encodeToString(userDTO.getUserNIC_imagesBackEnd().getBytes());
            userEntity.setUserNICImagesFrontEnd(imgBase64);
            userEntity.setUserNIC_imagesBackEnd(imgBase64B);
            userDTO.setRole("ROLE_" + userDTO.getRole().toUpperCase().trim());
            userRepo.save(userEntity);
        } else {
            throw new AlreadyExistException("Username already exists. Username is " + userDTO.getUsername());

        }
    }

    @Override
    public void delete(long id) {

        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        } else {
            throw new NotFoundException("Id not found. Id is " + id);

        }
    }

    @Override
    public void update(String id, UserDTO userDTO) throws IOException {
        if (userRepo.existsById(Long.valueOf(id))) {

            String imgBase64 = Base64.getEncoder().encodeToString(userDTO.getUserNICImagesFrontEnd().getBytes());
            entityDTOConversion.getUserEntity(userDTO).setUserNICImagesFrontEnd(imgBase64);

            String imgBase64B = Base64.getEncoder().encodeToString(userDTO.getUserNIC_imagesBackEnd().getBytes());
            entityDTOConversion.getUserEntity(userDTO).setUserNICImagesFrontEnd(imgBase64B);

            userRepo.save(entityDTOConversion.getUserEntity(userDTO));
        } else {
            throw new NotFoundException("User not found " + userDTO.getUsername());

        }
    }

    @Override
    public UserDTO search(String id) {
        if (userRepo.existsById(Long.valueOf(id))) {
            User user = userRepo.findById(Long.valueOf(id)).get();
            UserDTO userDTO = entityDTOConversion.getUserDTO(user);
            return userDTO;
        } else {
            throw new NotFoundException("UserId not found. UserId is " + id);

        }
    }

    @Override
    public UserDTO findByUsername(String username) {
        User byUsername = userRepo.findByUsername(username);
        if (byUsername == null)throw new NotFoundException("User not found : " + username);
        else return modelMapper.map(byUsername, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> all = userRepo.findAll();
        List<UserDTO> userDTOList = modelMapper.map(all, new TypeToken<List<UserDTO>>() {
        }.getType());
        return userDTOList;
    }
}
