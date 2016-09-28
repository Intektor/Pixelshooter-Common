package de.intektor.pixelshooter_common.common;

import de.intektor.pixelshooter_common.files.pstf.PSTagCompound;

/**
 * @author Intektor
 */
public class Version implements Serializable {

    public int major;
    public int minor;
    public int revision;

    public Version(int major, int minor, int revision) {
        this.major = major;
        this.minor = minor;
        this.revision = revision;
    }

    public Version() {
    }

    @Override
    public void writeToTag(PSTagCompound tag) {
        tag.setInteger("major", major);
        tag.setInteger("minor", minor);
        tag.setInteger("revision", revision);
    }

    @Override
    public void readFromTag(PSTagCompound tag) {
        major = tag.getInteger("major");
        minor = tag.getInteger("minor");
        revision = tag.getInteger("revision");
    }

    public boolean equals(Version v) {
        return major == v.major && minor == v.minor && revision == v.revision;
    }
}
