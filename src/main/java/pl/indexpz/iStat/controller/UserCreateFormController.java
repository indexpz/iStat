package pl.indexpz.iStat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.iStat.controller.dto.UserRequest;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.repository.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/forms/user")
@Slf4j
public class UserCreateFormController {

    private final UserRepository userRepository;

    public UserCreateFormController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/create")
    public String prepareCreate(Model model){
        model.addAttribute("userRequest", new UserRequest());
        return "users/create-form";
    }

    @PostMapping("/create")
    public String processCreate(@Valid UserRequest userRequest, BindingResult bindings){
        log.debug("UserRequest do zapisania " + userRequest);
        if(bindings.hasErrors()){
            return "users/create-form";
        }
        User user = userRequest.toUser();
        userRepository.save(user);
        log.debug("User zapisany " + user);
        return "redirect:home-loged";
    }
}
