package com.algorithms.problems.salesforce;

/**
 *
 *
 *
 * With given Binary Tree below, traverse the tree and print the tree from bottom up order
 1
 / \
 2 3
 /\ /\
 4 5 6 7

 output: 4567231

 Hint: the traverse is called "Level Order Tree Traversal"

 I hope someone memorize this traversal and pass the exam and all these companies judging candidates with one
 algorithm could think they hired the best canditate.


 *
 *
 */
public class LevelOrderTreeTravelsal {

    /*

    public void void printTreeLevelFromBottom(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<Integer> printTreeList = new ArrayList<>();
        printTreeList.add(root.data);
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            Node leftNode = node.left;
            Node rightNode = node.right;

            if (rightNode != null) {
                printTreeList.add(rightNode.data);
                queue.add(rightNode);
            }

            if (leftNode != null) {
                printTreeList.add(leftNode.data);
                queue.add(leftNode);
            }
        }

        for (int index = printTreeList.size() - 1; index >= 0; index--) {
            System.out.print(printTreeList.get(index) + " ");
        }
    }

    */

}
