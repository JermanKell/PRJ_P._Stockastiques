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

<<<<<<< HEAD:src/FileAttente.java
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

    public static void main(String [] args)
    {

    }
=======
>>>>>>> b4a543ac30b9d8248d90aa7b68a91f751b571153:src/Model/FileAttente.java
}
