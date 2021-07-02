package pl.indexpz.iStat.controller.VehicleController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.iStat.domain.model.Vehicle;
import pl.indexpz.iStat.domain.service.VehicleService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/vehicle/add")
@RequiredArgsConstructor //zamiast konstruktora
@Slf4j
public class VehicleCreateController {

    private final VehicleService vehicleService;

    @ModelAttribute(name = "meterUnit")
    public List<String> meterUnit() {
        return List.of("kilometry", "mile", "godziny");
    }

    @ModelAttribute(name="fuelName")
    public List<String> fuelName() {
        return List.of("benzyna 95", "benzyna 98", "olej napędowy", "energia elektryczna", "LPG");
    }

    @ModelAttribute(name="fuelUnit")
    public List<String> fuelUnit() {
        return List.of("litr", "galon", "KWh", "kilogramy", "");
    }

    @GetMapping
    public String prepareCreate(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "vehicles/vehicle-create";
    }

    @PostMapping
    public String processCreate(@Valid Vehicle vehicle, BindingResult bindings) {
        if (bindings.hasErrors()) {
            return "vehicles/vehicle-create";
        }
        vehicleService.addVehicle(vehicle);
        return "redirect:/user/homepage";
    }
}
