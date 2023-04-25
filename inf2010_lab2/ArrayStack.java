import java.util.EmptyStackException;

public class ArrayStack<AnyType>
{
    private static final int INITIAL_SIZE = 10;
    private static final int DEFAULT_RESIZE_FACTOR = 2;

    private int size = 0; // Nombre d'éléments dans la pile.
    private AnyType[] table;

    // Initialisation de la pile.
    public ArrayStack()
    {
        // À compléter
    	////****
    	table = (AnyType[]) new Object[INITIAL_SIZE];
    	
    }

    // Enlève l'élément au sommet de la pile et le renvoie.
    // Complexité asymptotique: O(1)
    public AnyType pop() throws EmptyStackException
    {
        // À compléter
    	//// ajout
    	
    	// si la pile est vide
    	if(this.empty()) {
    		throw new EmptyStackException();
    	}
    	
    	// on recupere l'element au sommet de la pile
    	AnyType sommet = this.table[this.size() -1];
    	
    	// on enleve cette valeur
    	this.table[this.size() - 1] = null;
    	
    	// la pile diminue de 1
    	this.size--;
    	
    	return sommet;
    }

    // Ajoute un élément au sommet de la pile.
    // Augmente la taille de la pile si nécessaire (utiliser la fonction resize définie plus bas).
    // Complexité asymptotique: O(1) (O(N) lorsqu'un redimensionnement est nécessaire)
    public void push(AnyType element)
    {
        // À compléter
    	//// ajout
    	
    	// si la pile est remplie
    	if (this.size() == this.table.length) {
    		// on double la taille de la pile
    		this.resize(DEFAULT_RESIZE_FACTOR);
    	}
    	
    	// on met la valeur au sommet
    	this.table[this.size()] = element;
    	
    	// on augmente la taille de la pile de 1 
    	this.size++;
    }

    // Renvoie l'élément au sommet de la pile sans l'enlever.
    // Retourne null si la pile est vide.
    // Complexité asymptotique: O(1)
    public AnyType peek()
    {
        // À compléter
    	//// ajout
    	
    	if(this.empty()) {
    		return null;
    	}
    	
    	// element au sommet
    	return this.table[this.size()-1];
    }

    // Renvoie le nombre d'éléments dans la pile.
    public int size() { return size; }

    // Indique si la pile est vide.
    public boolean empty() { return size == 0; }

    // Redimensionne la pile. La capacité est multipliée par un facteur de resizeFactor.
    // Complexité asymptotique: O(N)
    @SuppressWarnings("unchecked")
    private void resize(int resizeFactor)
    {
        // À compléter
    	//// ajout

    	// on garde le tableau
    	AnyType[] tab = this.table;   	
    	
    	// on remet le tableau avec une nouvelle capacacite
    	this.table = (AnyType[]) new Comparable[(this.size()*resizeFactor)];
   	
    	// on remet les valeurs qu'on a garde
    	for(int i = 0; i < this.size(); i++) {
    		this.table[i] = tab[i];
    	}
    	
    }
}
