package com.js.paradigm;

import com.js.paradigm.model.RaiderList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.js.paradigm.data.RaiderRepository;
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
