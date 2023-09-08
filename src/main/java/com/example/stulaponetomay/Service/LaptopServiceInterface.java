package com.example.stulaponetomay.Service;

import com.example.stulaponetomay.dto.LaptopDto;
import com.example.stulaponetomay.entity.Laptop;

import java.util.List;

public interface LaptopServiceInterface {

    public void addLaptop(LaptopDto laptopDto);



    public void addAllLaptops(List<LaptopDto> laptopDtoList);

    public Laptop getLaptopById(Long id);

    public List<Laptop> getAllLaptops();

    public void updateLaptopById(Long id, LaptopDto laptopDto);

    public void deleteLaptopById(Long id);

}
