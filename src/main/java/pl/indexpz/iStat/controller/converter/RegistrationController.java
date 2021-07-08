package pl.indexpz.iStat.controller.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.iStat.controller.dto.CreateUserForm;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.service.AuthenticationService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
@Slf4j
public class RegistrationController {

    private final AuthenticationService authenticationService;

    public RegistrationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String prepareRegistrationPage(Model model) {
        model.addAttribute("data", new CreateUserForm());
        return "registration/registration";
    }

    @PostMapping
    public String processRegistrationPage(@ModelAttribute("data") @Valid CreateUserForm data, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "registration/registration";
        }
        authenticationService.registerUser(data.toUser());
        return "redirect:/login";
    }
}
