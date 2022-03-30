import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIBasic {

    @Test
    public void StreamCreation(){

        // #1 collection's method stream
        List<Employee> employees = EmployeeData.getEmployees();

        Object[] objects = employees.toArray();

//        for (int o = 0; o < objects.length; o++) {
//
//                System.out.println(objects[o]);
//
//        }



        Stream<Employee> stream = employees.stream();

        //#2 Array.stream

        Stream<String> stringStream = Arrays.stream(new String[]{"AB", "CD"});


        Stream<Object> stream1 = Arrays.stream(EmployeeData.getEmployees().toArray()); //??
        
        
        //#3

        Stream<String> stringStream1 = Stream.of(new String[]{"AB", "CD"});

        Stream<Object> objectStream = Stream.of(EmployeeData.getEmployees().toArray());



        //objectStream.limit(3).forEach(System.out::println);

        stream1.limit(3).forEach(new Consumer<Object>() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });

        objectStream.limit(3).forEach(o -> System.out.println(o));


    }
@Test
    public void StreamTestAPI_filter_etc(){

        List<Employee> employeeList = EmployeeData.getEmployees();

        Stream<Employee> sequential = employeeList.stream().sequential();

        Stream<Employee> parallel = employeeList.stream().parallel();

    employeeList.add(new Employee(1010,"刘强东",40,8000));
    employeeList.add(new Employee(1010,"刘强东",40,8000));
    employeeList.add(new Employee(1010,"刘强东",40,8000));

        //sequential.filter(e-> e.getAge() > 30).forEach(System.out::println);

    sequential.filter(new Predicate<Employee>() {
        @Override
        public boolean test(Employee employee) {
            return employee.getAge() > 30;
        }
    }).forEach(System.out::println);

        //sequential.limit(3).forEach(System.out::println);

        //parallel.skip(3).forEach(System.out::println);

        sequential.distinct().forEach(System.out::println);


    }

    @Test
    public void StreamTestAPI_map(){

        //Stream<Object> objectStream = Arrays.stream(EmployeeData.getEmployees().toArray());

        List<Employee> employeeList = EmployeeData.getEmployees();

        Stream<Employee> sequential = employeeList.stream().sequential();

        Function<Employee,Employee> func2 = new Function<Employee, Employee>() {
            @Override
            public Employee apply(Employee employee) {
                Employee employee1 = new Employee(employee);
                employee1.setAge(employee.getAge()+ 10);
                return employee1;
            }
        };

        //map(employee/employee)
        //sequential.map(func2).sorted(((o1, o2) -> Integer.compare(o1.getAge(),o2.getAge()))).forEach(System.out::println);

        //map(employee/string)
        //sequential.map(employee -> employee.getName()).filter(s -> s.length() > 2)

        /*-------------------------
        To work on filter/map/sort
        ____________________________ */


        //to cut off the stream   max/min/count/findFirst/findAny/allMatch/anyMatch
        Optional<Integer> max = sequential.map(employee -> employee.getAge()).max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });



    }

    @Test
    public void StreamTestAPI_flatmap(){

        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");


        // Flatmap vs map
        Stream<Character> characterStream = list.stream().flatMap(StreamAPIBasic::StringtoStream_2);

        characterStream.forEach(System.out::println);;


//        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPIBasic::StringtoStream_2);
//        streamStream.forEach(s ->{
//            s.forEach(System.out::println);
//        });


    }

//    public static Stream<Character> StringtoStream_1(String s){
//
//        char[] chars = s.toCharArray();
//
//
//
//        return Stream.of(chars);
//
//
//    };


    public static Stream<Character> StringtoStream_2(String s){
        ArrayList<Character> characterArrayList = new ArrayList<>();

        for(Character c :s.toCharArray()){
            characterArrayList.add(c);

        }
        return characterArrayList.stream();
    };



}
