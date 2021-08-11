package pl.indexpz.iStat.controller.VehicleRecordController;

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
import pl.indexpz.iStat.domain.model.VehicleRecord;
import pl.indexpz.iStat.domain.service.VehicleRecordService;
import pl.indexpz.iStat.domain.service.VehicleService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/vehicle-records/add")
@RequiredArgsConstructor //zamiast konstruktora
@Slf4j
public class VehicleRecordCreateController {

    private final VehicleRecordService vehicleRecordService;
    private final VehicleService vehicleService;


    @GetMapping
    public String prepareCreate( Model model) {
        model.addAttribute("vehicleRecord", new VehicleRecord());

        return "vehicle_records/vehicle-records-add";
    }




    @PostMapping
    public String processCreate(@Valid VehicleRecord vehicleRecord, Long vehicleId, BindingResult bindings) {
        if (bindings.hasErrors()) {
            return "/vehicle_records/vehicle-records-add";
        }
        log.info("vehicleRecord id "+vehicleRecord.getId());
        Optional<Vehicle> optionalVehicle = vehicleService.getVehicleById(vehicleId);
        if(optionalVehicle.isPresent()){
            Vehicle vehicle = optionalVehicle.get();
            log.info("zapis do bazy vehicleName " + vehicle.getVehicleName() +" vehicleId "+ vehicle.getId());
            vehicleRecord.setId(vehicleRecord.getId());
            log.info("zapis do bazy vehicleNameRecord id " + vehicleRecord.getId());
            vehicleRecordService.addVehicleRecord(vehicleRecord, vehicle);
        }
        return "redirect:/vehicle-records/list?id="+vehicleId;
    }
}
