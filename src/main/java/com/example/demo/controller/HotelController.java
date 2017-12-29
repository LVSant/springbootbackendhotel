package com.example.demo.controller;

import com.example.demo.dao.HotelRepository;
import com.example.demo.model.Hotel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<Hotel> getAll() {
        List<Hotel> hotels = repository.findAll();
        if (hotels != null) {
            if (!hotels.isEmpty()) {
                return new ResponseEntity(hotels, HttpStatus.OK);
            }
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void newHotel(@RequestBody Hotel hotel) {
        hotel.setId(null); //a new hotel must have null ID so MongoDB creates one
        repository.save(hotel);
    }

    @RequestMapping(value = "/{hotelId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Hotel> getOne(@PathVariable String hotelId) {
        if (hotelId != null && !hotelId.isEmpty()) {
            Hotel hotel = repository.findOne(hotelId);
            if (hotel != null) {
                return new ResponseEntity(hotel, HttpStatus.OK);
            }
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
