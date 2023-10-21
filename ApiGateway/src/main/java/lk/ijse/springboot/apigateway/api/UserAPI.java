package lk.ijse.springboot.apigateway.api;

import lk.ijse.springboot.apigateway.dto.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/api/consume4")
@CrossOrigin
public class UserAPI {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity save(UserDTO userDTO){
        ResponseEntity<UserDTO> userDTOResponseEntity = restTemplate.postForEntity("http://user-service/api/userService",userDTO,UserDTO.class);
        return new ResponseEntity(userDTOResponseEntity.getBody(),HttpStatus.OK);

    }

    @PutMapping()
    public ResponseEntity update(String id){
        UserDTO userDTO = restTemplate.patchForObject("http://user-service/api/userService", id, UserDTO.class);
        return new ResponseEntity(userDTO, HttpStatus.OK);

    }


    @DeleteMapping()
    public ResponseEntity  delete(String id){
        restTemplate.delete("http://user-service/api/userService",id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity getAll(){
        UserDTO[] forObject = restTemplate.getForObject("http://user-service/api/userService", UserDTO[].class);
        return new ResponseEntity(Arrays.asList(forObject), HttpStatus.OK);

    }




}
