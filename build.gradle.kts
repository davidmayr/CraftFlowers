plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("com.modrinth.minotaur") version "2.+"
}

group = "at.toastiii.craftflowers"
version = "1.1.1"

repositories {
    maven(url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/"))
    maven(url = uri("https://maven.enginehub.org/repo/"))
    maven(url = uri("https://libraries.minecraft.net"))

}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.19.2-R0.1-SNAPSHOT")
    compileOnly("com.mojang:authlib:1.6.25")
    compileOnly("com.fastasyncworldedit:FastAsyncWorldEdit-Bukkit:2.0.0")
    implementation("fr.minuskube.inv:smart-invs:1.2.7") {
        isTransitive = false
    }
}

tasks.withType<ProcessResources> {
    filesMatching("plugin.yml") {
        expand(mapOf("version" to project.version))
    }
}

modrinth {
    token.set(System.getenv("MODRINTH_TOKEN"))
    projectId.set("craftflowers")
    versionNumber.set(project.version.toString())
    versionType.set(System.getenv("MODRINTH_RELEASE_TYPE") ?: "release") // This is the default -- can also be `beta` or `alpha`
    uploadFile.set("shadowJar")
    gameVersions.set(listOf("1.16", "1.17", "1.18", "1.19"))
    loaders.set(listOf("paper", "purpur", "spigot"))
    dependencies {
        required.project("fastasyncworldedit") // Creates a new required dependency on fastasyncworldedit
    }
}

tasks {
    shadowJar {
        relocate("fr.minuskube.inv", "cm.ptks.craftflowers.smartinvs")
    }
    build {
        dependsOn(shadowJar)
    }
    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(17)
    }
    javadoc {
        options.encoding = Charsets.UTF_8.name()
    }
    processResources {
        filteringCharset = Charsets.UTF_8.name()
    }
}