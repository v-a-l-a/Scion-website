package com.js.scion;

import com.js.scion.model.Raider;
import com.js.scion.model.RaiderList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.js.scion.data.RaiderRepository;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author sjack
 */
@Controller
public class RaiderController {

    @Autowired
    private RaiderRepository repo;
    
    
    

    @ResponseBody
    @GetMapping(value = "/raiders/all", produces = "application/json")
    public RaiderList listRaiders() {

        RaiderList raiders = new RaiderList(repo.findAll());
        System.out.println("Raiders: " + raiders);
        return raiders;
    }
    
//    @ResponseBody
//    @GetMapping(value = "/raiders/{id}")
//    public Raider getRaiderById(@RequestParam(name="id", required = true) String id){
//        return repo.findByID(id);
//        
//    }
    
}
