package threading;
import model.Product;
import processing.OrderProcessor;

public class OrderThreadManager {

    public static <T extends Product> void processOrder(
            OrderProcessor<T> processor) {

        Runnable task = () -> {
            System.out.println(
                    "Потік: "
                            + Thread.currentThread().getName());

            processor.process();
        };
        new Thread(task).start();
    }
}