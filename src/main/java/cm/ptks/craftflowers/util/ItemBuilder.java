package cm.ptks.craftflowers.util;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Base64;
import java.util.UUID;

public class ItemBuilder {

    private final ItemStack itemStack;

    public ItemBuilder(Material material) {
        this.itemStack = new ItemStack(material);
    }

    public ItemBuilder setDisplayName(String displayName) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemBuilder setTextureId(String textureId) {
        if(textureId.isEmpty())
            return this;

        SkullMeta headMeta = (SkullMeta) itemStack.getItemMeta();
        byte[] encodedData = Base64.getEncoder().encode(String.format("{textures:{SKIN:{url:\"%s\"}}}",
                "https://textures.minecraft.net/texture/" + textureId).getBytes());

        try {
            PlayerProfile playerProfile = Bukkit.createPlayerProfile(UUID.randomUUID(), "null");
            PlayerTextures textures = playerProfile.getTextures();
            textures.setSkin(new URL("https://textures.minecraft.net/texture/" + textureId));
            playerProfile.setTextures(textures);
            headMeta.setOwnerProfile(playerProfile);
        } catch (Throwable e) {
            //Support older versions

            GameProfile profile = new GameProfile(UUID.randomUUID(), "null");

            profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
            try {
                Method method = headMeta.getClass().getDeclaredMethod("setProfile", GameProfile.class);
                method.setAccessible(true);
                method.invoke(headMeta, profile);
                method.setAccessible(false);
            } catch (IllegalArgumentException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e1) {
                e1.printStackTrace();
            }
        }
        itemStack.setItemMeta(headMeta);

        return this;
    }

    public ItemStack build() {
        return itemStack;
    }

}
