package lk.ijse.springboot.apigateway.api;


import lk.ijse.springboot.apigateway.dto.HotelDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@RestController
@RequestMapping("/api/consume")
@CrossOrigin
public class HotelAPI {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity save(HotelDTO hotelDTO){
        ResponseEntity<HotelDTO> hotelDTOResponseEntity = restTemplate.postForEntity("http://hotel-service/api/hotelService",hotelDTO,HotelDTO.class);
        return new ResponseEntity(hotelDTOResponseEntity.getBody(), HttpStatus.OK);

    }

    @PutMapping()
    public ResponseEntity update(String id){
        HotelDTO hotelDTO = restTemplate.patchForObject("http://hotel-service/api/hotelService", id, HotelDTO.class);
        return new ResponseEntity(hotelDTO,HttpStatus.OK);


    }


    @DeleteMapping()
    public ResponseEntity  delete(String id){
        restTemplate.delete("http://hotel-service/api/hotelService",id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity getAll(){
        HotelDTO[] forObject = restTemplate.getForObject("http://hotel-service/api/hotelService",HotelDTO[].class);
        return new ResponseEntity(Arrays.asList(forObject), HttpStatus.OK);

    }


}
