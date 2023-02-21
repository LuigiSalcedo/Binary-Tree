package binarytreestructure.structures;

/**
 *
 * @author Luigi Salcedo
 */
public class BinaryTree<K, V> 
{
    private BinaryTreeElement<K, V> root;
    int size;
    
    public BinaryTree(K rootKey, V rootValue)
    {
        this.root = new BinaryTreeElement(rootKey, rootValue);
        size = 0;
    }
    
    public void add(K key, V value)
    {
        BinaryTreeElement<K, V> newElement = new BinaryTreeElement(key, value);
        
        BinaryTreeElement<K, V> piv = root;
        
        while(!piv.add(newElement))
        {
            piv = piv.getBetterOption(newElement);
        }
    }
}
