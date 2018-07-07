package com.js.scion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import redis.clients.jedis.Jedis;
/**
 *
 * @author jack
 */
@Controller
public class GreetingController {
    
    Jedis db;
   
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World")
                            String name, Model model){
        model.addAttribute("name", name);
        return "greeting";
    }
}
