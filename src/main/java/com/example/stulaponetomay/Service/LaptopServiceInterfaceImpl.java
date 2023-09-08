package com.example.stulaponetomay.Service;

import com.example.stulaponetomay.dao.LaptopRepo;
import com.example.stulaponetomay.dto.LaptopDto;
import com.example.stulaponetomay.entity.Laptop;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LaptopServiceInterfaceImpl implements LaptopServiceInterface {

    @Autowired
    private LaptopRepo laptopRepo;

    @Autowired
    private ModelMapper modelMapper;

    private LaptopDto convertToDto(Laptop laptop){
        LaptopDto laptopDto = modelMapper.map(laptop, LaptopDto.class);
        return laptopDto;
    }

    private Laptop convertToEntity(LaptopDto laptopDto){
        Laptop laptop = modelMapper.map(laptopDto, Laptop.class);
        return laptop;
    }


    @Override
    public void addLaptop(LaptopDto laptopDto) {
        Laptop laptop = convertToEntity(laptopDto);
        laptopRepo.save(laptop);
    }



    @Override
    public void addAllLaptops(List<LaptopDto> laptops) {
        List<Laptop> laptopList = laptops.stream().map(laptopDto -> convertToEntity(laptopDto)).collect(Collectors.toList());
        laptopList.stream().forEach(laptop -> System.out.println(laptop));
        laptopRepo.saveAll(laptopList);
    }

    @Override
    public Laptop getLaptopById(Long id) {
        Optional<Laptop> laptop = laptopRepo.findById(id);
        return laptop.orElse(null);
    }

    @Override
    public List<Laptop> getAllLaptops() {

        return laptopRepo.findAll();
    }

    @Override
    public void updateLaptopById(Long id, LaptopDto laptopDto) {
        Laptop laptop = laptopRepo.findById(id).get();
        laptop.setLname(laptopDto.getLname());
        laptop.setStudent(laptopDto.getStudent());
        laptopRepo.save(laptop);
    }

    @Override
    public void deleteLaptopById(Long id) {

        laptopRepo.deleteById(id);

    }
}
