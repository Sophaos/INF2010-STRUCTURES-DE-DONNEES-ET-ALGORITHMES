public class DoublyLinkedList<AnyType>
{
    // Un noeud de la liste.
    @SuppressWarnings("hiding")
    private class Node<AnyType>
    {
        private AnyType value;
        private Node prev;
        private Node next;

        public Node(AnyType value, Node prev, Node next)
        {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public void setPrev(Node prev) { this.prev = prev; }

        public Node<AnyType> getPrev() { return this.prev; }

        public void setNext(Node next)
        {
            this.next = next;
        }

        public Node<AnyType> getNext()
        {
            return next;
        }

        public AnyType getValue()
        {
            return value;
        }
    }

    private int size = 0;		 // Nombre d'éléments dans la liste.
    private Node<AnyType> front; // Premier élément de la liste.
    private Node<AnyType> back;  // Dernier élément de la liste.

    // Indique si la liste est vide.
    public boolean empty()
    {
        return size == 0;
    }

    // Retourne la taille de la liste.
    public int size()
    {
        return size;
    }

    // Retourne l'élément à la fin de la liste.
    // Retourne null si la liste est vide.
    // Complexité asymptotique: O(1)
    public AnyType peekBack()
    {
        // À compléter
    	//// ajout
    	
    	// Si elle est vide, on retourne null
    	if(this.empty()) {
    		return null;
    	}
    	// sinon on retourne la valeur du dernier element de la liste
    	return this.back.getValue();
    }

    // Retourne l'élément au début de la liste.
    // Retourne null si la liste est vide.
    // Complexité asymptotique: O(1)
    public AnyType peekFront()
    {
        // À compléter
    	//// ajout
    	
    	// si elle est vide, on retourne null
    	if(this.empty()) {
    		return null;
    	}
    	// sinon on retourne la valeur du premier element de la liste
    	return this.front.getValue();
    }

    // Retourne le noeud à l'indice donné.
    // Complexité asymptotique: O(n)
    private Node<AnyType> getNodeAt(int index)
    {
        // À compléter
    	//// ajout
    	
    	// on commence du derriere
    	Node<AnyType> noeudVoulu = this.front;
    	
    	// pour chaque element jusqu'a l'index
    	for (int i = 0; i < index; i++) {
    		
    		// le noeud prend le suivant
    		noeudVoulu = noeudVoulu.getNext();
    	}
    	
    	// elle retourne le noeud a l'indice
    	return noeudVoulu;
    }

    // Retourne l'élément à l'indice donné.
    // Complexité asymptotique: O(n)
    public AnyType getAt(int index) throws IndexOutOfBoundsException
    {
        // À compléter
    	////ajout
    	
    	// si l'index sort de la liste
    	if(index < 0 || index >= this.size())
            throw new IndexOutOfBoundsException();
    	
    	// on retourne la valeur du noeud correspondant a l'index
        return this.getNodeAt(index).getValue();
    }

    // Retire l'élément à la fin de la liste.
    // Complexité asymptotique: O(1)
    public void popBack() throws EmptyListException
    {
        // À compléter
    	//// ajout
    	
    	// si la liste est vide
    	if(empty())
            throw new EmptyListException();
    	
    	// back est l'element avant
    	
    	this.back = this.back.getPrev();    //back devient l'element precedent.
    	
    	
    	// la liste diminue de 1
        this.size--;
    	
    }

    // Retire l'élément au début de la liste.
    // Complexité asymptotique: O(1)
    public void popFront() throws EmptyListException
    {
        // À compléter
    	//// ajout
    	
    	// si la liste est vide
    	if(empty())
            throw new EmptyListException();
	
    	// front est l'element apres
    	this.front = this.front.getNext(); 
    	
    	// la liste diminue de 1
        this.size--;
    }

    // Retire l'élément à l'indice donné.
    // Complexité asymptotique: O(n)
    public void removeAt(int index) throws IndexOutOfBoundsException
    {
        // À compléter
    	//// ajout
    	
    	
    	// si l'index sort de la liste
    	if(index < 0 || index >= this.size())
            throw new IndexOutOfBoundsException();
    	
    	
    	this.getNodeAt(index).getPrev().next = this.getNodeAt(index).next;
    	this.getNodeAt(index).getNext().prev = this.getNodeAt(index).prev;

        this.size--;
    }

    // Ajoute un élément à la fin de la liste.
    // Complexité asymptotique: O(1)
    public void pushBack(AnyType item)
    {
        // À compléter
    	//// ajout
    	
    	Node<AnyType> element = new Node<AnyType>(item, this.back, null);
    	
        this.back = element;

        if(!empty())
            this.back.getPrev().setNext(this.back);
        else
            this.front = element;       
        
        size++;
    }

    // Ajoute un élément au début de la liste.
    // Complexité asymptotique: O(1)
    public void pushFront(AnyType item)
    {
        // À compléter
    	//// ajout
    	Node<AnyType> element = new Node<AnyType>(item, null, this.front);

        this.front = element;

        if(!empty())
            this.front.getNext().setPrev(this.front);
        else
            this.back = element;        

        this.size++;
    }

    // Ajoute un élément à l'indice donné.
    // Complexité asymtotique: O(n)
    public void insertAt(AnyType item, int index) throws IndexOutOfBoundsException
    {
        // À compléter
    	//// ajout
    	
    	// si l'index sort de la liste
    	if(index < 0 || index >= this.size())
            throw new IndexOutOfBoundsException();
    	// si debut
        if(index == 0)
            pushFront(item);  
        //si fin
        else if(index == this.size())
            pushBack(item);  
        // autrement
        else {                              
            Node<AnyType> noeud = getNodeAt(index);
            Node<AnyType> nouveauNoeud = new Node<AnyType>(item, noeud.prev, noeud);
            nouveauNoeud.getNext().setPrev(nouveauNoeud);
            nouveauNoeud.getPrev().setNext(nouveauNoeud);
            size++;
        }
    }
}