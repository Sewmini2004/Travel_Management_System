package lk.ijse.springboot.apigateway.api;

import lk.ijse.springboot.apigateway.dto.VehicleDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/consume5")
@CrossOrigin
public class VehicleAPI {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public VehicleDTO save(VehicleDTO vehicleDTO){
        ResponseEntity<VehicleDTO> vehicleDTOResponseEntity = restTemplate.postForEntity("http://vehicle-service/api/vehicleService",vehicleDTO,VehicleDTO.class);
        return vehicleDTOResponseEntity.getBody();

    }

    @PutMapping()
    public VehicleDTO  update(String id,@RequestBody VehicleDTO vehicleDTO){
     return  restTemplate.patchForObject("http://vehicle-service/api/vehicleService", id, VehicleDTO.class);

    }


    @DeleteMapping()
    public void  delete(String id){
    restTemplate.delete("http://vehicle-service/api/vehicleService",id);

    }


    @GetMapping()
    public List<VehicleDTO> getAll(){
        VehicleDTO[] forObject = restTemplate.getForObject("http://vehicle-service/api/vehicleService", VehicleDTO[].class);
        return Arrays.asList(forObject);

    }



}
