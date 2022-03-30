import org.junit.Test;

import java.util.*;

public class Leetcode_215_Kth_Largest_Element_in_an_Array {

    public int findKthLargest(int[] nums, int k) {

        int res = -1;

        Map<Integer,Integer> map = new HashMap<>();

        //wrong
//        for(int i : nums){
//            if(map.containsKey(nums[i]))
//                map.put(nums[i],map.get(nums[i])+1);
//            else
//                map.put(nums[i],1);
//        }

        for(int i : nums){
            if(map.containsKey(i))
                map.put(i,map.get(i)+1);
            else
                map.put(i,1);
        }

        System.out.println(map.keySet());
        System.out.println(map.values());

        //PriorityQueue<Map.Entry<Integer,Integer>>  maxHeap = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue()- a.getValue()));

        for(Map.Entry<Integer,Integer> i:map.entrySet()){ //map.entrySet() instead of map.
            System.out.println(i);
            maxHeap.add(i);
        }

//        int index = 0;
//
//        while(index < k){
//            Map.Entry<Integer, Integer> poll = maxHeap.poll();
//            System.out.println(poll);
//            res = poll.getKey();
//            //System.out.println(res);
//            index++;
//        }

        for(int i = 0 ; i < k; i++) {
            Map.Entry<Integer, Integer> res2 = maxHeap.poll();
            //res= res2.getKey();
            System.out.println(res2);
        }


        return res;
    }

//

    public int findKthLargest_after_idea_ac(int[] nums, int k) {

        int res = -1;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //return o1-o2; // minHeap
                return o2 - o1;
            }

        });

        for(int i : nums){
            maxHeap.add(i);
        }

        for(int i = 0 ; i < k; i++) {
           res = maxHeap.poll();
        }

        return res;
    }

    @Test
    public void testfindKthLargest(){

        int[] nums={3,2,1,5,6,4};
        int k=2;

        findKthLargest(nums,k);
    }
}
