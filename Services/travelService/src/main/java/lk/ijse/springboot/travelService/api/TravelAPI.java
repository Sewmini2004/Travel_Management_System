package lk.ijse.springboot.travelService.api;

import jakarta.validation.Valid;
import lk.ijse.springboot.travelService.bo.TravelBO;
import lk.ijse.springboot.travelService.dto.TravelDTO;
import lk.ijse.springboot.travelService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/travelService")
@CrossOrigin
public class TravelAPI {

    private final TravelBO travelBO;

    @Autowired
    public TravelAPI(TravelBO travelBO) {
        this.travelBO = travelBO;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil save(@ModelAttribute @Valid TravelDTO travelDTO){
        travelBO.save(travelDTO);

        return new ResponseUtil(200,"Saved Success",null);
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil update(String id,@RequestBody  @Valid  TravelDTO travelDTO){
        travelBO.update(id, travelDTO);
        return new  ResponseUtil(200,"OK",null);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil delete(String id){
       travelBO.delete(id);
        return new  ResponseUtil(200,"OK",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil search(@PathVariable String id){
        TravelDTO travelDTO = travelBO.search(id);
        return new  ResponseUtil(200,"OK", travelDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAll(){
        List<TravelDTO> all= travelBO.getAll();
        return new ResponseUtil(200,"OK",all);
    }



}
