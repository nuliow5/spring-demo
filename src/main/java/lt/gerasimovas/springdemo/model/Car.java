package lt.gerasimovas.springdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {
    private Long id;
    private String name;
    private double engineSizeDisplacement;
//    private String fuelType;

    private Fuel fuelType;
    private double weight;


}
