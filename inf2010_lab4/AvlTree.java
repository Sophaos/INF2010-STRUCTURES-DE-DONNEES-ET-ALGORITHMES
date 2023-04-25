import java.lang.Comparable;

public class AvlTree<T extends Comparable<T>> extends BST<T>
{
    public boolean isBalanced() { return isBalanced(root); }

    private boolean isBalanced(Node<T> node)
    {
        if (node == null) {
            return true;
        }

        boolean childsBalanced = isBalanced(node.left)
                              && isBalanced(node.right);

        int heightDiff = Math.abs(getHeight(node.left) - getHeight(node.right));

        return childsBalanced && heightDiff <= 1;
    }

    public void insert(T elem) { root = insert(root, elem); }

    private Node<T> insert(Node<T> node, T elem) //Commme insert de BST, mais avec des conditions de balancement
    {
    	if(node == null ){
            return new Node<T>(elem);

        }
        if (elem.compareTo(node.val) == 0){
            return null;
        }
        if(elem.compareTo(node.val) < 0 ){
            node.left = insert(node.left,elem);
            if(getHeight(node.left) - getHeight(node.right) == 2){
                if(elem.compareTo(node.left.val) < 0){
                    node = balanceLeftLeft(node); //rotation simple gauche
                }
                else {
                    node = balanceLeftRight(node); //rotation double gauche
                }
            }
        }
        else if(elem.compareTo(node.val) > 0 ){
            node.right = insert(node.right, elem);
            if(getHeight(node.right) - getHeight(node.left) == 2 ){
                if(elem.compareTo(node.right.val) > 0){
                    node = balanceRightRight(node); //rotation simple droite
                }
                else {
                    node = balanceRightLeft(node);  //rotation double droite
                }
            }
        }

        return node;
        // À compléter
    }

    private Node<T> balanceRightRight(Node<T> node)
    {
    	Node<T> nodeTmp = node.right;
        node.right = nodeTmp.left;
        nodeTmp.left = node;

        return nodeTmp;

        // À compléter

    }

    private Node<T> balanceRightLeft(Node<T> node)
    {
    	node.right = balanceLeftLeft(node.right);
        return balanceRightRight(node);
        // À compléter

    }

    private Node<T> balanceLeftLeft(Node<T> node)
    {
    	Node nodeTmp = node.left;
        node.left = nodeTmp.right;
        nodeTmp.right = node;
        return nodeTmp;
        // À compléter

    }

    private Node<T> balanceLeftRight(Node<T> node)
    {
    	node.left = balanceRightRight(node.left);
        return balanceLeftLeft(node);
        // À compléter

    }
}