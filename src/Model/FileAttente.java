package Model;

public abstract class FileAttente {

    //arrivee
    protected double λ;

    //service
    protected double μ;

    //ratio arrivée/service
    protected double ρ;

    public FileAttente()
    {}

    public FileAttente(int λ, int μ)
    {
        this.λ = λ;
        this.μ = μ;
    }
}
