package lk.ijse.springboot.apigateway.api;

import lk.ijse.springboot.apigateway.dto.GuideDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@RestController
@RequestMapping("/api/consume")
@CrossOrigin
public class GuideAPI {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity save(GuideDTO guideDTO){
        ResponseEntity<GuideDTO> guideDTOResponseEntity = restTemplate.postForEntity("http://guide-service/api/guideService",guideDTO,GuideDTO.class);
        return new ResponseEntity(guideDTOResponseEntity.getBody(),HttpStatus.OK);

    }

    @PutMapping()
    public ResponseEntity update(String id, @RequestBody GuideDTO guideDTO){
        GuideDTO guideDTO1 = restTemplate.patchForObject("http://guide-service/api/guideService", id, GuideDTO.class);
        return new ResponseEntity(guideDTO1,HttpStatus.OK);

    }


    @DeleteMapping()
    public ResponseEntity  delete(String id){
        restTemplate.delete("http://guide-service/api/guideService",id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity getAll(){
        GuideDTO[] forObject = restTemplate.getForObject("http://guide-service/api/guideService", GuideDTO[].class);
        return new ResponseEntity(Arrays.asList(forObject), HttpStatus.OK);

    }



}
