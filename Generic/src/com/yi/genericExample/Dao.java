package com.yi.genericExample;

import java.util.*;

public class Dao <T>{

    Map<String, T> map;


    public Dao(Map<String, T> map) {
        this.map = map;
    }

//    Map<String, T> map2 = new HashMap<String, T>();

    public void save(String id, T entity){

        this.map.put(id,entity);
    }

    public T get(String id){

        return map.get(id);

    }
    public void update(String id, T entity){
        
        map.replace(id,entity);
    }
    
    public List<T> list(){
        
        List<T> tmp = new ArrayList<T>();

        Collection<T> values = map.values();

        for(T t : values){
            tmp.add(t);
        }

        return tmp;
    }
    
    public void delete(String id){
        
        map.remove(id);
    }
    
    public void show(){

//        for(String value : this.map.keySet()){
//
//            System.out.println(value);
//        }

        Iterator<Map.Entry<String, T>> it = map.entrySet().iterator();

        while(it.hasNext()){

            Map.Entry<String, T> entry = it.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue().toString());
        }
        }
        
    }

