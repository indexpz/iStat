package pl.indexpz.iStat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.service.AuthenticationService;
import pl.indexpz.iStat.domain.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/user/editpassword")
@RequiredArgsConstructor //zamiast konstruktora
@Slf4j
public class UserPasswordController {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    @GetMapping
    public String prepareEdit(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("user", userService.getUserByUserName(username));
        log.info("User do edycji "  + userService.getUserByUserName(username).getUsername() + ", " + userService.getUserByUserName(username).getFirstName() + ", " +userService.getUserByUserName(username).getLastName());
        return "users/user-editpasswordform";
    }

    @PostMapping
    public String processEdit(@Valid User user, BindingResult bindings) {
        log.info("User do edycji "  + user.getUsername() + ", " + user.getFirstName() + ", " + user.getLastName());
        if (bindings.hasErrors()) {
            return "users/user-editpasswordform";
        }

        authenticationService.registerUser(user);
        log.info("User po edycji " + user.getUsername() + ", " + user.getFirstName() + ", " + user.getLastName());
        return "redirect:/login";
    }
}
