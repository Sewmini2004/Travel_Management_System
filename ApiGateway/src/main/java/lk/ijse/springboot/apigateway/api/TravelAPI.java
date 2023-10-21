package lk.ijse.springboot.apigateway.api;

import lk.ijse.springboot.apigateway.dto.TravelDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@RestController
@RequestMapping("/api/consume3")
@CrossOrigin
public class TravelAPI {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity save(TravelDTO travelDTO){
        ResponseEntity<TravelDTO> travelDTOResponseEntity = restTemplate.postForEntity("http://travel-service/api/travelService",travelDTO,TravelDTO.class);
        return new ResponseEntity(travelDTOResponseEntity.getBody(),HttpStatus.OK);

    }

    @PutMapping()
    public ResponseEntity update(String id){
        TravelDTO travelDTO = restTemplate.patchForObject("http://travel-service/api/travelService", id, TravelDTO.class);
        return new ResponseEntity(travelDTO, HttpStatus.OK);

    }


    @DeleteMapping()
    public ResponseEntity  delete(String id){
        restTemplate.delete("http://travel-service/api/travelService",id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity getAll(){
        TravelDTO[] forObject = restTemplate.getForObject("http://travel-service/api/travelService", TravelDTO[].class);
        return new ResponseEntity(Arrays.asList(forObject), HttpStatus.OK);

    }



}
