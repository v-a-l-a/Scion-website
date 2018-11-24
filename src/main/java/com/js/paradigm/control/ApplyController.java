package com.js.paradigm.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplyController {

    @RequestMapping(value = "/apply", produces = "text/html")
    public String displayApply(){
        return "apply";
    }
}
