package lk.ijse.springboot.userService.util;
import lk.ijse.springboot.userService.dto.UserDTO;
import lk.ijse.springboot.userService.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConversion {
    private final ModelMapper modelMapper;


    EntityDTOConversion(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public User getUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }

    public UserDTO  getUserDTO(User user){
        return modelMapper.map(user,UserDTO.class);
    }

}
