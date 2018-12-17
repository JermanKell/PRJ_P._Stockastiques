package Model;

import static Model.Maths.factorial;

public class FileAttenteMMS extends FileAttente {

    public double getΡ() {
        return ρ;
    }

    public double getQ0() {
        return q0;
    }

    public double getQj(int j) { return  Qj(j); }

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

    public double getPrDureeSejSys(double t) { return PrDureeSejSys(t); }

    public double getPrDureeSejQueue0() { return PrDureeSejQueue0(); }

    public double getPrDureeSejQueue(double t) { return PrDureeSejQueue(t); }

    // Nombre de serveurs
    private int s = 0;

    // Constructeur de la classe
    public FileAttenteMMS(double lambda, double mu, int serveurs) {
        super(lambda, mu);
        ρ = (λ/(s*μ));
        if(ρ >= 1)
            throw new IllegalArgumentException("λ/(s*μ) doit etre inférieur a 1");
        s = serveurs;

        Calculs();
    }

    // Lancement de tous les calculs
    public void Calculs() {
        q0();
        Lq();
        L();
        Wq();
        W();
    }

    // Calcul de la proba d'etre dans l'etat initial
    private void q0() {
        double denom = 0.0F;

        for (int j = 0; j < s; j++) { denom += (Math.pow(ρ*s, j) / factorial(j).longValue()); }

        denom += (Math.pow(ρ*s, s) / (factorial(s).doubleValue() * (1-ρ)));

        q0 = 1/denom;
    }

    // Calcul proba d'être a l'etat j
    private double Qj(int j) {
        if (j <=0) { throw new IllegalArgumentException("Paramètre j doit être supérieur à 0"); }
        else if (j < s) { return (Math.pow(ρ*s, j)/factorial(j).longValue())*q0; }
        else { return ((Math.pow(s, s)*Math.pow(ρ, j))/factorial(s).longValue())*q0; }
    }

    // Calcul du nombre de clients dans la queue
    private void Lq() {
        Lq = q0 * ((Math.pow(ρ*s, s) * ρ) / (factorial(s).longValue() * Math.pow(1-ρ, 2)));
    }

    // Calcul du nombre de clients dans le systeme
    private void L() {
        L = Lq + (λ / μ);
    }

    // Calcul de la duree moyenne d'attente dans la queue
    private void Wq() {
        Wq = Lq / λ;
    }

    // Calcul de la duree moyenne d'attente dans le systeme
    private void W() {
        W = Wq + (1 / μ);
    }

    // Calcul proba qu'un client reste t ou plus dans le systeme
    private double PrDureeSejSys(double t) {
        if(t<=0) { throw new IllegalArgumentException("t doit être positif non nul"); }
        else { return Math.exp(-μ * t) *
                (1 + ((q0 * Math.pow(ρ * s, s)) / (factorial(s).longValue() * (1 - ρ))) *
                ((1 - Math.exp(-μ * t * (s - 1 - (ρ * s)))) / (s - 1 - (ρ * s)))); }
    }

    // Calcul proba qu'un client n'a pas de temps d'attente (sans service)
    private double PrDureeSejQueue0() {
        return (q0 * Math.pow(ρ * s, s))/(factorial(s).longValue()*(1 - ρ));
    }

    // Calcul proba qu'un client reste t ou plus dans la queue (sans service)
    private double PrDureeSejQueue(double t) {
        return Math.exp(-s * μ * t * (1 - ρ)) * PrDureeSejQueue0();
    }
}
