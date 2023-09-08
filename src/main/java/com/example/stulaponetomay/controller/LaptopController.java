package com.example.stulaponetomay.controller;

import com.example.stulaponetomay.Service.LaptopServiceInterfaceImpl;
import com.example.stulaponetomay.dto.LaptopDto;
import com.example.stulaponetomay.entity.Laptop;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/laptop")
public class LaptopController {

    @Autowired
    private LaptopServiceInterfaceImpl laptopService;

    @GetMapping
    public List<Laptop> getAllLaptops(){
        return laptopService.getAllLaptops();
    }

    @GetMapping("{laptopId}")
    public Laptop getLaptopById(Long laptopId){
        return laptopService.getLaptopById(laptopId);
    }

    @PostMapping
    public void addLaptop(@RequestBody LaptopDto laptopDto){
        laptopService.addLaptop(laptopDto);
    }

    @PutMapping("{laptopId}")
    public void updateLaptopById(@PathVariable Long laptopId, @RequestBody LaptopDto laptopDto){
        laptopService.updateLaptopById(laptopId, laptopDto);
    }

    @DeleteMapping("{laptopId}")
    public void deleteLaptopById(@PathVariable Long laptopId){
        laptopService.deleteLaptopById(laptopId);
    }
}
