package bakery.core;

import bakery.common.ExceptionMessages;
import bakery.common.OutputMessages;
import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.bakedFoods.interfaces.Bread;
import bakery.entities.bakedFoods.interfaces.Cake;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.drinks.interfaces.Tea;
import bakery.entities.drinks.interfaces.Water;
import bakery.entities.tables.interfaces.InsideTable;
import bakery.entities.tables.interfaces.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;

import java.util.Collection;
import java.util.stream.Collectors;

import static bakery.common.ExceptionMessages.*;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private static double totalIncome;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
    }


    @Override
    public String addFood(String type, String name, double price) {
        if (this.foodRepository.getByName(name)!=null){
          return String.format(FOOD_OR_DRINK_EXIST, type, name);
        }
        BakedFood food;
         switch (type){
             case "Bread":
                 food = new Bread(name,price);break;
             case "Cake":
                 food = new Cake(name, price);break;
             default:
                 throw new IllegalStateException("Unexpected value: " + type);
         }
         this.foodRepository.add(food);

         return String.format(FOOD_ADDED, food.getName(),food.getClass().getSimpleName());
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        if (drinkRepository.getByNameAndBrand(name,brand)!=null){
            return String.format(FOOD_OR_DRINK_EXIST, type, name);
        }
        Drink drink;
        switch (type){
            case"Tea":
                drink = new Tea(name,portion,brand);
                break;
            case "Water":
                drink = new Water(name,portion,brand);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }

        drinkRepository.add(drink);

        return String.format(DRINK_ADDED, drink.getName(),drink.getBrand());
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        if (tableRepository.getByNumber(tableNumber)!=null){
            return String.format(TABLE_EXIST,tableNumber);
        }
        Table table;
        switch (type){
            case "InsideTable":
                table = new InsideTable(tableNumber,capacity);
                break;
            case "OutsideTable":
                table = new OutsideTable(tableNumber,capacity);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        tableRepository.add(table);

        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        Table table;
        table= tableRepository.getAll().stream()
                .filter(t -> !t.isReserved() && t.getCapacity() >= numberOfPeople)
                .findFirst().orElse(null);
        if (table ==null){
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        table.reserve(numberOfPeople);
        return String.format(TABLE_RESERVED,table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Table table;

        table = tableRepository.getByNumber(tableNumber);
        if (table==null||!table.isReserved()){
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        BakedFood food = foodRepository.getByName(foodName);
        if(food ==null){
            return String.format(NONE_EXISTENT_FOOD, foodName);
        }
        table.orderFood(food);
        return String.format(FOOD_ORDER_SUCCESSFUL, table.getTableNumber(), food.getName());
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
       Table table = tableRepository.getByNumber(tableNumber);
        if (table==null||!table.isReserved()){
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

       Drink drink =  drinkRepository.getByNameAndBrand(drinkName,drinkBrand);
        if (drink==null){
            return String.format(NON_EXISTENT_DRINK,drinkName,drinkBrand);
        }
        table.orderDrink(drink);
        return String.format(DRINK_ORDER_SUCCESSFUL, table.getTableNumber(),drink.getName(),drink.getBrand());

    }

    @Override
    public String leaveTable(int tableNumber) {
        Table table = tableRepository.getByNumber(tableNumber);
        double bill = table.getBill();
        totalIncome += bill;
        table.clear();
        return String.format(BILL, table.getTableNumber(),bill);
    }

    @Override
    public String getFreeTablesInfo() {
      return  tableRepository.getAll().stream().filter(t->!t.isReserved())
              .map(Table::getFreeTableInfo).collect(Collectors.joining(System.lineSeparator()));

    }

    @Override
    public String getTotalIncome() {

        return String.format(TOTAL_INCOME, totalIncome);
    }
}
