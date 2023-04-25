import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author maitr
 */
public class Node {

    public int ordre;
    public Node parent;

    private int valeur;
    private ArrayList<Node> enfants;

    public Node(int valeur) {
        this.valeur = valeur;
        ordre = 0;
        this.parent = null;
        enfants = new ArrayList<Node>();
    }

    public Node(int valeur, Node parent) {
        ordre = 0;
        this.valeur = valeur;
        this.parent = parent;
        enfants = new ArrayList<Node>();
    }

    public int getVal() {
        return valeur;
    }

    public ArrayList<Node> getEnfants() {
        return enfants;
    }

    public void addEnfant(Node enfant) {
        enfants.add(enfant);
    }

    public boolean removeEnfant(Node enfant) {
        if (enfants.contains(enfant)) {
            enfants.remove(enfant);
            return true;
        }
        return false;
    }

    public void removeEnfants(ArrayList<Node> enfants) {
        this.enfants.removeAll(enfants);
    }

    public Node fusion(Node autre) throws DifferentOrderTrees {

        // Ã  complÃ©ter
    	// ajout complet
    	
    	/*
    	vérifier que les arbres sont de même ordre 
		et que les noeuds sont bien des racines
    	 */
    	if((ordre == autre.ordre) && (autre != null)) {
    		/*
    		respecter la condition d’ordre du monceau
			valeur du parent < valeur des enfants	
    		 */
    		if (valeur < autre.valeur) {	// valeur du parent < valeur des enfants
    			
    			autre.parent = this;
    			enfants.add(autre);
    			ordre++;
    			return this;
    		}
    		else {							// valeur du parent > valeur des enfants
    			parent = autre;
    			autre.enfants.add(this);
    			autre.ordre++;
    			return parent;
    		}	
    	}
    	else
    		throw new DifferentOrderTrees();
        // return null;
    }

    private void moveUp() {
        // Ã  complÃ©ter
    	// ajout
    	
    	/*
    	Dans l'arbre, echange la position du noeud et de son parent
		Attention, ceci brise la condition d'ordre du monceau:
		il ne faut utiliser cette fonction que dans delete
		Pensez aussi a modifier la valeur d'ordre de tous les noeuds
		dont vont avez change la position
    	 */
    	
    	Node gParent = this.parent.parent;						// on recupere le grand-parent de ce noeud
    	Node parent = this.parent;								// on recupere le parent de ce noeud
    	ArrayList<Node> pEnfants = this.parent.getEnfants();	// on recupere les enfants du parent de ce noeud (elle inclue ce noeud)
    	pEnfants.remove(this);									// parmi ses enfants, on enleve ce noeud (elle sera echanger)
    	ArrayList<Node> enfants = this.getEnfants();			// on recupere les enfants de ce noeud (elle exclue se noeud)
    	
    	if (gParent != null) {									// si le grand-parent n'est pas vide
    		gParent.removeEnfant(parent);						// on enleve son fils (le parent)
    		gParent.addEnfant(this);							// on ajoute le fils du parent (ce noeud) (echange)
        }
    	
    	this.parent = gParent;									// le parent de ce noeud devient le grand-parent du parent (puisqu'il monte)
    	this.enfants = pEnfants;								// les enfants de ce noeud devienne les enfants du parent (puisqu'il descend)
        this.addEnfant(parent);									// on ajoute le parent du fils (parent de ce noeud) (echange)
        this.ordre--;											// puisqu'elle monte, son ordre diminue
        
        parent.enfants = enfants; 								// les enfants du parent (celui qui a descendu) devienne les enfants de ce noeud (celui qui a monte)
        parent.parent = this;									// le parent du parent (celui qui a descendu) devient ce noeud (celui qui a monte)
        parent.ordre++;											// puisqu'il descend son ordre augmente
        
        for(Node enfant: pEnfants)								// changement du parent des enfants (du parent)
    		enfant.parent = this;								// le parent des enfants (du parent) sont devenu ce noeud (celui qui a monte)
    	for(Node enfant: enfants)								// changement du parent des enfants (de ce noeud)
    		enfant.parent = parent;								// le parent des enfants (de ce noeud) sont devenu l'ancien parent (celui qui a descendu)
    }

    public ArrayList<Node> delete() {
        // Ã  complÃ©ter
    	// ajout
    	
    	while (this.parent != null)		// remonter le noeud jusqu'a ce qu'il soit racine ( des que son parent est null)
    		this.moveUp();				// remonte grace a moveUp
        for (Node enfant : enfants)		// des qu'on est a la racine
            enfant.parent = null;		// chacun le parent des enfants de la racine devienne null
        
        return enfants;					// on retourne ses k-1 enfants, chacun etant un arbre binomial
        //return null;
    }

    public void print(String tabulation) {
        // Ã  complÃ©ter
    	// ajout
    	
    	System.out.print(tabulation + this.valeur);
    	if(parent == null && enfants.size() == 0)
    		System.out.println();
    	for(int i = 0; i < enfants.size(); i++) {
    		if(i == 0) {
    			enfants.get(i).print("\t");
    			System.out.println();
    		}
    		else
    			enfants.get(i).print(tabulation+"\t");
    	}
    }
    
    public Node findValue(int valeur) {
        // Ã  complÃ©ter
    	// ajout
    	if (this.valeur == valeur)						// si c'est le tout premier
    		return this;
		if(this.valeur < valeur) {						// si la valeur du noeud est plus petit que la valeur demander
			for (Node i: enfants) {        		
				 Node unNoeud = i.findValue(valeur);
					 if(unNoeud != null)
						 return unNoeud;
	        }
		}
        return null;
    }
    
    public ArrayList<Integer> getElementsSorted() {
    	// Ã  complÃ©ter
    	// ajout incertain
    	
    	ArrayList<Integer> tableau =new ArrayList<>();
        tableau.add(this.valeur);
        for(int i=0; i<enfants.size();i++)
            tableau.add(enfants.get(i).valeur);
    	return tableau;
    	
    }
}
