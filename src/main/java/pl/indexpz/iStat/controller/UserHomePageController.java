package pl.indexpz.iStat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.iStat.domain.service.UserService;

@Controller
@RequestMapping("/user/homepage")
@RequiredArgsConstructor //zamiast konstruktora
public class UserHomePageController {

//    User user = SecurityContextHolder.getContext().getAuthentication();

    private final UserService userService;

    @GetMapping
    public String prepareHomePage(Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("user",userService.getUserByUserName(username) );
        return "/users/user-homepage";
    }
}
