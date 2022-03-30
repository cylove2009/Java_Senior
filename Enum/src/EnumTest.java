import org.junit.Test;

public class EnumTest {

    @Test
    public void test1(){

        Season season = Season.SPRINT;


        System.out.println(season);
        season.show();

        System.out.println(Status.FREE);

    }

    @Test
    public void EnumClassTest(){

        Season season = Season.SPRINT;
        Season[] values = Season.values();
        Enum e;

        for(int i = 0; i < values.length; i++){

            System.out.println(values[i]);
        }
        Season s = Season.valueOf("SPRINT");

        System.out.println(s);

        // father class of enum class is Enum

        System.out.println(Season.class.getSuperclass());



    }

}


interface show{

    void show();

}
enum Season implements show{

    SPRINT{
        @Override
        public void show() {
            System.out.println("spring show");
        }
    },
    SUMMER{
        @Override
        public void show() {
            System.out.println("summer show");
        }
    },
    WINTER,
    FALL;



    @Override
    public String toString() {
        return super.toString();
    }


    @Override
    public void show() {
        System.out.println("generic show");
    }
}

class Status{

    private final String status;

   public Status(String status){

       this.status = status;

   }

   public static final Status FREE = new Status("FREE");
   public static final Status VOCATION = new Status("VOCATION");

    @Override
    public String toString() {
        return status;
    }
}