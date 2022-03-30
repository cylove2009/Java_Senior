import java.util.concurrent.*;

public class MultiThreadTest {


    public static void main(String[] args) {

        NumThread numThread = new NumThread();
        //4.将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
//        FutureTask futureTask = new FutureTask(numThread);
//        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
////        new Thread(futureTask).start();
//
//        new Thread(futureTask).start();

        /*****************************************************/


        ExecutorService service = Executors.newFixedThreadPool(10);

        //ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        //service.execute();
        service.submit(new NumThread());
        service.shutdown();
    }




}


class NumThread implements Callable{


    @Override
    public Object call() throws Exception {

        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}