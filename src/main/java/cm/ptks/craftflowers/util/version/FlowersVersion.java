package cm.ptks.craftflowers.util.version;

import java.util.Objects;

public class FlowersVersion {

    private final int major;
    private final int minor;
    private final int patch;

    public FlowersVersion(int major, int minor, int patch) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
    }


    public static FlowersVersion read(String string) {
        String[] split = string.split("\\.");

        try {
            if(split.length == 2) {
                return new FlowersVersion(Integer.parseInt(split[0]), Integer.parseInt(split[1]), 0);
            } else if(split.length >= 3) {
                return new FlowersVersion(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2].split("-")[0]));
            } else if(split.length == 1){
                return new FlowersVersion(Integer.parseInt(split[0]), 0, 0);
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        return new FlowersVersion(0, 0, 0);
    }

    @Override
    public String toString() {
        return major + "." + minor + "." + patch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlowersVersion that = (FlowersVersion) o;
        return major == that.major && minor == that.minor && patch == that.patch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(major, minor, patch);
    }

    public boolean isOlder(FlowersVersion version) {
        if(this.major > version.major)
            return false;
        if(this.minor > version.minor)
            return false;
        return this.patch < version.patch;
    }
}
