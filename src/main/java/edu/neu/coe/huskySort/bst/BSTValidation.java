package edu.neu.coe.huskySort.bst;

import java.util.*;

public class BSTValidation {


    public static void BSTHeight(int count, int numberOfDeletion, int runningTimes, String deleteType, int maxDigit){

        Random random = new Random();
        int cumulativeTreeHeight = 0;
        for (int r = 0; r < runningTimes; r++) {
            ArrayList<String> allNodes = new ArrayList<>();
            BSTOriginal<String, Integer> bst = new BSTOriginal<>();
            // Randomly add nodes
            while (bst.size() < count){
                int randInteger = random.nextInt(10000000);
                String randString = String.format("%0"+ maxDigit +"d", randInteger);
                bst.put(randString, randInteger);
                // keep node array uniqueness
                if (!allNodes.contains(randString)){
                    allNodes.add(randString);
                }
            }
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
            cumulativeTreeHeight += bst.height();
        }
        System.out.println("Delete Type: " + deleteType);
        System.out.println("Number of node deletion: " + numberOfDeletion);
        System.out.println("Run times: " + runningTimes);
        System.out.println("Number of tree nodes(N): " + count);
        System.out.println("Square root of N: " + Math.sqrt(count));
        System.out.println("Average tree height: " + cumulativeTreeHeight / count);
    }
    public BSTValidation() {

    }
    private static void construct(int nodesNumber, int maxDigit){}
    private static void hibbardDelete(int nodesNumber, int numberOfDeletion, int maxDigit, String deleteType){}

    public static void main(String[] args) {

        for (int i = 400; i <= 400; i*=2) {

            BSTHeight(i, i/6, 1000, "default", 8);
            System.out.println("---------------------------------");
            BSTHeight(i, i/8, 1000, "random", 8);
            System.out.println("---------------------------------");
            BSTHeight(i, i/6, 1000, "size", 8);
            System.out.println("---------------------------------");
            BSTHeight(i, i/2, 1000, "default", 8);
            System.out.println("---------------------------------");
            BSTHeight(i, i/10, 1000, "random", 8);
        }
    }
}
