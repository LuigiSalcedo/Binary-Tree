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
    // ATRIBUTOS
    private K key;
    private V value;
    private BinaryTreeElement left;
    private BinaryTreeElement rigth;
    private int level;
    
    // CONSTRUCTORES
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
    
    // SETTERS
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
    
    // GETTERS
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
    
    // MÉTODOS PACKAGE
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
    
    BinaryTreeElement<K, V> getBetterOption(BinaryTreeElement<K, V> element)
    {
        return element.compareTo(this) < 0 ? left : rigth; 
    }
    
    void instantCut(BinaryTreeElement<K, V> element)
    {
        if(left == element) left = null;
        if(rigth == element) rigth = null;
    }
    
    // SOBREMONTURA DE MÉTODOS
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
        return Objects.equals(this.key, other.key);
    }
    
    @Override
    public int compareTo(BinaryTreeElement<K, V> element)
    {
        return this.hashCode() - element.hashCode();
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        // Agregamos información del nodo izquierdo.
        if(left != null)
        {
            sb.append("(").append(left.key).append(", ").append(left.value).append(") -> ");
        }
        
        // Agregamos la información del nodo actual.
        sb.append("(").append(this.key).append(", ").append(this.value).append(")");
        
        // Agregamos la información del nodo derecho.
        if(rigth != null)
        {
            sb.append(" <- (").append(rigth.key).append(", ").append(rigth.value).append(")");
        }
        
        return sb.toString();
    }
}
