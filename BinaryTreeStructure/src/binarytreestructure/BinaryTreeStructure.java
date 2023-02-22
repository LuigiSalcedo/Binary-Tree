package binarytreestructure;

import binarytreestructure.structures.BinaryTree;

/**
 *
 * @author Luigi Salcedo
 */
public class BinaryTreeStructure 
{
    public static void main(String[] args) 
    {
        BinaryTree<Integer, String> testTree = new BinaryTree(1, "Luigi");
        
        System.out.println(testTree);
    }   
}
