package pl.indexpz.iStat.controller.converter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.service.AuthenticationService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final AuthenticationService authenticationService;

    public RegistrationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String prepareRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration/registration";
    }

    @PostMapping
    public String processRegistrationPage(@ModelAttribute("user") @Valid User user, BindingResult bindings){
        if(bindings.hasErrors()){
            return "registration/registration";

        }
        authenticationService.registerUser(user);
        return "redirect:/login";
    }
}
/*    private final AuthenticationService authenticationService;

    public RegistrationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String prepareRegistrationPage(Model model) {
        model.addAttribute("user", new CreateUserForm());
        return "registration/registration";
    }

    @PostMapping
    public String processRegistrationPage(@Valid CreateUserForm data, BindingResult bindings) {
        if (bindings.hasErrors()) {
            return "registration/registration";
        }
        authenticationService.registerUser(data.toUser());
        return "redirect:/login";
    }

 */