package flower.store;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class FlowerBucket {
    private List<FlowerPack> flowerBucket = new ArrayList<>();

    public void add(FlowerPack flowerPack) {
        flowerBucket.add(flowerPack);
    }

    public double getPrice(){
        double[] totalPrice = {0};
        flowerBucket.forEach(flowerPack -> totalPrice[0] += flowerPack.getPrice());
        return totalPrice[0];
    }
}
