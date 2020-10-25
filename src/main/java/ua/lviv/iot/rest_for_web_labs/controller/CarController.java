package ua.lviv.iot.rest_for_web_labs.controller;

import com.sun.net.httpserver.Headers;
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
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class CarController {
    private final CarService service;

//    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return service.getAllCars();
    }

//    @CrossOrigin
    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        service.addCar(car);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

//    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable("id") Integer id){
        service.deleteCar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

//    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") Integer id, @RequestBody Car car){
        Car car1 = service.updateCar(id, car);
        return ResponseEntity.status(HttpStatus.OK).body(car1);
    }
}
