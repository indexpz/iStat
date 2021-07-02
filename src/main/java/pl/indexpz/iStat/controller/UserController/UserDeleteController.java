package pl.indexpz.iStat.controller.UserController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.iStat.domain.service.UserService;
import pl.indexpz.iStat.domain.service.VehicleService;

@Controller
@RequestMapping("/user/delete")
@RequiredArgsConstructor //zamiast konstruktora
@Slf4j
public class UserDeleteController {

    private final VehicleService vehicleService;


}
