package flower.store;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlowerPack {
    private Flower flower;
    private int quantity;

    public FlowerPack(Flower flower, int quantity) {
        this.flower = flower;
        this.quantity = quantity;
    }

    public double getPrice() {
        return quantity * flower.getPrice();
    }
}