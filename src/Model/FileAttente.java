package Model;

import static Model.Maths.factorial;

public abstract class FileAttente {

    // arrivee
    protected double λ = 0.0;

    // service
    protected double μ = 0.0;

    // taux de saturation du systeme
    protected double ρ = 0.0;

    //////// Resultat a retourner \\\\\\\\\\\\\
    // Proba d'etre dans l'etat initial
    protected double q0 = 0.0;

    // Nombre de clients dans le systeme
    protected double L = 0.0;

    // Nombre de clients dans la file d'attente
    protected double Lq = 0.0;

    // Duree d'attente dans le systeme
    protected double Wq = 0.0;

    // Duree d'attente dans la file d'attente
    protected double W = 0.0;

    public FileAttente(double λ, double μ)
    {
        this.λ = λ;
        this.μ = μ;
    }

    // Proba qu'il y ait k client qui arrive sur une unité de temps
    public double getPrPoisson(int k) { return ((Math.pow(λ, k))/factorial(k).longValue())*Math.exp(-λ); }

}
