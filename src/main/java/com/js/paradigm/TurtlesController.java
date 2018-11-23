package com.js.paradigm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TurtlesController {

    @RequestMapping(value = "/turtles", produces = "text/html")
    public String displayTurtles(){
        return "turtles";
    }
}
