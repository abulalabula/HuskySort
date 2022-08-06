package edu.neu.coe.huskySort.bst;

import java.util.*;

public class BSTValidation {

    public static void BSTHeight(int count, int numberOfDeletion, int runningTimes){

        Random random = new Random();
        for (int r = 0; r < runningTimes; r++) {

            int totalNodes = 0;
            ArrayList<Integer> allNodes = new ArrayList<>();
            BSTSimple<String, Integer> bst = new BSTSimple<>();

            // Add nodes
            for (int i = 0; i < count; i++) {
                int randInteger = random.nextInt(count) + 1;
                String randString = String.valueOf(randInteger);
//                System.out.println("randString: " + randString + " randInteger: " + randInteger);
                bst.put(randString, randInteger);
                // keep array uniqueness
//                if (!allNodes.contains(randInteger)){
//                    allNodes.add(randInteger);
//                }
                allNodes.add(randInteger);
            }
            totalNodes = allNodes.size();

            // Delete nodes
            for (int i = 0; i < numberOfDeletion; i++) {
                if (allNodes.size() <= 0) break;
//                int randDelete = random.nextInt(allNodes.size());
//                String randString = Integer.toString(allNodes.get(randDelete));
                int randDelete = random.nextInt(count) + 1;
                String randString = String.valueOf(randDelete);

//                System.out.println("randDelete: " + randDelete + ", randString: " + randString);

                bst.delete(randString);

                if( allNodes.size() > randDelete){
                    allNodes.remove(randDelete);
                } else continue;

//                if(allNodes.contains(randDelete)){
//                    System.out.println("node to delete: " + randDelete);
//                    allNodes.remove(randDelete);
//                    System.out.println("allnodes delete: " + allNodes);
//                }

                int randSupplement = random.nextInt(count);
//                System.out.println("put back: " + randSupplement);
                bst.put(Integer.toString(randSupplement), randSupplement);
//                if (!allNodes.contains(randSupplement)){
//                    allNodes.add(randSupplement);
//                }
                allNodes.add(randSupplement);
            }
            System.out.println("n: " + totalNodes + ", delete size: "+ (totalNodes - allNodes.size()) +",rootOfn: " + Math.sqrt(totalNodes) + ",TreeHeight: " + bst.depth());

        }


    }

    public static void main(String[] args) {

        for (int i = 5; i <= 2050; i*=2) {
            System.out.println("i: " + i);
            BSTHeight(i, i/2, 10);
            System.out.println("--------------------");
        }


    }
}
