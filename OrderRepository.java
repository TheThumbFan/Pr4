package storage;
import model.Product;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private static final List<Product> products =
            new ArrayList<>();

    public static void save(Product product) {

        products.add(product);

        System.out.println(
                "Збережено: "
                        + product.getName()
        );
    }

    public static List<Product> getProducts() {
        return products;
    }
}