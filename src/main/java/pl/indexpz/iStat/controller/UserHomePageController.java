package pl.indexpz.iStat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.model.Vehicle;
import pl.indexpz.iStat.domain.service.UserService;
import pl.indexpz.iStat.domain.service.VehicleService;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
@RequestMapping("/user/homepage")
@RequiredArgsConstructor //zamiast konstruktora
public class UserHomePageController {

//    User user = SecurityContextHolder.getContext().getAuthentication();

    private final UserService userService;
    private final VehicleService vehicleService;

    @GetMapping
    public String prepareHomePage(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("user", userService.getUserByUserName(username));
        model.addAttribute("vehicles", vehicleService.getVehicles());
        return "/users/user-homepage";
    }

//    @PostMapping
//    public String processHomePage(@Valid Vehicle, BindingResult bindings) {
//        if (bindings.hasErrors()) {
//            return "/users/user-homepage";
//        }
//
//
//    }
}
