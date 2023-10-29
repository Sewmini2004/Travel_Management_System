package lk.ijse.springboot.hotelService.api;

import lk.ijse.springboot.hotelService.bo.HotelBO;
import lk.ijse.springboot.hotelService.dto.RequestDTO;
import lk.ijse.springboot.hotelService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/hotelService")
@CrossOrigin
public class HotelAPI {
    @Autowired
    HotelBO hotelBO;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil save(RequestDTO requestDTO){
        hotelBO.save(requestDTO);

        return new ResponseUtil(200,"Saved Success",null);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil update(String id,@RequestBody RequestDTO requestDTO){
        hotelBO.update(id, requestDTO);
        return new  ResponseUtil(200,"OK",null);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil delete(String id){
       hotelBO.delete(id);
        return new  ResponseUtil(200,"OK",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil search(@PathVariable String id){
        RequestDTO requestDTO = hotelBO.search(id);
        return new  ResponseUtil(200,"OK", requestDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAll(){
        List<RequestDTO> all= hotelBO.getAll();
        return new ResponseUtil(200,"OK",all);
    }



}
