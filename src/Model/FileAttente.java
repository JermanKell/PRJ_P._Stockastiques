package Model;

import java.math.BigInteger;

public class FileAttente {

    //arrivee
    private double λ;

    //service
    private double μ;

    //
    private double ρ;

    public FileAttente(int λ, int μ)
    {
        this.λ = λ;
        this.μ = μ;
        ρ = (this.λ/this.μ);
    }

    //nb moyen de clients dans la file
    public double Lq()
    {
        return ((Math.pow(λ, 2))/(μ*(μ-λ)));
    }

    //nb moyen L de clients dans le systeme
    public double L()
    {
        return (λ/(μ-λ));
    }

    //duree moyenne d'attente d'1 client quelquonque dans la file
    public double Wq()
    {
        return (W()-(1/μ));
    }

    //duree moyenne d'attente dans le systeme
    public double W()
    {
        return (1/(μ-λ));
    }

    //probabilite de se trouver a l'etat j
    public double q(int j) throws Exception
    {
        if(ρ>1)
            throw new Exception("ρ doit être strictement inferieur a 1");
        if(j==0)
            return (1-ρ);
        else
            return (Math.pow(ρ, j)*(1-ρ));
    }

    //probabilite d'avoir j arrivee sur un intervalle de temps
    // identique à ceux donnés en paramètre au constructreur de cet objet
    public double PXt(int j) { return (Math.pow(λ, j)/(factorial(j).doubleValue()))*Math.exp(-λ); }

    public static BigInteger factorial(long number) {
        BigInteger result = BigInteger.valueOf(1);

        for (long factor = 2; factor <= number; factor++) {
            result = result.multiply(BigInteger.valueOf(factor));
        }

        return result;
    }
}


