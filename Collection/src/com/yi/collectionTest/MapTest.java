package com.yi.collectionTest;

import org.junit.Test;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class MapTest {

    @Test
    public void MapBasic(){

        Map map = new HashMap<>();
        Map map1 = new LinkedHashMap();

        map.put("AA",123);
        map.put(45,1234);
        map.put("BB",56);

        Collection values = map.values();
        Set set = map.keySet();
        Set set1 = map.entrySet();



        Iterator it_value = values.iterator();
        Iterator it_key = set.iterator();
        Iterator it_entry = set1.iterator();

        //show(it_value);
        //show(it_key);
        //show(it_entry);

//        while(it_entry.hasNext()){  // iteration method 1
//
//            Object next = it_entry.next();
//            Map.Entry entry = (Map.Entry) next;
//            System.out.println(entry.getKey() + "---Method 1-----" + entry.getValue());
//
//        }

        while(it_key.hasNext()){

            Object obj = it_key.next();
            Object value = map.get(obj);

            System.out.println(obj + "------Method 2------" + value);
        }





    }

    public void show(Iterator it){

        while(it.hasNext()){

            System.out.println(it.next());

        }

    }

    @Test
    public void TreeMapTest1(){

        Map<User,Integer> map = new TreeMap();

        User u1 = new User("Tom",23);
        User u2 = new User("Jerry",32);
        User u3 = new User("Jack",20);
        User u4 = new User("Rose",18);

        map.put(u1,98);
        map.put(u2,89);
        map.put(u3,76);
        map.put(u4,100);

        Iterator it = map.entrySet().iterator();

        while(it.hasNext()){

            Map.Entry entry = (Map.Entry) it.next();

            System.out.println(entry.getKey() + "----" + entry.getValue());
        }
    }


    @Test
    public void SortedMap_TreeMapTest(){


        Map<User,Integer> Sorted_map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {

                if( o1 instanceof User && o2 instanceof User){

                    String name1 = ((User) o1).getName();
                    String name2= ((User) o2).getName();

                    return name1.compareTo(name2);

                }else{

                    return 0;
                }

            }
        });

        User u1 = new User("Tom",23);
        User u2 = new User("Berry",32);
        User u3 = new User("Aack",20);
        User u4 = new User("Rose",18);

        Sorted_map.put(u1,98);
        Sorted_map.put(u2,89);
        Sorted_map.put(u3,76);
        Sorted_map.put(u4,100);

        Iterator it = Sorted_map.entrySet().iterator();

        while(it.hasNext()){

            Map.Entry entry = (Map.Entry) it.next();

            System.out.println(entry.getKey() + "----" + entry.getValue());
        }



        }


    @Test
    public void MapGenericTest() {

        Map<String,Integer> map = new HashMap();

        map.put("Tom",87);
        map.put("Jerry",87);
        map.put("Jack",67);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        Iterator it = entries.iterator();

        while(it.hasNext()){

            Map.Entry entry = (Map.Entry) it.next(); // need to cast without generic


            System.out.println(entry.getKey() + "-------> "+ entry.getValue());

        }

        Iterator<Map.Entry<String,Integer>> it2 = entries.iterator(); // no need to cast with generic

        while(it2.hasNext()){

            Map.Entry entry = it2.next();
            System.out.println(entry.getKey() + "-------> "+ entry.getValue());
        }

    }

    @Test
    public void MapGenericTest2(){

        String s = "abcabced";
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        int size = s.length();

        int count[] = new int[size];
        char charArray[] = s.toCharArray();

        System.out.println('b');
        int j = 0;

    //        for( char i : s.toCharArray()){

            for(int i = 0; i <s.length();i++)
            {
                //System.out.println(i);
                if(!map.containsKey(charArray[i])) map.put(charArray[i],++count[i]);
                else{
                    int temp = map.get(charArray[i]);
                    map.put(charArray[i],++temp);
                }

            }

//        System.out.println(map.keySet());
//        System.out.println(map.values());
        //System.out.println();

        Iterator it = map.entrySet().iterator();

        while(it.hasNext()){

            Map.Entry entry = (Map.Entry) it.next();

            //System.out.println(entry.getKey() + "----" + entry.getValue());
        }
    }


    @Test
    public void ArrayDefineTest(){

        int test[] = new int[128];

        test[97] = -1;
        //System.out.println(test[2]);

        String s = "abcabced";

        char charArray[] = s.toCharArray();

        System.out.println(test[charArray[0]]);

        List<Integer> ret = new LinkedList<Integer>();

    }

    @Test
    public void MapValueTest(){

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(1,1);
        map.put(2,2);
        map.put(3,3);

        System.out.println(map.values());

        HashMap<Integer,Integer> map2 = new HashMap<>();

        map2.put(1,1);
        map2.put(3,3);
        map2.put(2,2);

        System.out.println(map2.values());

        map2.values();

        //System.out.println(map2.values().equals(map.values()));

       Collection<Integer> list1 = map.values();
       Collection<Integer> list2 = map2.values();


        System.out.println(list1.containsAll(list2));




    }

    @Test
    public void testMapTravsel(){

        HashMap<String,Integer> map = new HashMap<>();

        List<Integer> unsortList = new ArrayList<>();

        map.put("Tom",87);
        map.put("Jerry",77);
        map.put("Jack",67);
        map.put("jesse",57);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        Iterator<Map.Entry<String, Integer>> it = entries.iterator();

        while(it.hasNext()){
            Map.Entry<String, Integer> next = it.next();
//            System.out.println(next.getKey());
//            System.out.println(next.getValue());
            unsortList.add(next.getValue());
        }

//        System.out.println(unsortList);
//
//        Collections.sort(unsortList);
//
//        System.out.println(unsortList);

        if(map.containsValue(57))
            System.out.println("yes 57");




    }
}
