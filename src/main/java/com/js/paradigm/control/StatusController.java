//package com.js.paradigm;
//
//import com.js.paradigm.data.RaiderStatusRepository;
//import com.js.paradigm.model.RaiderStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// *
// * @author sjack
// */
//@Controller
//public class StatusController {
//
//    @Autowired
//    private RaiderStatusRepository raiderStatusRepo;
//
//
//    @GetMapping(value = "/status/all", produces = "application/json")
//    @ResponseBody
//    public RaiderStatus getAllRaiderStatus(){
//        return raiderStatusRepo.findAll().get(0);
//    }
//}
