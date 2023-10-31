package lk.ijse.springboot.userService.bo;
import lk.ijse.springboot.userService.dto.UserDTO;

import java.util.List;

public interface UserBO {
    void save(UserDTO userDTO);
    void delete(String id);
    void update(String id, UserDTO userDTO);
    UserDTO search(String id);
    List<UserDTO> getAll();

}
