package Model;

public class FileAttente {

    //arrivée
    private int λ;

    //service
    private int μ;

    //nb serveurs
    private int s;

    //
    private double ρ;

    public FileAttente(int λ, int μ, int s)
    {
        this.λ = λ;
        this.μ = μ;
        this.s = s;
    }

    //nb moyen de clients dans la file
    public double Lq()
    {

        return ((Math.pow(λ, 2))/(μ*(μ-λ)));
    }

    //nb moyen L de clients dans le système
    public double L()
    {
        return (λ/(μ-λ));
    }
    

}
