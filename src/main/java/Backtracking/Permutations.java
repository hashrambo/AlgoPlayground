package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Leetcode 46 Permutations
 * Given a collection of distinct numbers, return all possible permutations.

    For example,
    [1,2,3] have the following permutations:
 [
    [1,2,3],
    [1,3,2],
    [2,1,3],
    [2,3,1],
    [3,1,2],
    [3,2,1]
 ]
 *
 */


public class Permutations {


    // recursive backtracking solution
    // time: O(n*n!) space:O(n*n!)
    public static List<List<Integer>> permutations(int[] nums){
        List<List<Integer>> base = new ArrayList<>();
        List<Integer> emptySet = new ArrayList<Integer>();
        helper(base, emptySet, nums);
        return base;
    }

    public static void helper(List<List<Integer>>allsets, List<Integer> set, int [] nums){
        if(set.size()==nums.length)
            allsets.add(new ArrayList<Integer>(set));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) continue;
                set.add(nums[i]);
                helper(allsets, set, nums);
                set.remove(set.size() - 1);
                /*
                To generate all possible permutations, we need to remove the last added element while
                we are going up the recursive call stack. In the first iteration of the for loop we add all
                permutations, that start with nums[0]. Then, before we can begin building all permutations
                starting with nums[1], we need to clear the set (which currently contains permutations
                from the first iteration of the for loop)
                 */
            }
        }
    }



    public static void main(String args[]){
        int [] nums = {1,2,3};
        List<List<Integer>> results = permutations(nums);

        if(results.isEmpty())
            System.out.println("empty result");
        System.out.println(results);

        ListIterator iter = results.listIterator();
        while(iter.hasNext()){
            List<Integer> result = (List<Integer>) iter.next();
            System.out.print("[");
            for(Integer num: result){
                System.out.print(" " + num);
            }
            System.out.println("]");
        }
    }
}

