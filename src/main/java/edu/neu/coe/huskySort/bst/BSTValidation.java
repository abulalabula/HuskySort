package edu.neu.coe.huskySort.bst;

import java.util.*;

public class BSTValidation {
    static ArrayList<String> allNodes = new ArrayList<>();
    static BSTOriginal<String, Integer> bst = new BSTOriginal<>();
    static Random random = new Random();

    public static void BSTHeight(int nodesNumber, int numberOfDeletion, int runningTimes, String deleteType){
        int cumulativeTreeHeight = 0;
        for (int r = 0; r < runningTimes; r++) {
            cumulativeTreeHeight += bst.height();
        }
        System.out.println("Delete Type: " + deleteType);
        System.out.println("Number of node deletion: " + numberOfDeletion);
        System.out.println("Run times: " + runningTimes);
        System.out.println("Number of tree nodes(N): " + nodesNumber);
        System.out.println("Square root of N: " + Math.sqrt(nodesNumber));
        System.out.println("Average tree height: " + cumulativeTreeHeight / nodesNumber);
    }

    public static void construct(int nodesNumber, int maxDigit){
        // Randomly add nodes
        while (bst.size() < nodesNumber){
            int randInteger = random.nextInt(10000000);
            String randString = String.format("%0"+ maxDigit +"d", randInteger);
            bst.put(randString, randInteger);
            // keep node array uniqueness
            if (!allNodes.contains(randString)){
                allNodes.add(randString);
            }
        }
    }
    public static void deleteNodes(int numberOfDeletion, int maxDigit, String deleteType){
        // Delete from existing nodes
        for (int i = 0; i < numberOfDeletion; i++) {
            if (allNodes.size() <= 0) break;
            int randDelete = random.nextInt(allNodes.size());
            String randString = allNodes.get(randDelete);
            // type of deletion
            if (deleteType == "random"){
                int direction = random.nextInt(2);
                if(direction == 0){
                    bst.delete(randString);
                } else bst.deleteLeft(randString);
            } else if (deleteType == "size"){
                int leftSize = ((bst.root.left == null) ? 0 : bst.root.left.size);
                int rightSize = ((bst.root.right == null) ? 0 : bst.root.right.size);
                if(leftSize > rightSize) bst.deleteLeft(randString);
                else if (leftSize < rightSize) bst.delete(randString);
                else {
                    int direction = random.nextInt(2);
                    if(direction == 0){
                        bst.delete(randString);
                    } else bst.deleteLeft(randString);
                }
            } else {
                bst.delete(randString);
            }

            // Check deletion in node array
            if(allNodes.contains(randString)){
                allNodes.remove(randString);

                // Add a random node back
                int randSupplement = random.nextInt(10000000);
                String randSupplementString = String.format("%0"+ maxDigit +"d", randSupplement);
                while(allNodes.contains(randSupplementString)){
                    randSupplement = random.nextInt(10000000);
                    randSupplementString = String.format("%0"+ maxDigit +"d", randSupplement);
                }
                bst.put(randSupplementString, randSupplement);
                allNodes.add(randSupplementString);

            } else continue;
        }
    }
    public BSTValidation() {
    }

    public static void main(String[] args) {
        for (int i = 25; i <= 6400; i*=2) {
            construct(i, 8);
            deleteNodes(i/6, 8, "default");
            BSTHeight(i, i/6, 1000, "default");
            System.out.println("---------------------------------");
        }
    }
}
