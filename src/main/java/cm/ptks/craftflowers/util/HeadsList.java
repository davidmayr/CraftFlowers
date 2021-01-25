package cm.ptks.craftflowers.util;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public class HeadsList {
    static HashMap<String, ItemStack> heads = new HashMap();

    static {
        String head_create_d = "eyJ0aW1lc3RhbXAiOjE1MDkyMTc3NzAxNTUsInByb2ZpbGVJZCI6ImJiMDgwOTFhOTJlZDQzYWQ5NGYxZWRmZDc0NmIwYTJjIiwicHJvZmlsZU5hbWUiOiJJcDRuZHgiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2I2MTc2MThmMjRkNmIwZDhhOWJmNmE0NzYxNWFjMmNhOGIxOWFlYWZjNzc2MTIzYjQ2ZGRlMDg0Y2E5MWZjIn19fQ==";
        createSkull("head_create", head_create_d, "§2§lCreate flower", " ", "§8Click to create a flower.");
        String head_edit_d = "eyJ0aW1lc3RhbXAiOjE1MzkwMzA4MTQ3MTksInByb2ZpbGVJZCI6IjBiZTU2MmUxNzIyODQ3YmQ5MDY3MWYxNzNjNjA5NmNhIiwicHJvZmlsZU5hbWUiOiJ4Y29vbHgzIiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8yYzNmOWNkYjZiNDc2NWY4NTk3YTA4MjljMzhkMWU1MjA5OTUxNWMwMzNlNjEyOTA5NzFiNTk1Nzc0MTZlNDU1In19fQ==";
        createSkull("head_edit", head_edit_d, "§9§lEdit flower", " ", "§8Click to edit a flower.");
        String head_clear_d = "eyJ0aW1lc3RhbXAiOjE1MDkyMTc4MzE3OTEsInByb2ZpbGVJZCI6IjNlMjZiMDk3MWFjZDRjNmQ5MzVjNmFkYjE1YjYyMDNhIiwicHJvZmlsZU5hbWUiOiJOYWhlbGUiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzQ4MzliY2Q3NDViZGZmMjJkMzM1M2EzODY0NzFiZWYxNjg3OTcxZDI5YjgzOGZhZDc0N2I2YmNiNDM1YTJjZSJ9fX0=";
        createSkull("head_clear", head_clear_d, "§c§lClear all", " ", "§8Click to clear all.");
        String head_remove_d = "eyJ0aW1lc3RhbXAiOjE1MDkyMTc4Mzk3NzIsInByb2ZpbGVJZCI6ImUzYjQ0NWM4NDdmNTQ4ZmI4YzhmYTNmMWY3ZWZiYThlIiwicHJvZmlsZU5hbWUiOiJNaW5pRGlnZ2VyVGVzdCIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmE4ZjIzM2NhNjYwYzE4YTRmYjJlMmNjNGQ0ZTEzN2Y5MzNiMzNmYzM0ZTAxZTU1ZDFiOWZmOGEyMTk3ZGQ4YyJ9fX0=";
        createSkull("head_remove", head_remove_d, "§6§lRemove from top", " ", "§8Click to remove flower from top.");
        String head_left_d = "eyJ0aW1lc3RhbXAiOjE1MDk4Nzk4NTI4NDYsInByb2ZpbGVJZCI6ImZkNjBmMzZmNTg2MTRmMTJiM2NkNDdjMmQ4NTUyOTlhIiwicHJvZmlsZU5hbWUiOiJSZWFkIiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS81Yzc3NDE3MTg3YjdhZjQ1Y2VkZGJiNzg0Zjk3YWI1M2UxYjBhN2JlNWQ0Y2IyZTZkZGUyMWY4MTVkNzFlOGZlIn19fQ==";
        createSkull("head_left", head_left_d, "§6§lPrevious page", " ", "§8Click to go to the previous page.");
        String head_right_d = "eyJ0aW1lc3RhbXAiOjE1MDk4Nzk4NzA0MDEsInByb2ZpbGVJZCI6IjkxOGEwMjk1NTlkZDRjZTZiMTZmN2E1ZDUzZWZiNDEyIiwicHJvZmlsZU5hbWUiOiJCZWV2ZWxvcGVyIiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS81OWI3YzM3ZjcwZGViYzRkMTZlZGM5ZWM2NWJiOWRhM2QyZWNjYmRkYjk4ZGI2MThmNjRmNjgxOGUzZDlhMmYifX19";
        createSkull("head_right", head_right_d, "§6§lNext page", " ", "§8Click to go to the next page.");
        String h1d = "eyJ0aW1lc3RhbXAiOjE1MDkyMTY2MDE4MzgsInByb2ZpbGVJZCI6ImE5MGI4MmIwNzE4NTQ0ZjU5YmE1MTZkMGY2Nzk2NDkwIiwicHJvZmlsZU5hbWUiOiJJbUZhdFRCSCIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDYzM2IyYTk3ZjJlZjU1MDc5NWNhMGE5MWQ1YWVlOGRkYzNkZmJlMWU1YTM4ODRhZTE3YzQzMzJjZDc1YTkifX19";
        createSkull("h1", h1d, "§f§lHeight 1 of flower");
        String h2d = "eyJ0aW1lc3RhbXAiOjE1MDkyMTY2MTg3OTMsInByb2ZpbGVJZCI6ImJiMDgwOTFhOTJlZDQzYWQ5NGYxZWRmZDc0NmIwYTJjIiwicHJvZmlsZU5hbWUiOiJJcDRuZHgiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzk5ZTQxMzU5M2JiMjMxN2RjNjU4MzRjYmZmZjg2MTNlNTZkMjBkYzY3ZjA3NWIyNTE4MzM0Y2QyMzQ3OWJkYyJ9fX0=";
        createSkull("h2", h2d, "§f§lHeight 2 of flower");
        String h3d = "eyJ0aW1lc3RhbXAiOjE1MDkyMTY4MTE2NTIsInByb2ZpbGVJZCI6ImE5MGI4MmIwNzE4NTQ0ZjU5YmE1MTZkMGY2Nzk2NDkwIiwicHJvZmlsZU5hbWUiOiJJbUZhdFRCSCIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjM0YTUyZjcyOTRkNWE2MDk2NmJkMzY3NjJhOGIwYTAyMDRiMTM3NmFjYTI3NGMzYzlkMjgyYmU3ZDM5In19fQ==";
        createSkull("h3", h3d, "§f§lHeight 3 of flower");
        String h4d = "eyJ0aW1lc3RhbXAiOjE1MDkyMTY4MTc1MTAsInByb2ZpbGVJZCI6ImJiMDgwOTFhOTJlZDQzYWQ5NGYxZWRmZDc0NmIwYTJjIiwicHJvZmlsZU5hbWUiOiJJcDRuZHgiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzI0MTQ5Y2IzYjgyMjUwYzEyNjI5M2UwMzg5YmMyNzE5MWNkMjcyOTVhOTU4NjhlOWVjYjVjNzdmZDg3YzRkIn19fQ==";
        createSkull("h4", h4d, "§f§lHeight 4 of flower");
        String h5d = "eyJ0aW1lc3RhbXAiOjE1MDkyMTY5MTYxMjIsInByb2ZpbGVJZCI6IjNlMjZiMDk3MWFjZDRjNmQ5MzVjNmFkYjE1YjYyMDNhIiwicHJvZmlsZU5hbWUiOiJOYWhlbGUiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2ZlYmE1ZDI0NTQ3MTdkYjdkMTdlOWYxNDkzNThkYmEzZmYyYjdmYjhhYzU0N2U1YTRmYmU1ZTJjZGYyNDVmMmEifX19";
        createSkull("h5", h5d, "§f§lHeight 5 of flower");
        String h6d = "eyJ0aW1lc3RhbXAiOjE1MDkyMTY5MzU2ODksInByb2ZpbGVJZCI6ImUzYjQ0NWM4NDdmNTQ4ZmI4YzhmYTNmMWY3ZWZiYThlIiwicHJvZmlsZU5hbWUiOiJNaW5pRGlnZ2VyVGVzdCIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDRhY2QxYTgyYjBmZWY2MmFhYmJmNTQ2ZmNiZjZkNTcyYzk4MzlmMjMxZjZjNmVkNTUxODRlNTQyN2VlMmVjIn19fQ==";
        createSkull("h6", h6d, "§f§lHeight 6 of flower");
        String h7d = "eyJ0aW1lc3RhbXAiOjE1MDkyMTcwMzMzNzIsInByb2ZpbGVJZCI6IjVjN2ZiNzhhMmQxMzQ5NTZhNWE1M2EyNGQ5NWY1YjRmIiwicHJvZmlsZU5hbWUiOiJQZWFyc29uSW5tYW4iLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzU5YThlNDRjODQ0Y2YyNmZjMzY4ZDBkNmJmZWM4ZjkwMjE1YjVhZGI4YmU3NDgzODMyZDc2N2FiMjY2NTZlNiJ9fX0=";
        createSkull("h7", h7d, "§f§lHeight 7 of flower");
        String h8d = "eyJ0aW1lc3RhbXAiOjE1MDkyMTcwNDIyMTQsInByb2ZpbGVJZCI6ImIwZDczMmZlMDBmNzQwN2U5ZTdmNzQ2MzAxY2Q5OGNhIiwicHJvZmlsZU5hbWUiOiJPUHBscyIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2E5Y2UwZjY0Zjc4NTE1NjY0M2MxOWNiZDA5ODUwNDZiOTRlMWZkMzViMWI2MWI3MTdlNjJiODUxM2FlOWRkIn19fQ==";
        createSkull("h8", h8d, "§f§lHeight 8 of flower");
        String h9d = "eyJ0aW1lc3RhbXAiOjE1MDkyMTcwNDc3NzUsInByb2ZpbGVJZCI6IjQzYTgzNzNkNjQyOTQ1MTBhOWFhYjMwZjViM2NlYmIzIiwicHJvZmlsZU5hbWUiOiJTa3VsbENsaWVudFNraW42Iiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9jZWI2NjZkZTVjOGM3N2QzYWU3ZWM1ZWJmNDI0NTIxNzZiM2Q5Yzk3MTc2NGQ5OTZhZWZiYTQwMjllMTUzNzQifX19";
        createSkull("h9", h9d, "§f§lHeight 9 of flower");
    }

    static void createSkull(String id, String data, String name, String... lore) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        if (lore.length > 0) {
            meta.setLore(Arrays.asList(lore));
        }

        item.setItemMeta(meta);
        SkullMeta headMeta = (SkullMeta) item.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", data));
        Field profileField;

        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        } catch (Exception ignored) {}

        item.setItemMeta(headMeta);
        heads.put(id, item);
    }
}
