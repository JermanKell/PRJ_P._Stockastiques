package Model;

import java.math.BigInteger;

public class FileAttenteMMS {
   // Parametre du processus d'arrivee
    private double λ = 0.0;

    // Parametre du processus de service
    private double μ = 0.0;

    public double getΡ() {
        return ρ;
    }

    public double getQ0() {
        return q0;
    }

    public double getL() {
        return L;
    }

    public double getLq() {
        return Lq;
    }

    public double getWq() {
        return Wq;
    }

    public double getW() {
        return W;
    }

    // Taux de saturation du systeme
    private double ρ = 0.0;

    // Nombre de serveurs de l'exemple
    private int nbServeurs = 0;

    // Nombre de clients
    private int nbClients = 0;


    //////// Resultat a retourner \\\\\\\\\\\\\
    // Proba d'etre dans l'etat initial
    private double q0 = 0.0;

    // Nombre de clients dans le systeme
    private double L = 0.0;

    // Nombre de clients dans la file d'attente
    private double Lq = 0.0;

    // Duree d'attente dans le systeme
    private double Wq = 0.0;

    // Duree d'attente dans la file d'attente
    private double W = 0.0;


    // Constructeur de la classe
    public FileAttenteMMS(double lambda, double mu, int serveurs, int clients) {
        λ = lambda;
        μ = mu;
        nbServeurs = serveurs;
        nbClients = clients;

        ρ = (λ/(nbServeurs*μ));
    }

    // Calcul de la proba d'etre dans l'etat initial
    public void q() {
        double denom = 0.0;

        for (int j = 0; j < nbServeurs-1; j++) {
            denom += (Math.pow(ρ*nbServeurs, j) / factorial(j).doubleValue()) +
                    (Math.pow(ρ*nbServeurs, nbServeurs) / (factorial(nbServeurs).doubleValue() * (1-ρ)));
        }

        q0 = 1/denom;
    }

    // Calcul du nombre de clients dans la queue
    public void Lq() {
        Lq = q0 * ((Math.pow(ρ*nbServeurs, nbServeurs) * ρ) / (factorial(nbServeurs).doubleValue() * Math.pow(1-ρ, 2)));
    }

    // Calcul du nombre de clients dans le systeme
    public void L() {
        L = Lq + (λ / μ);
    }

    // Calcul de la duree moyenne d'attente dans le systeme
    public void Wq() {
        Wq = Lq / λ;
    }

    // Calcul de la duree moyenne d'attente dans la file d'attente
    public void W() {
        W = Wq + (1 / μ);
    }

    // Calcul du factoriel pour un nombre passe en parametre de la methode
    public static BigInteger factorial(long number) {
        BigInteger result = BigInteger.valueOf(1);

        for (long factor = 2; factor <= number; factor++) {
            result = result.multiply(BigInteger.valueOf(factor));
        }

        return result;
    }


}
