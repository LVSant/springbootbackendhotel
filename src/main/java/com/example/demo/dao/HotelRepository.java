package com.example.demo.dao;

import com.example.demo.model.Hotel;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {

    @Override
    public List<Hotel> findAll();
}
