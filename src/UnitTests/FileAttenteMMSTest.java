package UnitTests;

import Model.FileAttenteMMS;
import org.junit.Assert;
import org.junit.Test;

public class FileAttenteMMSTest {

    /*
        Test TD employes aeroport
     */
    public FileAttenteMMS file = new FileAttenteMMS(10F, 12F, 2, 0);

    @Test
    public void test1() {
        // On verifie le taux de saturation
        Assert.assertEquals(5/12, file.getΡ(), 0.001);
        // On verifie le resultat obtenu pour q0
        Assert.assertEquals(0.412, file.getQ0(), 0.02);
        // On verifie le resultat pour W (duree d'attente moyenne dans le systeme)
        Assert.assertEquals(0.101, file.getW(), 0.01);
        // On verifie le resultat pour Wq (duree d'attente moyenne dans la file)
        Assert.assertEquals(0.0175, file.getWq(), 0.001);
        // Valeur de L
        Assert.assertEquals(1.01, file.getL(), 0.01);
        // Valeur de Lq
        Assert.assertEquals(0.175, file.getLq(), 0.001);
    }
    
}