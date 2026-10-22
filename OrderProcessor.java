package processing;
import model.Product;
public class OrderProcessor<T extends Product> {

    private T product;

    public OrderProcessor(T product)
            throws InvalidOrderException {

        if (product == null) {
            throw new InvalidOrderException(
                    "Товар не може бути null"
            );
        }

        this.product = product;
    }

    public void process() {

        System.out.println(
                "Обробка замовлення: "
                        + product.getName()
        );
    }
    public T getProduct() {
        return product;
    }
}