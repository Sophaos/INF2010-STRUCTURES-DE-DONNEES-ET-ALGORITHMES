import java.util.ArrayList;

// Impl√©mentation de l'interface IBibliotheque
// √† l'aide d'un arbre de recherche binaire.
public class BibliothequeBst implements IBibliotheque
{
    private BST<String> livres = new AvlTree<String>();

    // Complexit√©: O(log(n))
    // Explication:
    public void ajouterLivre(String livre)
    {
    	// ¿ complÈter
        livres.insert(livre);
    }

    // Complexit√©: O(log(n))
    // Explication:
    public boolean contientLivre(String livre)
    {
    	// ¿ complÈter
        return livres.contains(livre);
    }

    // Complexit√©: O(n)
    // Explication: Il ne suffit ici que de parcourir
    //              l'arbre de recherche binaire selon
    //              un parcours en ordre/ascendant.
    public String afficherLivresAlpha()
    {
    	// ¿ complÈter
        ArrayList<String> s= livres.traverseInOrder();
        String output="";
        for(int i=0; i< s.size();i++){
            output+=s.get(i) + '\n';
        }
        return output;
    }

    // Complexit√©: O(n)
    // Explication: Il ne suffit ici que de parcourir
    //              l'arbre de recherche binaire selon
    //              un parcours en ordre inverse/descendant.
    public String afficherLivresAlphaInverse()
    {
    	// ¿ complÈter
        ArrayList<String> s= livres.traverseReverseOrder();
        String output="";
        for(int i=0; i< s.size();i++){
            output+=s.get(i) + '\n';
        }
        return output;
    }
}