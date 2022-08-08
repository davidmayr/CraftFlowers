package cm.ptks.craftflowers.storage;

public enum LanguageList {

	COMMAND_NO_PERMISSION_USE("commands.no_permission_use"),

	COMMAND_VERSIONCOMMAND_AUTHOR("commands.version"),
	COMMAND_WEBSITE("commands.author"),
	COMMAND_NO_PERMISSION_SAVE("commands.website"),
	COMMAND_SUCCESS_SAVE("commands.no_permission_save");

	private final String languageList;


	LanguageList(String aclanguageList) {
		this.languageList = aclanguageList;
	}
	

	public String getaLanguageList(String language) {
		return languageList;
	}

}


