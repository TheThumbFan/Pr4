package model;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class Clothing extends Product
{
    private String size;
    public Clothing(
            String name,
            double price,
            String size)
    {
        super(name, price);
        this.size = size;
    }
}