package lt.gerasimovas.springdemo.service;

import lombok.Getter;
import lt.gerasimovas.springdemo.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Getter
public class CarService {
    private List<Car> cars = new ArrayList<>();
    private Long index = 1L;

    public List<Car> createCar(Car car){
        car.setId(index);
        cars.add(car);
        index++;
        return  cars;
    }

    public List<Car> removeCarById(long id) {
        cars.removeIf(car -> car.getId().equals(id));

        return cars;
    }

    public Car getCarById(long id) {
        Car carToGet =
                cars.stream()
                        .filter(car -> car.getId().equals(id))
                        .findFirst().orElseThrow();

        return carToGet;
    }

    public List<Car> updateCarById(long id, Car car) {
        Car updatingCar = getCarById(id);
        updatingCar.setName(car.getName());
        updatingCar.setEngineSizeDisplacement(car.getEngineSizeDisplacement());
        updatingCar.setFuelType(car.getFuelType());
        updatingCar.setWeight(car.getWeight());

        return cars;
    }

    public List<Car> sortByEngineSize() {
        Collections.sort(cars, new SortCarByEngine());
        return cars;
    }


}
