package opalinski.jakub.currencieswebapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocketController {

    @RequestMapping("/currencies")
    public String showPage(){
        return "Page.html";
    }
}
