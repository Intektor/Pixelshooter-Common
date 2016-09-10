package de.intektor.pixelshooter_common.common;

import de.intektor.pixelshooter_common.files.pstf.PSTagCompound;

/**
 * @author Intektor
 */
public class ClientVersion {

    public int major;
    public int minor;
    public int little;

    public ClientVersion(int major, int minor, int little) {
        this.major = major;
        this.minor = minor;
        this.little = little;
    }

    public ClientVersion() {
    }

    public void writeToTag(PSTagCompound tag) {
        tag.setInteger("major", major);
        tag.setInteger("minor", minor);
        tag.setInteger("little", little);
    }

    public void readFromTag(PSTagCompound tag) {
        major = tag.getInteger("major");
        minor = tag.getInteger("major");
        little = tag.getInteger("little");
    }
}
