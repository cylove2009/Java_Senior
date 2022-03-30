public class Person {

    private String name;
    int age;
    public int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name){

        this.name = name;

    }

    public Person(){};

    @Override
    public String toString() {
        return "Person_ToString{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show(){

        System.out.println("this is show method");
    }

    public String show(String s){
        System.out.println("this is s string" + s );
        return s;
    }

    private static void showStatic(){

        System.out.println("this is static method");
    }
}
