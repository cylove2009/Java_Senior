import org.junit.Test;

import java.util.*;

public class Heap {

    @Test
    public void test_and_play_heap(){

        //13 11 7 10 9 5 2
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        int[] input = new int[]{1,1,1,2,2,4};

        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,List<Integer>> map2 = new HashMap<>();

        for(int i:input) {

            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }


        //? count?
        for(int i:map.values())

        System.out.println(map.keySet());
        System.out.println(map.values());





        int k = 2;


        list.add(13);
        list.add(11);
        list.add(7);
        list.add(10);
        list.add(5);
        list.add(2);
        list.add(20);

        PriorityQueue<Integer> heap = new PriorityQueue<>(); // min heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());// max heap

        //System.out.println(list);

        heap.addAll(list);
        maxHeap.addAll(list);

      //System.out.println(heap.peek());
      //heap.poll();
      //System.out.println(heap.peek());

      for(int i = 0; i < k ; i++){

          res.add(heap.poll());

      }

        for(int i = 0; i < k ; i++){

            res.add(maxHeap.poll());

        }

        System.out.println(res);

    }
}
