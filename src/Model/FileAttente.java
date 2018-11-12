package Model;

public class FileAttente {

    //arrivee
    private int λ;

    //service
    private int μ;

    //
    private double ρ;

    public FileAttente(int λ, int μ)
    {
        this.λ = λ;
        this.μ = μ;
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


}
