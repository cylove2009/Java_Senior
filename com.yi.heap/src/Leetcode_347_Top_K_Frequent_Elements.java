

import org.junit.Test;

import java.util.*;

public class Leetcode_347_Top_K_Frequent_Elements {

    //347. Top K Frequent Elements
    //Leetcode 692 top k frequent word
    //leetcode 451 Sort Characters by Frequency
    //Doesn't understand the question thoroughly. 误认为取频率。实际是取频率对应的值
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> freq = new HashMap<>();
        List<Integer> res = new ArrayList<>();

//        for (int i : nums){
//
//            if(freq.containsKey(nums[i]))
//
//        }

        for (int i = 0; i < nums.length; i++){

            if(freq.containsKey(nums[i]))
                freq.put(nums[i],freq.get(nums[i]) + 1);
            else
                freq.put(nums[i],1);
        }

        Set<Map.Entry<Integer, Integer>> entries = freq.entrySet();

        Iterator<Map.Entry<Integer, Integer>> it = entries.iterator();

        while(it.hasNext()){

            Map.Entry<Integer, Integer> next = it.next();
            if(next.getValue() >= k)
            res.add(next.getKey());

        }

//         for (int i = 0; i < nums.length; i++){

//             if(freq.containsKey(nums[i])){

//                  if(freq.get(nums[i]) >= k)
//                      res.add(nums[i]);
//                  freq.put(nums[i],-1);
//             }
//         }

        Collections.sort(res);

        System.out.println(res);

        int[] res2 = new int[k];

        for (int i = res.size()-1, j = 0; i > res.size()-1-k; i--,j++){
            res2[j] = res.get(i);
            System.out.println(res2[j]);
        }

        return res2;
    }

// Incorrect, PriorityQueue 不知道如何创建正确的MAXHEAP。
    public int[] topKFrequent_after_idea_myown(int[] nums, int k) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        int[] res2 = new int[k];

        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>(); //不知道如何创建争取MAXHEAP。


        for (int i = 0; i < nums.length; i++) {

            if (freq.containsKey(nums[i]))
                freq.put(nums[i], freq.get(nums[i]) + 1);
            else
                freq.put(nums[i], 1);
        }


        System.out.println(freq.values());
        System.out.println(freq.keySet());

        for(Map.Entry<Integer,Integer> i: freq.entrySet()){

            heap.add(i);

        }

        for(int i = 0 ; i < k; i++) {
            Map.Entry<Integer, Integer> poll = heap.poll();
            res2[i]= poll.getKey();
            System.out.println(res2[i]);
        }

        return res2;

    }
 //AC
    public int[] topKFrequent_after_idea_AC(int[] nums, int k) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        int[] res2 = new int[k];

        PriorityQueue<Map.Entry<Integer,Integer>> maxheap = new PriorityQueue<>((a, b) -> (b.getValue()- a.getValue()));

        for (int i = 0; i < nums.length; i++) {

            if (freq.containsKey(nums[i]))
                freq.put(nums[i], freq.get(nums[i]) + 1);
            else
                freq.put(nums[i], 1);
        }


        for(Map.Entry<Integer,Integer> i: freq.entrySet()){

            maxheap.add(i);

        }

        for(int i = 0 ; i < k; i++) {
            Map.Entry<Integer, Integer> res = maxheap.poll();
            res2[i]= res.getKey();
        }

        return res2;
    }


    // incorrect idea,  第二对应数组只能保存同一频率的一个值，CASE不满足 [1,2] k =1 的情况。
    public int[] topKFrequent_after_idea2_myown(int[] nums, int k) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        int[] res2 = new int[k];

        for (int i = 0; i < nums.length; i++) {

            if (freq.containsKey(nums[i]))
                freq.put(nums[i], freq.get(nums[i]) + 1);
            else
                freq.put(nums[i], 1);
        }

//        List<Integer>[] bucket = new List[nums.length + 1]; //不会写 ！！！！
//
//        for(int i : freq.keySet()){
//            Integer index = freq.get(i);
//            if(bucket[index] == null)
//                bucket[index] = new LinkedList<>();
//            bucket[index].add(i);
//        }


        int[] bucket = new int[nums.length +1]; //

        for(int i :freq.keySet()){

            Integer index = freq.get(i);

            if(bucket[index] == 0)
                bucket[index] = i;
            System.out.println("index------" + i);

        }

        for( int i = nums.length ; i >= 0 && k > 0; i--){

            if(bucket[i] != 0)
            {
                res2[k-1] = bucket[i];
                System.out.println(res2[k-1] + "------------" + (k-1));
                k--;
            }

        }

        return res2;
    }


    public List<Integer> topKFrequent_after_idea2_AC(int[] nums, int k) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        int[] res2 = new int[k];
        List<Integer> reslist = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            if (freq.containsKey(nums[i]))
                freq.put(nums[i], freq.get(nums[i]) + 1);
            else
                freq.put(nums[i], 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1 ]; // 不会写

        for(int i : freq.keySet() )
        {

            Integer index = freq.get(i);
            if(bucket[index] == null){

                bucket[index] = new LinkedList<>();

            }
            bucket[index].add(i);

        }

        for( int i = nums.length + 1 -1 ; i >= 0 && k >0 ; i++){

            if(bucket[i] != null){

                //bucket[i].addAll(reslist); // incorrect LIST API不会用。
                reslist.addAll(bucket[i]);
                k = k-bucket[i].size();

            }


        }

    return reslist;
    }



    @Test
    public void testtopKFrequent(){

        int nums[] = {1,1,1,2,2,3};
        int nums2[] = {3,2,1,5,6,4};
        int k = 2;



        topKFrequent_after_idea2_AC(nums,k);

        //System.out.println((0-1)/2);
    }
}
