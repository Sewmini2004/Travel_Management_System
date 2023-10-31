package lk.ijse.springboot.vehicleService.api;

import jakarta.validation.Valid;
import lk.ijse.springboot.vehicleService.bo.VehicleBO;
import lk.ijse.springboot.vehicleService.dto.VehicleDTO;
import lk.ijse.springboot.vehicleService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicleService")
@CrossOrigin
public class VehicleAPI {
    @Autowired
    VehicleBO vehicleBO;

    @PostMapping(produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseUtil save(@Valid VehicleDTO vehicleDTO){
        vehicleBO.save(vehicleDTO);

        return new ResponseUtil(200,"Saved Success",null);
    }

    @PutMapping(produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseUtil update(String id,@RequestBody @Valid VehicleDTO vehicleDTO){
        vehicleBO.update(id, vehicleDTO);
        return new  ResponseUtil(200,"OK",null);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil delete(String id){
       vehicleBO.delete(id);
        return new  ResponseUtil(200,"OK",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil search(@PathVariable String id){
        VehicleDTO vehicleDTO = vehicleBO.search(id);
        return new  ResponseUtil(200,"OK", vehicleDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAll(){
        List<VehicleDTO> all= vehicleBO.getAll();
        return new ResponseUtil(200,"OK",all);
    }



}
