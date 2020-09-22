package org.example.javatest2;


import org.example.javatest2.domain.ArrClass;
import org.example.javatest2.repos.ArrClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private ArrClassRepo arrClassRepo;

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<ArrClass> arrs = arrClassRepo.findAll();

        model.put("arrs", arrs);
        return "main";
    }
    @PostMapping
    public String add(Map<String, Object> model){
        ArrClass arrClass = new ArrClass(10);
        arrClass.sortArr();
        arrClassRepo.save(arrClass);

        Iterable<ArrClass> arrs = arrClassRepo.findAll();
        model.put("arrs", arrs);
        return "main";
    }
}
