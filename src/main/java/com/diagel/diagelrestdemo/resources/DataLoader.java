package com.diagel.diagelrestdemo.resources;

import com.diagel.diagelrestdemo.repositories.DeliveryRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DataLoader {
    private final DeliveryRepository repository;

    public DataLoader(DeliveryRepository deliveryRepository) {
        this.repository = deliveryRepository;
    }

    @PostConstruct
    private void loadData(){
        repository.saveAll(List.of(
                new Delivery("32154654"),
                new Delivery("54878998"),
                new Delivery("65465879"),
                new Delivery("32154688"),
                new Delivery("95548887"),
                new Delivery("32154654")
        ));
    }
}
