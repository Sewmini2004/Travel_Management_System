package lk.ijse.springboot.userService.bo;
import lk.ijse.springboot.userService.dto.UserDTO;

import java.io.IOException;
import java.util.List;

public interface UserBO {
    void save(UserDTO userDTO) throws IOException;
    void delete(String id);
    void update(String id, UserDTO userDTO) throws IOException;
    UserDTO search(String id);
    List<UserDTO> getAll();

}
