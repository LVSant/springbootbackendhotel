package com.example.controller;

import com.example.dao.HotelRepository;
import com.example.model.Hotel;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelRepository repository;

    public HotelController(HotelRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Hotel> getAll() {
        List<Hotel> hotels = repository.findAll();

        return hotels;
    }
}
