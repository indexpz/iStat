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

@Controller
@RequestMapping("/vehicle-records/add")
@RequiredArgsConstructor //zamiast konstruktora
@Slf4j
public class VehicleRecordCreateController {

    private final VehicleRecordService vehicleRecordService;
    private final VehicleService vehicleService;


    @GetMapping
    public String prepareCreate(Long id, Model model) {
        model.addAttribute("vehicleRecord", new VehicleRecord());
        model.addAttribute("vehicle", vehicleService.getVehicleById(id));
        log.info(vehicleService.getVehicleById(id).getVehicleName() +" $$$$$$$$$$$$$$$$$$$$$$$$$ "+ id);
        return "vehicle_records/vehicle-records-add";
    }


    @PostMapping
    public String processCreate(@Valid VehicleRecord vehicleRecord, Long id, BindingResult bindings) {
        log.info(vehicleRecord.getId() +" ############################################ "+ id);
        if (bindings.hasErrors()) {
            return "/vehicle_records/vehicle-records-add";
        }

//        Vehicle vehicle = vehicleService.getVehicleById(id);
//        vehicleRecord.setVehicle(vehicle);
//        vehicleRecordService.addVehicleRecord(vehicleRecord, id);



        Vehicle vehicle = vehicleService.getVehicleById(id);
        vehicleRecordService.addVehicleRecord(vehicleRecord, vehicle);
        return "redirect:/vehicle-records/list?id="+id;
    }
}
