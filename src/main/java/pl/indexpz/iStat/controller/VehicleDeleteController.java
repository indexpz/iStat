package pl.indexpz.iStat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.iStat.domain.model.Vehicle;
import pl.indexpz.iStat.domain.service.VehicleService;

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
        Vehicle vehicle = vehicleService.getVehicleById(id);
        log.info(vehicle.toString());
        model.addAttribute("vehicle", vehicle);
        return "/vehicles/vehicle-delete";
    }

    @PostMapping
    public String processDelete(Long id){
        Vehicle vehicle = vehicleService.getVehicleById(id);
        vehicleService.removeVehicle(vehicle);
        return "redirect:/user/homepage";
    }
}
