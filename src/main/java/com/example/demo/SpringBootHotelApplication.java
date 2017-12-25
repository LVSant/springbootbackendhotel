package com.example.demo;

import com.example.demo.dao.HotelRepository;
import com.example.model.Hotel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHotelApplication implements CommandLineRunner {

    @Autowired
    private HotelRepository repository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootHotelApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
//        repository.deleteAll();
        List<Hotel> hotels = repository.findAll();
        System.out.println("Database Hotels: " + hotels.size());

        for (Hotel hotel : hotels) {
            System.out.println("Hotel: " + hotel.getName());
            System.out.println("At: " + hotel.getAddress().getCity() + " - " + hotel.getAddress().getCountry());
            System.out.println("For: $" + hotel.getPricePerNight());
        }
    }

}
