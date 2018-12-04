package Model;

import static Model.Maths.factorial;

///////////////////////////////////////////////////////////
//////////////  CHANGEMENT: MM1 VERS MM1K A FAIRE   ///////
///////////////////////////////////////////////////////////
//TODO: Transformer les formules pour MM1K
public class FileAttenteMM1K extends FileAttente {

    public FileAttenteMM1K(int λ, int μ)
    {
        super(λ, μ);
        ρ = (λ/μ);
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
            throw new Exception("ρ must be minor to 1");
        if(j==0)
            return (1-ρ);
        else
            return (Math.pow(ρ, j)*(1-ρ));
    }

    //probabilite d'avoir j arrivee sur un intervalle de temps
    // identique à ceux donnés en paramètre au constructreur de cet objet
    public double PXt(int j) { return (Math.pow(λ, j)/(factorial(j).doubleValue()))* Math.exp(-λ); }


}


