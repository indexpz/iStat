package pl.indexpz.iStat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.iStat.domain.service.UserService;

@Controller
@RequestMapping("/forms/user")
@Slf4j
public class UserListController {


    private final UserService userService;


    public UserListController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String prepareList(Model model){
        model.addAttribute("users", userService.getAll());
        return "users/list";
    }
}
