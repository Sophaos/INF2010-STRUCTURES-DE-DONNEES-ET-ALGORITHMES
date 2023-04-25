import java.util.ArrayList;

// Implémentation de l'interface IBibliotheque
// à l'aide d'un arbre de recherche binaire.
public class BibliothequeBst implements IBibliotheque
{
    private BST<String> livres = new AvlTree<String>();

    // Complexité: O(log(n))
    // Explication:
    public void ajouterLivre(String livre)
    {
    	// � compl�ter
        livres.insert(livre);
    }

    // Complexité: O(log(n))
    // Explication:
    public boolean contientLivre(String livre)
    {
    	// � compl�ter
        return livres.contains(livre);
    }

    // Complexité: O(n)
    // Explication: Il ne suffit ici que de parcourir
    //              l'arbre de recherche binaire selon
    //              un parcours en ordre/ascendant.
    public String afficherLivresAlpha()
    {
    	// � compl�ter
        ArrayList<String> s= livres.traverseInOrder();
        String output="";
        for(int i=0; i< s.size();i++){
            output+=s.get(i) + '\n';
        }
        return output;
    }

    // Complexité: O(n)
    // Explication: Il ne suffit ici que de parcourir
    //              l'arbre de recherche binaire selon
    //              un parcours en ordre inverse/descendant.
    public String afficherLivresAlphaInverse()
    {
    	// � compl�ter
        ArrayList<String> s= livres.traverseReverseOrder();
        String output="";
        for(int i=0; i< s.size();i++){
            output+=s.get(i) + '\n';
        }
        return output;
    }
}