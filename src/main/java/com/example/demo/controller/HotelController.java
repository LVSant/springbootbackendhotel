package com.example.demo.controller;

import com.example.demo.dao.HotelRepository;
import com.example.model.Hotel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private final HotelRepository repository;

    public HotelController(HotelRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/all")
    public List<Hotel> getAll() {
        List<Hotel> hotels = repository.findAll();
        hotels.add(new Hotel("hardcoded test", 0, null, null));
        return hotels;
    }

}
