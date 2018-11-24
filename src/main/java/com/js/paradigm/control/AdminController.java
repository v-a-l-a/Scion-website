package com.js.paradigm.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {


    @RequestMapping(path = "/login", produces = "text/html")
    public String loadLogin(){
        return "login";
    }

    @RequestMapping(path = "/paradigm/admin", produces = "text/html")
    public String loadAdmin(){
        return "admin";
    }
}
