package binarytreestructure.structures;

import java.util.Objects;

/**
 *
 * @author Luigi Salcedo
 * @param <K> Key
 * @param <V> Value
 */
public class BinaryTreeElement<K, V> implements Comparable<BinaryTreeElement<K, V>>
{
    // Atributos
    private K key;
    private V value;
    private BinaryTreeElement left;
    private BinaryTreeElement rigth;
    private int level;
    
    // Constructores
    public BinaryTreeElement(K key, V value)
    {
        this.key = key;
        this.value = value;
        left = null;
        rigth = null;
    }
    
    public BinaryTreeElement(K key, V value, BinaryTreeElement<K, V> left, BinaryTreeElement<K, V> rigth)
    {
        this.value = value;
        this.key = key;
        this.left = left;
        this.rigth = rigth;
    }
    
    // Setters
    public void setValue(V value)
    {
        this.value = value;
    }
        
    void setLeft(BinaryTreeElement<K, V> left)
    {
        this.left = left;
    }
    
    void setRigth(BinaryTreeElement<K, V> rigth)
    {
        this.rigth = rigth;
    }
    
    void setLevel(int level)
    {
        this.level = level;
    }
    
    // Getters
    public V getValue() 
    {
        return value;
    }
    
    public K getKey()
    {
        return key;
    }
    
    public BinaryTreeElement getRigth() 
    {
        return rigth;
    }

    public BinaryTreeElement getLeft() 
    {
        return left;
    }
    
    public boolean isLeaf()
    {
        return rigth == null && left == null;
    }
    
    public int getLevel()
    {
        return level;
    }
    
    // Métodos
    boolean add(BinaryTreeElement<K, V> element)
    {
        if(element.compareTo(this) < 0)
        {
            if(left != null) return false;
            left = element;
        }
        else
        {
            if(rigth != null) return false;
            rigth = element;
        }
        
        return true;
    }
    
    public BinaryTreeElement<K, V> getBetterOption(BinaryTreeElement<K, V> element)
    {
        return element.compareTo(this) < 0 ? left : rigth; 
    }
    
    void instantCut(BinaryTreeElement<K, V> element)
    {
        if(left == element) left = null;
        if(rigth == element) rigth = null;
    }
    
    @Override
    public int hashCode()
    {
        return key.hashCode();
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BinaryTreeElement<K, V> other = (BinaryTreeElement<K, V>) obj;
        return Objects.equals(this.value, other.value);
    }
    
    @Override
    public int compareTo(BinaryTreeElement<K, V> element)
    {
        return this.hashCode() - element.hashCode();
    }
    
    @Override
    public String toString()
    {
        return "K: " + key.toString() + " - V: " + value.toString();
    }
}
