package ru.test.homework.controller;

import org.springframework.web.bind.annotation.*;
import ru.test.homework.model.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/car")
public class CarController {
    List<Car> cars;
    {
        System.out.println("Create List Car");
        cars = new ArrayList<>();
    }



    @GetMapping("/getAllCars")
    public List<Car> getAllCars() {
        return cars;
    }

    @GetMapping("/getCarById/{id}")
    public Car getCarById(@PathVariable int id) {
        return cars.stream()
                .filter(car -> car.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    @GetMapping("/createCar")
    public boolean createCar(int id, String brand, String color, int year, double price) {
        return cars.add(new Car(id, brand, color, year, price));
    }

    @PutMapping("/updateCar/{id}")
    public Car updateCar(@PathVariable int id, @RequestBody Car updatedCar) {
        Car existingCar = getCarById(id);

        updatedCar.setId(id);
        int index = cars.indexOf(existingCar);
        if (index != -1) {
            cars.set(index, updatedCar);
            return updatedCar;
        } else {
            return null;
        }
    }

    @PatchMapping("/patchCar/{id}")
    public Car patchCar(@PathVariable int id, @RequestBody Car partialCar) {
        Car existingCar = getCarById(id);


        if (partialCar.getBrand() != null) {
            existingCar.setBrand(partialCar.getBrand());
        }
        if (partialCar.getColor() != null) {
            existingCar.setColor(partialCar.getColor());
        }
        if (partialCar.getYear() != 0) {
            existingCar.setYear(partialCar.getYear());
        }
        if (partialCar.getPrice() != 0.0) {
            existingCar.setPrice(partialCar.getPrice());
        }

        return existingCar;
    }

    @DeleteMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable int id) {
        {
            Car car = cars.stream()
                    .filter(c -> c.getId() == id)
                    .findFirst()
                    .orElse(null);
            if (car != null) {
                cars = cars.stream().filter(c -> c.getId() != id).toList();
            }
        }
        return "Remove car";
    }

    @GetMapping("/filterCars")
    public List<Car> filterCars(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String color) {

        return cars.stream()
                .filter(car -> (brand == null || car.getBrand().equalsIgnoreCase(brand)) &&
                        (color == null || car.getColor().equalsIgnoreCase(color)))
                .collect(Collectors.toList());
    }

    @GetMapping("/sortCars")
    public List<Car> sortCars(
            @RequestParam(required = false, defaultValue = "price") String by,
            @RequestParam(required = false, defaultValue = "asc") String order) {

        Comparator<Car> comparator;
        if ("year".equalsIgnoreCase(by)) {
            comparator = Comparator.comparing(Car::getYear);
        } else {
            comparator = Comparator.comparing(Car::getPrice);
        }

        if ("desc".equalsIgnoreCase(order)) {
            comparator = comparator.reversed();
        }

        return cars.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}




