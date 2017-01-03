package com.algorithms.solutiontree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * All possible character strings which can be give as
 * input: "1234" --> output: "abcd", "lcd", "awd"
 * input: "35241235" --> output:
 * "cebdabce", "cebdawe", "cebdlce","cexabce","cexawe","cexlce"
 * @author psaundade
 *
 */

class SolutionTree {

    static final HashMap<Integer, String> map = new HashMap<Integer, String>();
    static{
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(4,"d");
        map.put(5,"e");
        map.put(6,"f");
        map.put(7,"g");
        map.put(8,"h");
        map.put(9,"i");
        map.put(10,"j");
        map.put(11,"k");
        map.put(12,"l");
        map.put(13,"m");
        map.put(14,"n");
        map.put(15,"o");
        map.put(16,"p");
        map.put(17,"q");
        map.put(18,"r");
        map.put(19,"s");
        map.put(20,"t");
        map.put(21,"u");
        map.put(22,"v");
        map.put(23,"w");
        map.put(24,"x");
        map.put(25,"y");
        map.put(26,"z");

        //...till z
    }

    private Node root;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String input = "35241235";
        SolutionTree tree = new SolutionTree(input);
        List<String> list = new ArrayList<String>();
        SolutionTree.traverseTree(tree.root, list);
    }

    public SolutionTree(String input){
        root = new Node();
        addNodes(root, input);
    }

    public static String getFirstNChars(String str, int numOfDigits){
        if(null == str || str.isEmpty() || str.length()<numOfDigits){
            return "";
        }
        return str.substring(0, (numOfDigits));
    }

    public static void addNodes(Node parent, String str){
        if(null == str || str.isEmpty() || str.length()<1){
            return;
        }
        String oneDigit = getFirstNChars(str, 1);
        if(oneDigit.isEmpty()){
            return;
        }
        parent.left = new Node();
        parent.left.value = oneDigit;
        addNodes(parent.left, str.substring(1));

        String twoDigits = getFirstNChars(str, 2);
        if(twoDigits.isEmpty() || 26<Integer.parseInt(twoDigits)){
            return;
        }else{
            parent.right = new Node();
            parent.right.value = twoDigits;
            addNodes(parent.right, str.substring(2));
        }
    }

    public static void traverseTree(Node node, List<String> list){
        if(null == node){
            return;
        }
        if(null != node.value){
            list.add(node.value);
        }

        if(null == node.left && null == node.right){
            //reached leaf node, path completed from root to leaf
            //showPath(list); // this can be printed or saved in another arraylist
            System.out.println("Possible Path: " + showPath(list));
        }
        traverseTree(node.left, new ArrayList<String>(list));//If changes made to list is passed down, it will duplicate some portion of path
        traverseTree(node.right, new ArrayList<String>(list));// Hence it should be new list

    }

    public static String showPath(List<String> list){
        String path = "";
        for(String str: list){
            //System.out.println("map: " + str);
            path = path + map.get(Integer.parseInt(str));
        }

        return path;
    }

    public static class Node{
        Node right;
        Node left;
        String value;

    }

}