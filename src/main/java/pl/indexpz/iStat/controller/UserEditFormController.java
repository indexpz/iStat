package pl.indexpz.iStat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.iStat.controller.converter.UserConverter;
import pl.indexpz.iStat.controller.dto.UserEditForm;
import pl.indexpz.iStat.domain.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/forms/user")
@Slf4j
public class UserEditFormController {

    private final UserService userService;
    private final UserConverter userConverter;

    public UserEditFormController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }
        @GetMapping("/edit")
        public String prepareEdit(Long id, Model model){
//            UserEditForm data = userConverter.toUserEditForm(userService.getById(id));
            log.info("Wczytano użytkownika "+userService.getById(id));
            model.addAttribute("user", userService.getById(id));
            return "users/edit-form";
    }

    @PostMapping("/edit")
    public String processEdit(@Valid UserEditForm data, BindingResult bindings){
        log.info("---------------------------------------------\nUser do edycji " + data);
        if(bindings.hasErrors()){
            return "users/edit-form";
        }
        userService.update(userConverter.from(data));
        log.info("---------------------------------------------\nUser po edycji" + data);
        return "redirect:/forms/user/list";
    }
}
