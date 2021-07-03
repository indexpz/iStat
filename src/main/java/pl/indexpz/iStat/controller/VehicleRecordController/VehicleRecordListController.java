package pl.indexpz.iStat.controller.VehicleRecordController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.iStat.domain.model.Vehicle;
import pl.indexpz.iStat.domain.model.VehicleRecord;
import pl.indexpz.iStat.domain.repository.UserRepository;
import pl.indexpz.iStat.domain.repository.VehicleRecordRepository;
import pl.indexpz.iStat.domain.repository.VehicleRepository;
import pl.indexpz.iStat.domain.service.UserService;
import pl.indexpz.iStat.domain.service.VehicleRecordService;
import pl.indexpz.iStat.domain.service.VehicleService;

@Controller
@RequestMapping("/vehicle-records/list")
@RequiredArgsConstructor //zamiast konstruktora
@Slf4j
public class VehicleRecordListController {

    private final VehicleRecordService vehicleRecordService;
    private final VehicleService vehicleService;
    private final UserService userService;

@GetMapping
    public String prepareVehicleRecordList(Long id, Model model){
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    model.addAttribute("user",userService.getUserByUserName(username));
    model.addAttribute("vehicle", vehicleService.getVehicleById(id));
    model.addAttribute("vehicleRecords", vehicleRecordService.getVehicleRecordsByVehicleId(id));
    return "/vehicle_records/vehicle-records-list";
}
}
