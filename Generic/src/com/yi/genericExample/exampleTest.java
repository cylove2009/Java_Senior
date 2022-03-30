package com.yi.genericExample;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class exampleTest {

    @Test
    public void addUserTest(){

        Dao<User> dao = new Dao<User>(new HashMap<String, User>());

        User user1 = new User(11,22,"Mary");
        User user2 = new User(12,23,"Kary");

        dao.save("11",user1);
        dao.save("12",user2);

        System.out.println(dao.get("12").getName());

        dao.show();

    }
}
