package cm.ptks.craftflowers.flower;

import cm.ptks.craftflowers.storage.LanguageFile;
import com.google.gson.JsonObject;
import org.bukkit.Material;

public class AgingFlower extends Flower {

	private final int age;

	public AgingFlower(Material guiMaterial, String displayName, Material blockMaterial, int age) {
		super(guiMaterial, displayName, blockMaterial);
		this.age = age;
	}

	public AgingFlower(Material material, String displayName, int age) {
		super(material, displayName);
		this.age = age;
	}

	@Override
	public String getDisplayName() {
		return super.getDisplayName() + LanguageFile.getFlowerInfoAge(age);
	}

	@Override
	public JsonObject serialize() {
		JsonObject serialize = super.serialize();
		serialize.addProperty("age", age);
		return serialize;
	}

	public int getAge() {
		return age;
	}
}