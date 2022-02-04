package cm.ptks.craftflowers.storage;

import cm.ptks.craftflowers.flower.FlowerPot;

import java.util.UUID;

public class SavedFlowerPot {

    private final String name;
    private final FlowerPot flowerPot;
    private final UUID owner;
    private final long savedAt;

    public SavedFlowerPot(String name, FlowerPot flowerPot, UUID owner, long savedAt) {
        this.name = name;
        this.flowerPot = flowerPot;
        this.owner = owner;
        this.savedAt = savedAt;
    }

    public FlowerPot getFlowerPot() {
        return flowerPot;
    }

    public long getSavedAt() {
        return savedAt;
    }

    public UUID getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }
}
