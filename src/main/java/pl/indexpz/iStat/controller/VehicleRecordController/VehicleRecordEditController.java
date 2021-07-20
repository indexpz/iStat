package pl.indexpz.iStat.controller.VehicleRecordController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.iStat.domain.model.Vehicle;
import pl.indexpz.iStat.domain.model.VehicleRecord;
import pl.indexpz.iStat.domain.service.VehicleRecordService;
import pl.indexpz.iStat.domain.service.VehicleService;

import javax.validation.Valid;

@Controller
@RequestMapping("/vehicle-records/edit")
@RequiredArgsConstructor //zamiast konstruktora
@Slf4j
public class VehicleRecordEditController {

    private final VehicleRecordService vehicleRecordService;
    private final VehicleService vehicleService;


    @GetMapping
    public String prepareEdit(Long id, Long vehicleId, Model model) {
        model.addAttribute("vehicleRecord", vehicleRecordService.getVehicleRecordById(id));
        model.addAttribute("vehicle", vehicleService.getVehicleById(vehicleId));
        return "vehicle_records/vehicle-records-edit";
    }


    @PostMapping
    public String processEdit(@Valid VehicleRecord vehicleRecord, Long vehicleId, BindingResult bindings) {
        //TODO Zamiast takich zapisów "na zauważenie", to można po prostu logi potem filtrować/wyszukiwać ;)
        log.info(vehicleRecord.getId() + " ############################################ ");
        if (bindings.hasErrors()) {
            return "/vehicle_records/vehicle-records-add";
        }

        vehicleRecord.setVehicle(vehicleService.getVehicleById(vehicleId));
        vehicleRecordService.updateVehicleRecord(vehicleRecord);
        log.info(vehicleRecord.getId() + "XXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        return "redirect:/vehicle-records/list?id=" + vehicleId;
    }


}
