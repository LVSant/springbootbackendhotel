package com.example.demo.controller;

import com.example.demo.dao.HotelRepository;
import com.example.demo.model.Hotel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private final HotelRepository repository;

    public HotelController(HotelRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<Hotel> getAll() {
        List<Hotel> hotels = repository.findAll();
        return hotels;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void newHotel(@RequestBody Hotel hotel) {
        hotel.setId(null); //a new hotel must have null ID so MongoDB creates one
        repository.save(hotel);
    }
}
