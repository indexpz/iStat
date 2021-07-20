package pl.indexpz.iStat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Slf4j
public class HomePageController {

    @GetMapping("/")
    public String prepareHome() {
        //TODO Używać loggera, ale tam gdzie ma to sens, np. przed/po zapisie do bazy danych + dane na wejściu do kontrolera/serwisu
        log.info("Start home.jsp");
        return "home/homepage";
    }
}
