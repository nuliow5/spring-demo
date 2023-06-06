package lt.gerasimovas.springdemo.controller;

import lt.gerasimovas.springdemo.model.Car;
import lt.gerasimovas.springdemo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/car-create")
    public String showCardCreateForm(Model model){
        model.addAttribute("car", new Car());
        return "create-car";
    }

    @PostMapping("/car-create")
    public String createCar(@ModelAttribute("car") Car car, Model model){
        List<Car> cars = carService.createCar(car);
        model.addAttribute("cars", cars);

        return "car_list_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") long id, Model model){
        List<Car> cars = carService.removeCarById(id);

        model.addAttribute("cars", cars);

        return "car_list_form";
    }

    @GetMapping("/update/{id}")
    public String editCar(@PathVariable("id") long id, Model model){
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);

        return "edit_car";
    }

    @PutMapping("/update/{id}")
    public String editCar(@PathVariable("id") long id, @ModelAttribute Car car, Model model){
        List<Car> cars = carService.updateCarById(id, car);
        model.addAttribute("cars", cars);

        return "car_list_form";
    }

    @GetMapping("/sort")
    public String sortCarsTablet(@ModelAttribute("car") Car car, Model model){
        List<Car> cars = carService.sortByEngineSize();
        model.addAttribute("cars", cars);

        return "car_list_form";

    }





}
