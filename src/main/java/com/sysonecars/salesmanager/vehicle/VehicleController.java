package com.sysonecars.salesmanager.vehicle;

import com.sysonecars.salesmanager.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicle/{id}")
    public ResponseEntity<VehicleDTO> getVehicle(@PathVariable(value = "id") Integer id){
        VehicleDTO response = this.vehicleService.getSale(id);
        if (response.getId() == null ){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping(value = "/vehicle/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<VehicleDTO> saveVehicle (@RequestBody UpdatedVehicleDTO newVehicle){
        VehicleDTO retDTO = this.vehicleService.saveNewVehicle(newVehicle);

        return ResponseEntity.status(HttpStatus.OK).body(retDTO);
    }



}
