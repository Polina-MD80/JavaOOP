package garage;

import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GarageTests {
    private Garage garage;
    private Car car;

    @Before
    public void setUp(){
        garage = new Garage();
        car = new Car("TestBrand", 200, 50.5);
    }
    private List<Car> carsList(){
        return List.of(new Car("A", 200, 350.0),
                new Car("A", 230, 350.0),
                new Car("B", 210, 400.0),
                new Car("C", 200, 350.5),
                new Car("A", 205, 700.0),
                new Car("B", 250, 250.0),
                new Car("C", 180, 330.8));
    }
@Test
    public void testAdd(){
       garage.addCar(car);
       assertEquals(1, garage.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddWithNullCar(){
        garage.addCar(null);

    }
    @Test(expected = UnsupportedOperationException.class)
    public void testGetCars(){

        garage.getCars().add(car);

    }
    @Test
    public void findAllCarsWithMaxSpeedAbove(){
        for (Car car : this.carsList()) {
            garage.addCar(car);
        }
        List<Car> allCarsWithMaxSpeedAbove = garage.findAllCarsWithMaxSpeedAbove(210);
        assertEquals(2, allCarsWithMaxSpeedAbove.size());
        assertEquals("A", allCarsWithMaxSpeedAbove.get(0).getBrand());
        assertEquals("B", allCarsWithMaxSpeedAbove.get(1).getBrand());

    }
    @Test
    public void getTheMostExpensiveCar(){
        for (Car car : this.carsList()) {
            garage.addCar(car);
        }
        Car car = garage.getTheMostExpensiveCar();
        assertEquals("A",car.getBrand() );
        assertEquals(205,car.getMaxSpeed() );
        assertEquals(700.0,car.getPrice(),0 );

    }
    @Test
    public void findAllCarsWithBrand(){
        for (Car car : this.carsList()) {
            garage.addCar(car);
        }
        List<Car> carList = garage.findAllCarsByBrand("A");
        assertEquals(3, carList.size());
        assertEquals(200, carList.get(0).getMaxSpeed());
        assertEquals(350.0, carList.get(1).getPrice(),0);

    }

}