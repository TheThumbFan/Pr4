package model;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class Electronics extends Product
{
    private String manufacturer;
    public Electronics(
            String name,
            double price,
            String manufacturer)
    {
        super(name, price);

        this.manufacturer = manufacturer;
    }
}