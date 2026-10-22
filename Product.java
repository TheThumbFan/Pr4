package model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public abstract class Product
{
    private String name;
    private double price;
    @Override
    public String toString() {
        return name + " | " + price;
    }
}