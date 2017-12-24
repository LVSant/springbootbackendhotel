package com.example.dbseeder;

import com.example.model.Address;
import com.example.model.Hotel;
import com.example.model.Review;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner {

    private final MongoTemplate hotelTemplate;

    public DbSeeder(MongoTemplate hotelTemplate) {
        this.hotelTemplate = hotelTemplate;
    }

    @Override
    public void run(String... strings) throws Exception {

        Hotel hotelOne = new Hotel("Teste Hotel 1", 25, new Address("New York", "USA"), Arrays.asList(new Review("User 1", 10, true)));
        Hotel hotelTwo = new Hotel("Teste Hotel 2", 425, new Address("Denver", "USA"), Arrays.asList(new Review("User 2", 70, false)));
        Hotel hotelThree = new Hotel("Teste Hotel 3", 425, new Address("Amsterdam", "NL"), Arrays.asList(new Review("User 3", 42, false)));

        this.hotelTemplate.dropCollection("hotels");

        List<Hotel> toAddHotels = Arrays.asList(hotelOne, hotelTwo, hotelThree);

        this.hotelTemplate.insertAll(toAddHotels);

    }
}
