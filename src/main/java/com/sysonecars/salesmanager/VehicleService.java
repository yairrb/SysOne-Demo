package com.sysonecars.salesmanager;

import com.sysonecars.salesmanager.model.CarModel;
import com.sysonecars.salesmanager.model.PlusMiscellaneous;
import com.sysonecars.salesmanager.model.Vehicle;
import com.sysonecars.salesmanager.repository.CarModelRepository;
import com.sysonecars.salesmanager.repository.PlusMiscellaneousRepository;
import com.sysonecars.salesmanager.repository.VehicleRepository;
import com.sysonecars.salesmanager.vehicle.UpdatedVehicleDTO;
import com.sysonecars.salesmanager.vehicle.VehicleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class VehicleService {


    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private PlusMiscellaneousRepository plusMiscellaneousRepository;
    @Autowired
    private CarModelRepository carModelRepository;


    public VehicleDTO saveNewVehicle(UpdatedVehicleDTO inputVehicle) {

        CarModel model = castCarModel(inputVehicle.getModel());
        List<PlusMiscellaneous> miscellaneousList = castToMisscelanneos(inputVehicle.getMiscellaneous());

        Vehicle newVehicle  = Vehicle.builder().id(inputVehicle.getId()).
                model(model)
                .plusMiscellaneous(miscellaneousList)
                .build();

        this.vehicleRepository.save(newVehicle);

        return getSale(newVehicle.getId());
    }

    private CarModel castCarModel(Integer idModel) {
        CarModel ret = null;
        Optional<CarModel> model = this.carModelRepository.findById(idModel);
        ret = model.map(carModel -> {
            return carModel;
        }).orElse( null);
        return ret;
    }


    private List<PlusMiscellaneous> castToMisscelanneos( List<Integer> list){

        List<PlusMiscellaneous> ret  = new ArrayList<>();
        for ( Integer item : list){
            Optional<PlusMiscellaneous> newItem = plusMiscellaneousRepository.findById(item);
            newItem.ifPresent(plusMiscellaneous -> ret.add(plusMiscellaneous));
        }
        //TODO: error Handler

        return ret;
    }



    public VehicleDTO getSale( Integer vehicleId){

        VehicleDTO response = VehicleDTO.builder().build();

        Optional<Vehicle> vehicle = this.vehicleRepository.findById(vehicleId);
        vehicle.ifPresent(vehicle1 ->{
                    response.setId(vehicle1.getId());
                    response.setVehicleModel(vehicle1.getModel().getModelName());
                    response.setPlusOptionals(getMiscellaneousNames(vehicle1));
                    response.setPrice(getValueFromSale(vehicle1));
                }
        );
        return response;
    }

    private List<String> getMiscellaneousNames(Vehicle vehicle){
        List<String> ret = new ArrayList<>();
        for(PlusMiscellaneous m : vehicle.getPlusMiscellaneous()){
            ret.add(m.getName());
        }

        return ret;
    }


    public Double getValueFromSale(Vehicle vehicle){
        Double totalOfSale = 0.0;

        totalOfSale += vehicle.getModel().getPrice();

        for (PlusMiscellaneous plusOptional : vehicle.getPlusMiscellaneous()){

            totalOfSale += plusOptional.getPrice();

        }
        return totalOfSale;
    }


}
