package UnitTests;

import Model.FileAttenteMMS;
import org.junit.Assert;
import org.junit.Test;

public class FileAttenteMMSTest {

    /*
        Test TD station d'essence
     */
    public FileAttenteMMS file = new FileAttenteMMS(10F, 12F, 2);
    public FileAttenteMMS file1S = new FileAttenteMMS(10F, 12F, 1);

    @Test
    public void testMM2() {
        // On verifie le taux de saturation
        Assert.assertEquals((float)5/12, file.getΡ(), 0.001);
        // On verifie le resultat obtenu pour q0
        Assert.assertEquals((float)7/17, file.getQ0(), 0.02);
        // On verifie le resultat pour W (duree d'attente moyenne dans le systeme)
        Assert.assertEquals(0.101, file.getW(), 0.01);
        // On verifie le resultat pour Wq (duree d'attente moyenne dans la file)
        Assert.assertEquals(0.0175, file.getWq(), 0.001);
        // Valeur de L
        Assert.assertEquals(1.01, file.getL(), 0.01);
        // Valeur de Lq
        Assert.assertEquals(0.175, file.getLq(), 0.001);
        // Valeur P(Xt>2)
        Assert.assertEquals(0.102, 1 - file.getQ0() - file.getQj(1) - file.getQj(2), 0.01);
        //Proba qu'un client reste plus de 10min dans le systeme
        Assert.assertEquals(0.1918, file.getPrDureeSejSys((float)1/6), 0.0001);

        //NON VERIFIE// Proba qu'un client n'a pas de temps d'attente (sans compter le service)
        Assert.assertEquals(0.2451, file.getPrDureeSejQueue0(), 0.0001);
        //NON VERIFIE// Proba qu'un client reste plus de 10min dans la file
        Assert.assertEquals(0.0238, file.getPrDureeSejQueue((float)1/6), 0.0001);
    }

    @Test
    public void testMM1() {
        // On verifie le taux de saturation
        Assert.assertEquals((float)10/12, file1S.getΡ(), 0.001);
        // On verifie le resultat obtenu pour q0
        Assert.assertEquals((float)1/6, file1S.getQ0(), 0.02);
        // On verifie le resultat pour W (duree d'attente moyenne dans le systeme)
        Assert.assertEquals(0.5, file1S.getW(), 0.01);
        // On verifie le resultat pour Wq (duree d'attente moyenne dans la file)
        Assert.assertEquals(0.416, file1S.getWq(), 0.001);
        // Valeur de L
        Assert.assertEquals(5.0, file1S.getL(), 0.001);
        // Valeur de Lq
        Assert.assertEquals(4.166, file1S.getLq(), 0.001);
        // Valeur P(Xt>2)
        Assert.assertEquals(0.579, 1 - file1S.getQ0() - file1S.getQj(1) - file1S.getQj(2), 0.001);
        //Proba qu'un client reste plus de 10min dans le systeme
        Assert.assertEquals(0.716, file1S.getPrDureeSejSys((float)1/6), 0.001);

        //NON VERIFIE// Proba qu'un client n'a pas de temps d'attente (sans compter le service)
        Assert.assertEquals(0.8333, file1S.getPrDureeSejQueue0(), 0.0001);
        //NON VERIFIE// Proba qu'un client reste plus de 10min dans la file
        Assert.assertEquals(0.5971, file1S.getPrDureeSejQueue((float)1/6), 0.0001);

    }
    
}