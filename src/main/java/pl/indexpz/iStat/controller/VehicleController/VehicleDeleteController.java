package pl.indexpz.iStat.controller.VehicleController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.iStat.domain.model.Vehicle;
import pl.indexpz.iStat.domain.service.VehicleService;

import java.awt.desktop.OpenFilesEvent;
import java.util.Optional;

@Controller
@RequestMapping("/vehicle/delete")
//@RequiredArgsConstructor //zamiast konstruktora
@Slf4j
public class VehicleDeleteController {

    private final VehicleService vehicleService;

    public VehicleDeleteController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public String prepareDelete(Long id, Model model){
        Optional<Vehicle> optionalVehicle = vehicleService.getVehicleById(id);
        if(optionalVehicle.isPresent()){
            Vehicle vehicle = optionalVehicle.get();
            log.info(vehicle.toString());
            model.addAttribute("vehicle", vehicle);
        }
        return "/vehicles/vehicle-delete";
    }

    @PostMapping
    public String processDelete(Long id){
        Optional<Vehicle> optionalVehicle = vehicleService.getVehicleById(id);
        if(optionalVehicle.isPresent()){
            Vehicle vehicle = optionalVehicle.get();
            vehicleService.removeVehicle(vehicle);
        }
        return "redirect:/user/homepage";
    }
}
