import org.junit.Test;

import java.lang.reflect.*;

public class ReflectionTest {


    @Test
    public void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class clazz = Person.class;

        Class clazz2 = Class.forName("Person");
        Object obj = clazz2.newInstance();

        System.out.println(obj);

        Person p1 = new Person();
        Class clazz3 = p1.getClass();

        //System.out.println(clazz.getName());

        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> person = classLoader.loadClass("Person");

//        Type genericSuperclass = clazz.getGenericSuperclass();
//        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
//        Type[] actualTypeArguments = paramType.getActualTypeArguments();
//
//
//        System.out.println(genericSuperclass);

//        System.out.println(actualTypeArguments[0]);

        }

    @Test
    public void testField() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {

        Class clazz = Class.forName("Person");
        Object o = clazz.newInstance();

        Person p = (Person)o;

        Field id = clazz.getField("id"); //// not in practice, no use.
        Field age = clazz.getDeclaredField("age");
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);

        id.set(p,112);
        age.set(p,115);
        name.set(p,"ajax");

        System.out.println(id.get(p));
        System.out.println(age.get(p));
        System.out.println(name.get(p));


    }
@Test
    public void testMethod() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Class.forName("Person");
        Object o = clazz.newInstance();
        Person p = (Person) o;

        Method show = clazz.getDeclaredMethod("show",String.class);
        Method show1 = clazz.getDeclaredMethod("show");
        show1.invoke(p);

        show.setAccessible(true);
        //show.invoke(p);
        Object one_argument = show.invoke(p, "one 2 argument");
        System.out.println(one_argument.getClass());
        System.out.println((String) one_argument);

        Method showStatic = clazz.getDeclaredMethod("showStatic");
        showStatic.setAccessible(true);
        showStatic.invoke(clazz);
        showStatic.invoke(Person.class);
        System.out.println(this.getClass());



}

    @Test
    public void TestClassLoader(){

        ClassLoader classLoader1 = String.class.getClassLoader();

        System.out.println(classLoader1); // null bootstrap class loader

        ClassLoader classLoader2 = Person.class.getClassLoader();

        System.out.println(classLoader2); // appclassloader -- system classloader

        ClassLoader classLoader2Parent = classLoader2.getParent();

        System.out.println(classLoader2Parent); //Extention classLoader- loading jar(.class file)

    }
}
