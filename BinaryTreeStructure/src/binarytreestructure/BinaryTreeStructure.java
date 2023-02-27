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
        BinaryTree<Integer, String> testTree = new BinaryTree(0, "Luigi");
        testTree.add(2, "Salcedo");
        testTree.add(-1, "César");
        testTree.add(4, "Espriella");
        testTree.add(3, "Test");
        testTree.add(1, "Test2");
        
        testTree.remove(2);
        
        String gE = testTree.get(2); 
        
        System.out.println(gE);
        System.out.println(testTree);
        System.out.println(testTree.size());
        
    }   
}
