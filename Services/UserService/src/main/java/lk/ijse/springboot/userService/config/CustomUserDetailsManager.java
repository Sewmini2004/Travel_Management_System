package lk.ijse.springboot.userService.config;

import lk.ijse.springboot.userService.dto.UserDTO;
import lk.ijse.springboot.userService.entity.User;
import lk.ijse.springboot.userService.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsManager implements UserDetailsService {
    private UserRepo userRepo;

    @Autowired
    public CustomUserDetailsManager(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUsername = userRepo.findByUsername(username);
        if (byUsername == null) throw new UsernameNotFoundException(username + " is not found");
        else return byUsername;
    }
}
