package flower.store;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Store {
    private List<FlowerBucket> flowerBuckets;

    public Store() {
        this.flowerBuckets = new ArrayList<>();
    }

    public void addFlowerBucket(FlowerBucket bucket) {
        flowerBuckets.add(bucket);
    }

    public List<FlowerBucket> search(FlowerColor color, FlowerType type, double maxPrice) {
        return flowerBuckets.stream()
            .filter(bucket -> bucketContainsSuitableFlower(bucket, color, type, maxPrice))
            .collect(Collectors.toList());
    }

    private boolean bucketContainsSuitableFlower(FlowerBucket bucket, FlowerColor color, FlowerType type, double maxPrice) {
        return bucket.getFlowerBucket().stream().anyMatch(pack -> isFlowerSuitable(pack.getFlower(), color, type, maxPrice));
    }

    private boolean isFlowerSuitable(Flower flower, FlowerColor color, FlowerType type, double maxPrice) {
        boolean colorMatches = color == null || flower.getColor().equals(color.toString());
        boolean typeMatches = type == null || flower.getFlowerType().equals(type);
        boolean priceMatches = flower.getPrice() <= maxPrice;
        return colorMatches && typeMatches && priceMatches;
    }
}

