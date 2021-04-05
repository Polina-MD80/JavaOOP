package bankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class BankVaultTest {
    private BankVault bankVault;
    private Item item1;
    private Item item2;

    @Before
    public void setUp() {
        bankVault = new BankVault();
        item1 = new Item("Me", "Gold");
        item2 = new Item("Ra", "Silver");

    }

    @Test
    public void testConstructor() {
        Assert.assertEquals(12, bankVault.getVaultCells().size());
        Assert.assertFalse(bankVault.getVaultCells().values().stream().anyMatch(Objects::nonNull));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testToPutSThInNonExistingCell() throws OperationNotSupportedException {
        bankVault.addItem("BB", item1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testToPutSThInBusyCell() throws OperationNotSupportedException {
        bankVault.addItem("A1", item1);
        bankVault.addItem("A1", item2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testToPutExistingItemInAnotherCell() throws OperationNotSupportedException {
        bankVault.addItem("A1", item1);
        bankVault.addItem("A2", item1);
    }

    @Test
    public void addItem() throws OperationNotSupportedException {
        String result = bankVault.addItem("A1", item1);
        Assert.assertEquals(item1.getItemId(), bankVault.getVaultCells().get("A1").getItemId());
        Assert.assertEquals(item1.getOwner(), bankVault.getVaultCells().get("A1").getOwner());
        Assert.assertEquals("Item:Gold saved successfully!",result);

    }

    @Test(expected = IllegalArgumentException.class)
    public void tesToRemoveFromNonExistingCell() {
        bankVault.removeItem("C12", item1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tesToRemoveIteFromNonExistingInTheCell() throws OperationNotSupportedException {
        bankVault.addItem("A1", item1);
        bankVault.removeItem("A1", item2);
    }

    @Test()
    public void tesToRemove() throws OperationNotSupportedException {
        bankVault.addItem("A1", item1);
       String result =  bankVault.removeItem("A1", item1);
        Assert.assertNull(bankVault.getVaultCells().get("A1"));
        Assert.assertEquals("Remove item:Gold successfully!", result);

    }


}