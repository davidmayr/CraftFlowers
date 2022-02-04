package cm.ptks.craftflowers.storage;

import cm.ptks.craftflowers.flower.FlowerPot;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public interface FlowerStorage {

    List<SavedFlowerPot> getSavedFlowers(UUID uuid);

    void saveFlower(String name, UUID player, FlowerPot flowerPot);

    boolean deleteFlower(String name, UUID player);

    @Nullable
    SavedFlowerPot getFlower(String name, UUID player);

    void close();

}
