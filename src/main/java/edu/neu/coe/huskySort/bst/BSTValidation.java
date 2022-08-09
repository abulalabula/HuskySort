package edu.neu.coe.huskySort.bst;

import java.util.*;

public class BSTValidation {


    public static void BSTHeight(int count, int numberOfDeletion, int runningTimes, String deleteType, int maxDigit){

        Random random = new Random();
        for (int r = 0; r < runningTimes; r++) {
            ArrayList<String> allNodes = new ArrayList<>();
            BSTOriginal<String, Integer> bst = new BSTOriginal<>();
            // Add nodes
            while (bst.size() < count){
                int randInteger = random.nextInt(count);
                String randString = String.format("%0"+ maxDigit +"d", randInteger);
                bst.put(randString, randInteger);
                // keep node array uniqueness
                if (!allNodes.contains(randString)){
                    allNodes.add(randString);
                }
            }
            // Delete nodes
            for (int i = 0; i < numberOfDeletion; i++) {
                if (allNodes.size() <= 0) break;
                int randDelete = random.nextInt(count) ;
                String randString = String.format("%0"+ maxDigit +"d", randDelete);
                // type of deletion
                if (deleteType == "random"){
                    int direction = random.nextInt(2);
                    if(direction == 0){
                        bst.delete(randString);
                    } else bst.deleteLeft(randString);
                } else if (deleteType == "size"){

                    int leftSize = 0;
                    int rightSize = 0;
                    leftSize = ((bst.root.left == null) ? 0 : bst.root.left.size);
                    rightSize = ((bst.root.right == null) ? 0 : bst.root.right.size);

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

                // Check deletion
                if(allNodes.contains(randString)){
                    allNodes.remove(randString);

                    // Add a node back
                    int randSupplement = random.nextInt(count);
                    String randSupplementString = String.format("%0"+ maxDigit +"d", randSupplement);
                    while(allNodes.contains(randSupplementString)){
                        randSupplement = random.nextInt(count);
                        randSupplementString = String.format("%0"+ maxDigit +"d", randSupplement);
                    }
                    bst.put(randSupplementString, randSupplement);
                    allNodes.add(randSupplementString);

                } else continue;
            }
            System.out.println(deleteType + "," + bst.size() + "," + Math.sqrt(bst.size()) + "," + bst.height());
        }
    }

    private static void construct(int nodesNumber, int maxDigit){}
    private static void hibbardDelete(int nodesNumber, int numberOfDeletion, int maxDigit, String deleteType){}

    public static void main(String[] args) {

        for (int i = 25; i <= 6400; i*=2) {
            System.out.println("");
            System.out.println("i: " + i);
            BSTHeight(i, i/2, 20, "random", 4);
        }
    }
}
