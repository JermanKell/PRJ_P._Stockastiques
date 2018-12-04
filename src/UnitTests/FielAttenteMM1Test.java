package UnitTests;

import Model.FileAttenteMM1;
import org.junit.Assert;
import org.junit.Test;

public class FielAttenteMM1Test {
    private FileAttenteMM1 file = new FileAttenteMM1(10, 12);

    @Test
    public void test1() {
        // Test Lq
        Assert.assertEquals(4.1666, file.Lq(), 0.0001);
        // Test L
        Assert.assertEquals(5, file.L(), 0.001);
        // Test W
        Assert.assertEquals(0.5, file.W(), 0.001);
        // Test Wq
        Assert.assertEquals(0.416,file.Wq(), 0.001);
    }
}
