package pl.indexpz.iStat.controller.VehicleRecordController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.iStat.domain.model.VehicleRecord;
import pl.indexpz.iStat.domain.service.VehicleRecordService;
import pl.indexpz.iStat.domain.service.VehicleService;

import java.util.Optional;

@Controller
@RequestMapping("/vehicle-records/delete")
@RequiredArgsConstructor //zamiast konstruktora
@Slf4j
public class VehicleRecordDeleteController {

    private final VehicleRecordService vehicleRecordService;
    private final VehicleService vehicleService;

    @GetMapping
    public String prepareDelete(Long vehicleRecordId, Long vehicleId, Model model){
        Optional<VehicleRecord> optionalVehicleRecord = vehicleRecordService.getVehicleRecordById(vehicleRecordId);
        if(optionalVehicleRecord.isPresent()){
            VehicleRecord vehicleRecord = optionalVehicleRecord.get();
            model.addAttribute("vehicleRecord", vehicleRecord);
            model.addAttribute("vehicle", vehicleService.getVehicleById(vehicleId));
        }
        return "vehicle_records/vehicle-records-delete";
    }

    @PostMapping
    public String processDelete(Long vehicleRecordId, Long vehicleId){
        Optional<VehicleRecord> optionalVehicleRecord = vehicleRecordService.getVehicleRecordById((vehicleRecordId));
        if(optionalVehicleRecord.isPresent()){
            VehicleRecord vehicleRecord = optionalVehicleRecord.get();
            vehicleRecordService.removeVehicleRecord(vehicleRecord);
        }
        return "redirect:/vehicle-records/list?id="+vehicleId;
    }
}
