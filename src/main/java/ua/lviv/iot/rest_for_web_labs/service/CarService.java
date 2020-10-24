package ua.lviv.iot.rest_for_web_labs.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.rest_for_web_labs.db.CarRepository;
import ua.lviv.iot.rest_for_web_labs.models.Car;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {
    private final CarRepository repository;

    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(repository.findAll());
    }

    public void addCar(Car car) {
        repository.save(car);
    }

    public void deleteCar(Integer id) {
        repository.deleteById(id);
    }

    public Car updateCar(Integer id, Car car) {
        Car oldCar = repository.getOne(id);
        car.setId(id);
        repository.save(car);
        return oldCar;
    }
}
