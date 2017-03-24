package main.java.yangqi.yangqi.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangqi on 24/03/2017.
 */
public class TwoSumSolution {

    public static void main(String[] args) {
        int []nums={3,2,4};
        int target = 6;

        int[] retIndies=twoSum(nums,target);
        System.out.println(retIndies[0]+"-"+retIndies[1]);
        retIndies=twoSumWithMap(nums,target);
        System.out.println(retIndies[0]+"-"+retIndies[1]);

    }
    public static int[] twoSum(int[] nums, int target) {
        int []indies=new int[2];
        for(int i=0;i<nums.length;i++){
            int index=nums[i];
            for(int j=i+1;j<nums.length;j++){
                int canidate=nums[j];
                if(index+canidate==target){
                    indies[0]=i;
                    indies[1]=j;
                    break;
                }
            }
        }
        return indies;
    }

    public static int[] twoSumWithMap(int[] nums, int target) {
        int []indies=new int[2];
        Map<Integer,Integer> tracker=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(tracker.containsKey(target-nums[i])){
                indies[1]=i;
                indies[0]=tracker.get(target-nums[i]);
                return indies;
            }else{
                tracker.put(nums[i],i);
            }

        }
        return indies;
    }
}
