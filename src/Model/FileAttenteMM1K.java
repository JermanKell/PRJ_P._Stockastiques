package Model;

public class FileAttenteMM1K extends FileAttente {

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

    //  Borne max de clients dan la file d'attente, service compris
    private int K;

    // Constructeur de la classe
    public FileAttenteMM1K(double lambda, double mu, int K) {
        super(lambda, mu);
        ρ = (λ/μ);
        this.K = K;

        Calculs();
    }

    // Lancement de tous les calculs
    public void Calculs() {
        q0();
        L();
        Lq();
        Wq();
        W();
    }

    // Calcul de la proba d'etre dans l'etat initial
    private void q0() {
        q0 = Qj(0);
    }

    // Calcul proba d'être a l'etat j
    private double Qj(int j) {
        if (j <=0) { throw new IllegalArgumentException("Paramètre j doit être supérieur à 0"); }
        else if (j > K) { throw new IllegalArgumentException("Paramètre j doit être inférieur ou egal à K"); }
        else if (ρ == 1){ return 1/(K+1); }
        else { return (1-(ρ)*(Math.pow(ρ, j)))/(1-(Math.pow(ρ, K+1))); }
    }

    // Calcul du nombre de clients dans la queue
    private void Lq() {
        Lq = L - (1 - q0);
    }

    // Calcul du nombre de clients dans le systeme
    private void L() {
       if(ρ == 1) { L = K/2; }
       else { L = ρ*((1-(K+1)*Math.pow(ρ, K)+(K*(Math.pow(ρ, K+1))))/((1-ρ)*(1-(Math.pow(ρ, K+1))))); }
    }

    // Calcul de la duree moyenne d'attente dans la queue
    private void Wq() {
        Wq = λ / (μ * ( μ - λ ));
    }

    // Calcul de la duree moyenne d'attente dans le systeme
    private void W() {
        W = 1 / ( μ - λ );
    }

    // Calcul proba qu'un client reste t ou plus dans le systeme
    private double PrDureeSejSys(double t) {
        if(t<0) { throw new IllegalArgumentException("t doit être positif"); }
        else { return Math.exp(-μ * (1 - ρ) * t ); }
    }
}