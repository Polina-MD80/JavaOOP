package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
    private Astronaut astronaut1;
    private Astronaut astronaut2;
    private Spaceship spaceship;

    @Before
    public void setUp() {
        spaceship = new Spaceship("test_Spaseship", 5);
        astronaut1 = new Astronaut("Gosho", 0);
        astronaut2 = new Astronaut("Peso", 2);
    }

    @Test(expected = NullPointerException.class)
    public void setWithEmptyName() {
        spaceship = new Spaceship(" ", 2);
    }

    @Test(expected = NullPointerException.class)
    public void setWithNullName() {
        spaceship = new Spaceship(null, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNegativeCapacityShouldFail() {
        new Spaceship("HoHo", -1);
    }

    @Test
    public void tryToRemoveInvalidAstronaut() {
        spaceship.add(astronaut1);
        Assert.assertFalse(spaceship.remove(astronaut2.getName()));
    }

    @Test
    public void tryToRemoveValidAstronaut() {
        spaceship.add(astronaut1);
        Assert.assertTrue(spaceship.remove(astronaut1.getName()));
        Assert.assertEquals(0, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMoreThanCapacity() {
        Spaceship spaceship = new Spaceship("HoHo", 1);
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addTheSameSecondTime() {
        spaceship.add(astronaut1);
        spaceship.add(astronaut1);
    }
}

