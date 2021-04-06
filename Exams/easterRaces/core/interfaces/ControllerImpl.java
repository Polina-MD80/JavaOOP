package easterRaces.core.interfaces;

import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.CarRepository;
import easterRaces.repositories.interfaces.DriverRepository;
import easterRaces.repositories.interfaces.RaceRepository;
import easterRaces.repositories.interfaces.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static easterRaces.common.ExceptionMessages.*;
import static easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller{
   private Repository<Car> motorcycleRepository;
   private Repository<Race> raceRepository;
   private Repository<Driver> riderRepository;



    public ControllerImpl(Repository<Driver> riderRepository,Repository<Car> motorcycleRepository, Repository<Race> raceRepository) {
        this.riderRepository = riderRepository;
        this.motorcycleRepository = motorcycleRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        Driver driverToAdd;

      if (riderRepository.getByName(driver)!=null){
          throw new  IllegalArgumentException(String.format(DRIVER_EXISTS,driver));
      }
      driverToAdd  = new DriverImpl(driver);
      this.riderRepository.add(driverToAdd);
      return String.format(DRIVER_CREATED,driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;
        if (this.motorcycleRepository.getByName(model)!=null){
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }
        switch (type){
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                car = new  SportsCar(model,horsePower);
                break;
        }
        motorcycleRepository.add(car);
        return String.format(CAR_CREATED, car.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver;
        Car car;
        if (riderRepository.getByName(driverName)==null){
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND,driverName));
        }
        if (motorcycleRepository.getByName(carModel)== null){
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }
        driver = riderRepository.getByName(driverName);
        car = motorcycleRepository.getByName(carModel);
        driver.addCar(car);
        return String.format(CAR_ADDED, driver.getName(), car.getModel());
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race;
        Driver driver;
        if (raceRepository.getByName(raceName)==null){
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND,raceName));
        }
        if (riderRepository.getByName(driverName)==null){
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND,driverName));
        }
        race = raceRepository.getByName(raceName);
        driver = riderRepository.getByName(driverName);
        race.addDriver(driver);

        return String.format(DRIVER_ADDED, driver.getName(),race.getName());
    }

    @Override
    public String startRace(String raceName) {
      if (raceRepository.getByName(raceName)==null){
          throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
      }
      Race race = raceRepository.getByName(raceName);
      if (race.getDrivers().size()<3){
          throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
      }
        List<Driver> listOfWinners = race.getDrivers().stream()
                .sorted((f,s)-> Double.compare(s.getCar().calculateRacePoints(race.getLaps()),
                        f.getCar().calculateRacePoints(race.getLaps()))).
                limit(3).collect(Collectors.toList());
      raceRepository.remove(race);
      StringBuilder sb = new StringBuilder(String.format(DRIVER_FIRST_POSITION, listOfWinners.get(0).getName(), race.getName()));
      sb.append(System.lineSeparator());
      sb.append(String.format(DRIVER_SECOND_POSITION, listOfWinners.get(1).getName(), race.getName()));
      sb.append(System.lineSeparator());
      sb.append(String.format(DRIVER_THIRD_POSITION, listOfWinners.get(2).getName(), race.getName()));
        return sb.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        if (raceRepository.getByName(name)!=null){
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
        Race race = new RaceImpl(name, laps);
        raceRepository.add(race);
        return String.format(RACE_CREATED, race.getName());
    }
}
