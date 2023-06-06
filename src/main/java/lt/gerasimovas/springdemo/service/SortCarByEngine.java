package lt.gerasimovas.springdemo.service;

import lt.gerasimovas.springdemo.model.Car;

import java.util.Comparator;

public class SortCarByEngine implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return (int) (o1.getEngineSizeDisplacement() - o2.getEngineSizeDisplacement());
    }
}
