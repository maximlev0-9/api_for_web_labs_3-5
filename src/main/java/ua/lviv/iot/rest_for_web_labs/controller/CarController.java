package ua.lviv.iot.rest_for_web_labs.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.rest_for_web_labs.models.Car;
import ua.lviv.iot.rest_for_web_labs.service.CarService;

import java.util.List;

@RestController
@RequestMapping("cars")
@AllArgsConstructor
//@CrossOrigin(origins = "http://localhost:63343/*", maxAge = 3600)
@CrossOrigin(value = "*", origins = "*", allowedHeaders = "*", maxAge = 3L)
public class CarController {
    private final CarService service;

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return service.getAllCars();
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        service.addCar(car);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable("id") Integer id){
        service.deleteCar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") Integer id, @RequestBody Car car){
        Car car1 = service.updateCar(id, car);
        return ResponseEntity.status(HttpStatus.OK).body(car1);
    }
}
