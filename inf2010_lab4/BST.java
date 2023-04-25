import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.Comparable;
import java.lang.Math;

public class BST<T extends Comparable<T>>
{
    protected class Node<T>
    {
        T val; // Valeur du noeud
        Node<T> right; // fils droite
        Node<T> left; // fils gauche

        public Node(T val)
        {
            this.val = val;
        }
    }

    protected Node<T> root = null; // Racine de l'arbre

    public boolean isValid() { return isValid(root); }

    private boolean isValid(Node<T> node)
    {
        if (node == null) {
            return true;
        }
        boolean isLeftValid = node.left == null || node.left.val.compareTo(node.val) < 0 && isValid(node.left);
        boolean isRightValid = node.right == null || node.right.val.compareTo(node.val) > 0 && isValid(node.right);
        return isLeftValid && isRightValid;
    }

    public int getHeight() { return root == null ? 0 : getHeight(root); }

    protected int getHeight(Node<T> node)
    {
        // À compléter
    	// ajout
    	int hauteur;
    	// rien
    	if(node == null) {
    		hauteur = -1;
    		return hauteur;
    	}
    	hauteur = Math.max(getHeight(node.left), getHeight(node.right));
        return hauteur + 1;
    }

	public void insert(T elem) { root = insert(root, elem); }

	private Node<T> insert(Node<T> node, T elem)
    {
		// À compléter
		// ajout
		// une feuille
		if (node == null) {
			return new Node<T>(elem);
		}
		// a gauche
		if(elem.compareTo(node.val) < 0) {
			node.left = insert(node.left, elem);
			return node;
		}
		// a droite
		else {
			node.right = insert(node.right, elem);
			return node;
		}
	}

    public boolean contains(T elem) { return contains(root, elem); }

    private boolean contains(Node<T> node, T elem)
    {
        // À compléter
    	// ajout
    	boolean estContenu = true;
    	
    	// rien
    	if (node == null) {
    		estContenu = false;
    		return estContenu;
    	}
    	// contenu a gauche
    	if (elem.compareTo(node.val) < 0) {
    		estContenu = contains(node.left, elem);
    	}
    	// contenu a droite
    	else if (elem.compareTo(node.val) > 0){
    		estContenu = contains(node.right, elem);
    	}
    	return estContenu;
    }

    public ArrayList<T> traversePreOrder()
	{
		ArrayList<T> list = new ArrayList<T>();
		traversePreOrder(root, list);
		return list;
	}

	private void traversePreOrder(Node<T> node, ArrayList<T> list)
	{
        // À compléter
		// ajout
		// Parcours pr�-ordre (parent, fils gauche, fils droite).
		if(node != null) {
            list.add(node.val); 				// parent
            traversePreOrder(node.left, list);	// gauche
            traversePreOrder(node.right, list);	// droite
        }
	}

    public ArrayList<T> traversePostOrder()
	{
		ArrayList<T> list = new ArrayList<T>();
		traversePostOrder(root, list);
		return list;
	}

	private void traversePostOrder(Node<T> node, ArrayList<T> list)
	{
        // À compléter
		// ajout
		// Parcours post-ordre (fils gauche, fils droite, parent).
		if(node != null) {
            traversePostOrder(node.left, list);		// gauche
            traversePostOrder(node.right, list);	// droite
            list.add(node.val);						// parent
        }
	}

    public ArrayList<T> traverseInOrder()
    {
        ArrayList<T> list = new ArrayList<T>();
        traverseInOrder(root, list);
        return list;
    }

    private void traverseInOrder(Node<T> node, ArrayList<T> list)
    {
        // À compléter
    	// ajout
    	// Parcours en ordre ou ascendant (fils gauche, parent, fils droite).
    	if(node != null) {
    		traverseInOrder(node.left, list);		// gauche
    		list.add(node.val);						// parent
    		traverseInOrder(node.right, list);		// droite
        }
    }

    public ArrayList<T> traverseReverseOrder()
    {
        ArrayList<T> list = new ArrayList<T>();
        traverseReverseOrder(root, list);
        return list;
    }

    private void traverseReverseOrder(Node<T> node, ArrayList<T> list)
    {
        // À compléter
    	// ajout
    	// Parcours en ordre inverse ou descendant (fils droite, parent, fils gauche).
    	if(node != null) {
    		traverseReverseOrder(node.right, list);		// droite
    		list.add(node.val);							// parent
    		traverseReverseOrder(node.left, list);		// gauche
        }
    }

    public ArrayList<T> traverseLevelOrder()
	{
		ArrayList<T> list = new ArrayList<T>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // À compléter
        	// ajout
        	// Parcours par niveau
        	Node<T> noeud = queue.remove();
        	
            if (noeud != null) {
                list.add(noeud.val);

                if (noeud.left != null) {
                    queue.add(noeud.left);
                }
                if (noeud.right != null) {
                    queue.add(noeud.right);
                }
            }
        }

		return list;
	}
}

