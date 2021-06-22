package pl.indexpz.iStat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.iStat.controller.converter.UserConverter;
import pl.indexpz.iStat.controller.dto.UserCreateForm;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/forms/user")
@Slf4j
public class UserCreateFormController {

    private final UserService userService;
    private final UserConverter userConverter;

    public UserCreateFormController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }


    @GetMapping("/add")
    public String prepareCreate(Model model){
        model.addAttribute("data", new UserCreateForm());
        return "users/create-form";
    }

    @PostMapping("/add")
    public String processCreate(@Valid UserCreateForm data, BindingResult bindings){
        log.debug("User do zapisania " + data);
        if(bindings.hasErrors()){
            return "users/create-form";
        }
        User user = data.toUser();
        userService.add(user);
        log.debug("User zapisany " + user);
        return "redirect:/";
    }
}
