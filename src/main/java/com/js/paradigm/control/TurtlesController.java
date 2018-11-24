package com.js.paradigm.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TurtlesController {

    @RequestMapping(value = "/turtles", produces = "text/html")
    public String displayTurtles(){
        return "turtles";
    }
}
