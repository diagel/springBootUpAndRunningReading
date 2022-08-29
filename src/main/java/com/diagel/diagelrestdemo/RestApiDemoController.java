package com.diagel.diagelrestdemo;

import com.diagel.diagelrestdemo.repositories.DeliveryRepository;
import com.diagel.diagelrestdemo.resources.Delivery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deliveries")
public class RestApiDemoController {
    private final DeliveryRepository repository;

    public RestApiDemoController(DeliveryRepository repository) {
        this.repository = repository;

        this.repository.saveAll(List.of(
                new Delivery("32154654"),
                new Delivery("54878998"),
                new Delivery("65465879"),
                new Delivery("32154688"),
                new Delivery("95548887"),
                new Delivery("32154654")
        ));
    }

    /**
     * GET
     */
    @GetMapping
    Iterable<Delivery> getDeliveries() {
        return repository.findAll();
    }
    @GetMapping("/byNumber/{number}")
    Iterable<Delivery> getDeliveriesByName(@PathVariable String number){
        List<Delivery> list = new ArrayList<>();
        for (Delivery d: repository.findAll()){
            if (d.getNumber().equals(number)) list.add(d);
        }
        return list;
    }
    @GetMapping("/{number}")
    Optional<Delivery> getDelivery(@PathVariable String number) {
        return repository.findById(number);
    }

    /**
     * POST
     */
    @PostMapping
    Delivery postDelivery(@RequestBody Delivery delivery) {
        return repository.save(delivery);
    }

    /**
     * PUT
     */
    @PutMapping("/{id}")
    ResponseEntity<Delivery> putDelivery(@PathVariable String id,
                                         @RequestBody Delivery delivery) {

        return (!repository.existsById(id))
                ? new ResponseEntity<>(repository.save(delivery), HttpStatus.CREATED)
                : new ResponseEntity<>(repository.save(delivery), HttpStatus.OK);
    }

    /**
     * DELETE
     */
    @DeleteMapping("/{id}")
    void deleteDelivery(@PathVariable String id) {
        repository.deleteById(id);
    }
}
