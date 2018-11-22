package com.js.paradigm;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ComingSoonController {

    @RequestMapping(value = "/", produces = "text/html")
    public String displayComingSoon(){
        return "comingSoon";
    }
}
