package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AquariumTests {
    private Aquarium aquarium;
    private Fish f;
    private Fish f1;
    private Fish f2;

    @Before
    public void setUp() {
        aquarium = new Aquarium("Test", 2);
        f = new Fish("name");
        f1 = new Fish("name1");
        f2 = new Fish("name2");
    }

    @Test
    public void test1() {
        aquarium.add(f1);
        aquarium.add(f2);
        assertEquals(2, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test2() {
        aquarium.add(f1);
        aquarium.add(f2);
        aquarium.add(f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3() {
        aquarium.add(f1);
        aquarium.add(f2);
        aquarium.remove("name");
    }

    @Test(expected = NullPointerException.class)
    public void test4() {
        aquarium = new Aquarium(null, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test5() {
        aquarium = new Aquarium("name", -1);
    }

    @Test(expected = NullPointerException.class)
    public void test6() {
        new Aquarium("  ", 3);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test7(){
        aquarium.add(f1);
        aquarium.add(f2);
        aquarium.remove("name");
    }
    @Test
    public void test8(){
        aquarium.add(f1);
        aquarium.add(f2);
        aquarium.remove("name1");
        assertEquals(1, aquarium.getCount());
    }
    @Test
    public void test9(){
        aquarium.add(f1);
        aquarium.add(f2);
       assertEquals(2, aquarium.getCapacity());
    }
    @Test
    public void test10(){
        aquarium.add(f1);
        aquarium.add(f2);
       Fish fish3 =  aquarium.sellFish("name1");
       assertEquals("name1",fish3.getName());
       assertFalse(fish3.isAvailable());
    }
    @Test(expected = IllegalArgumentException.class)
    public void test11(){
        aquarium.add(f1);
        aquarium.add(f2);
      aquarium.sellFish("name");
    }
    @Test
    public void test12(){
        aquarium.add(f);
        aquarium.add(f1);
        String result = aquarium.report();
        assertEquals("Fish available at Test: name, name1", result);
    }



}

