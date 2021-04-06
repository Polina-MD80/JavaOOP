package easterRaces.entities.cars;

import easterRaces.common.ExceptionMessages;

import static easterRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SportsCar extends BaseCar{
    public SportsCar(String model, int horsePower) {
        super(model, horsePower, 3000);
    }

    @Override
    protected void setHorsePower(int horsePower) {
        if (horsePower<250 | horsePower>450){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER,horsePower));
        }
       super.setHorsePower(horsePower);
    }
}
