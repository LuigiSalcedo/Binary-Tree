package binarytreestructure.structures;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Luigi Salcedo
 * @param <K> Key
 * @param <V> Value
 */
public class BinaryTree<K, V> 
{
    // ATRIBUTOS
    private BinaryTreeElement<K, V> root;
    private int size;
    
    // CONSTRUCTOR
    public BinaryTree(K rootKey, V rootValue)
    {
        this.root = new BinaryTreeElement(rootKey, rootValue);
        this.root.setLevel(0);
        size = 1;
    }
    
    // MÉTODOS PUBLICOS
    public BinaryTreeElement<K, V> getMaxValueElementFrom(BinaryTreeElement<K, V> element)
    {
        BinaryTreeElement<K, V> maxValueElement = element;
        
        while(maxValueElement.getRigth() != null)
        {
            maxValueElement = maxValueElement.getRigth();
        }
        
        return maxValueElement;
    }
    
    public BinaryTreeElement<K, V> getMinValueElementFrom(BinaryTreeElement<K, V> element)
    {
        BinaryTreeElement<K, V> minValueElement = element;
        
        while(minValueElement.getLeft() != null)
        {
            minValueElement = minValueElement.getLeft();
        }
        
        return minValueElement;
    }
    
    public int size()
    {
        return size;
    }
    
    public BinaryTreeElement<K, V> getRoot()
    {
        return root;
    }
    
    public void add(K key, V value)
    {
        BinaryTreeElement<K, V> newElement = new BinaryTreeElement(key, value);
        
        BinaryTreeElement<K, V> piv = root;
        
        while(!piv.add(newElement))
        {
            piv = piv.getBetterOption(newElement);
        }
        
        size++;
    }
    
    public V get(K key)
    {
        BinaryTreeElement<K, V> element = searchElement(key);
        return element != null ? element.getValue() : null;
    }
    
    public boolean containsKey(K key)
    {
        return get(key) != null;
    }
    
    public void remove(K key)
    {
        BinaryTreeElement<K, V> piv = searchElement(key);
        BinaryTreeElement<K, V> fPiv = searchFatherElement(key);
        
        if(key == null || piv == null) return;
        
        int side = fPiv.getLeft() == piv ? 0 : 1;
        
        if(piv.isLeaf())
        {
            fPiv.instantCut(piv);
            return;
        }
        
        BinaryTreeElement<K, V> replacementElement 
                = piv.getLeft() != null ? getMaxValueElementFrom(piv.getLeft()) : getMinValueElementFrom(piv.getRigth());
        
        if(side == 0)
        {
            fPiv.setLeft(replacementElement);
        }
        else
        {
            fPiv.setRigth(replacementElement);
        }
        
        size--;
    }
    
    // MÉTODOS PRIVADOS
    private BinaryTreeElement<K, V> searchElement(K key)
    {
        BinaryTreeElement<K, V> element = new BinaryTreeElement(key, null);
        BinaryTreeElement<K, V> piv = root;
        
        while(piv != null)
        {
            if(piv.getKey().equals(key))
            {
                return piv;
            }

            if(element.compareTo(piv) < 0) piv = piv.getLeft();
            else piv = piv.getRigth();
        }
        
        return null;        
    }
    
    private BinaryTreeElement<K, V> searchFatherElement(K key)
    {
        BinaryTreeElement<K, V> piv = root;
        BinaryTreeElement<K, V> element = new BinaryTreeElement(key, null);
        
        while(piv != null)
        {
            if(piv.getLeft().getKey().equals(key) || piv.getRigth().getKey().equals(key))
            {
                return piv;
            }
            
            piv = piv.getBetterOption(element);
        }
        return null;
    }
    
    // SOBREMONTURA DE MÉTODOS
    @Override
    public String toString()
    {
        Queue<BinaryTreeElement<K, V>> queue = new LinkedList<>();
        BinaryTreeElement<K, V> piv;
        
        int actualLvl = 0;
        
        queue.offer(root);
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("Root: ");
        
        while(!queue.isEmpty())
        {
            piv = queue.poll();
            
            if(piv.getLeft() != null)
            {
                piv.getLeft().setLevel(actualLvl + 1);
                queue.offer(piv.getLeft());
            }
            if(piv.getRigth() != null) 
            {
                piv.getRigth().setLevel(actualLvl + 1);
                queue.offer(piv.getRigth());
            }
            if(piv.getLevel() > actualLvl)
            {
                actualLvl++;
                sb.append("\nLevel: ").append(actualLvl).append("\n");
            }
            sb.append(piv.toString()).append("\n");
        }
        
        return sb.toString();
    }
}
