
import java.util.ArrayList;

public class Monceau {
    ArrayList<Node> arbres;
    
    public Monceau() {
        arbres = new ArrayList<Node>();
    }
    
    public void fusion(Monceau autre) {
        // Ã  complÃ©ter
    	// ajout
    	ArrayList<Node> retenue = new ArrayList<Node>();		// possibilite de garder un arbre temporaire						
		int j = 0;												// on commence par j = 0
		
		/*
		 * ?????
		 */
    }
    
    public void insert(int val) {
        // Ã  complÃ©ter
    	// ajout
    	
    	/*
    	 inserer une valeur dans un monceau
    	 	utiliser fusion
    	 */
    	
    	// creation monceau et noeud avec val
    	Monceau unMonceau = new Monceau();
    	Node unNoeud = new Node(val);
    	
    	// ajout de ce noeud avec la val dans le monceau
    	unMonceau.arbres.add(unNoeud);
    	fusion(unMonceau);
    	
    }
    
    public boolean delete (int val) {
        // Ã  complÃ©ter
    	// ajout incertain
    	
    	/*
    	 À l’aide des fonctions 
    	 	Node.findValue
    	 	Node.delete
    	 supprimer tous les noeuds ayant une certaine valeur
    	 appeler plusieurs fois
    	 	Node.findValue
    	 */
    	boolean estEffacer = false;
    	for(Node noeud: arbres) {
            Node unNoeud = noeud.findValue(val);
            if(unNoeud != null) {
                noeud.delete();
                estEffacer = true;
            }
        }
        return estEffacer;
    }
    
    public void print() {
        // Ã  complÃ©ter
    	// ajout
    	
    	/*
    	 afficher monceau
    	 ordre de chaque arbre doit apparaitre
    	 */

    	for (Node arbre : arbres){
    		System.out.println("Ordre: " + arbre.ordre);
          	arbre.print("");
    	}
    }
    
}
