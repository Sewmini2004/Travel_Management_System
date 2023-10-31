package lk.ijse.springboot.userService.repository;
import lk.ijse.springboot.userService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {

}
