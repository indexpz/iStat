package pl.indexpz.iStat.controller.UserController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.indexpz.iStat.controller.converter.UserConverter;
import pl.indexpz.iStat.controller.dto.EditUserForm;
import pl.indexpz.iStat.domain.model.User;
import pl.indexpz.iStat.domain.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/user/editusername")
@RequiredArgsConstructor //zamiast konstruktora
@Slf4j
public class UserEditUserNameController {

    private final UserService userService;
    private final UserConverter userConverter;

    @GetMapping
    public String prepareEdit(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        EditUserForm data = userConverter.toUser(userService.getUserByUserName(username));
        log.info("-------------------------------"+data.toString());
        model.addAttribute("data", data);
        log.info("User do edycji "  + userService.getUserByUserName(username).getUsername() + ", " + userService.getUserByUserName(username).getFirstName() + ", " +userService.getUserByUserName(username).getLastName());
        return "users/user-editusernameform";
    }

    @PostMapping
    public String processEdit(@ModelAttribute("data") @Valid EditUserForm data, BindingResult bindings) {
//        log.info("User do edycji "  + user.getUsername() + ", " + user.getFirstName() + ", " + user.getLastName());
        if (bindings.hasErrors()) {
            return "users/user-editusernameform";
        }
        userService.updateUserName(userConverter.from(data));
//        log.info("User po edycji " + user.getUsername() + ", " + user.getFirstName() + ", " + user.getLastName());
        return "redirect:/login";
    }
}
