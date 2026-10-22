import com.github.javafaker.Faker;
import model.Clothing;
import model.Electronics;
import model.Product;
import processing.OrderProcessor;
import processing.InvalidOrderException;
import storage.OrderRepository;
import threading.OrderThreadManager;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
            throws InvalidOrderException
    {
        Faker faker = new Faker();

        Electronics laptop =
                Electronics.builder()
                        .name(faker.commerce().productName())
                        .price(45000)
                        .manufacturer(
                                faker.company().name()
                        )
                        .build();

        Clothing shirt =
                Clothing.builder()
                        .name(faker.commerce().productName())
                        .price(1000)
                        .size("L")
                        .build();

        OrderProcessor<Electronics> electronicsOrder =
                new OrderProcessor<>(laptop);

        OrderProcessor<Clothing> clothingOrder =
                new OrderProcessor<>(shirt);

        OrderThreadManager.processOrder(electronicsOrder);
        OrderThreadManager.processOrder(clothingOrder);

        OrderRepository.save(laptop);
        OrderRepository.save(shirt);

        List<Product> products =
                new ArrayList<>(
                        OrderRepository.getProducts()
                );

        System.out.println("\nФільтр Electronics:");

        products.stream()
                .filter(product ->
                        product instanceof Electronics)
                .forEach(System.out::println);

        System.out.println("\nУсі товари:");

        products.forEach(System.out::println);
    }
}