package ua.lviv.iot.rest_for_web_labs.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.rest_for_web_labs.models.Car;
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
