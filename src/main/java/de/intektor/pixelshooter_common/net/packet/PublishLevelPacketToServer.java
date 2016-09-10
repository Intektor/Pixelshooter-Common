package de.intektor.pixelshooter_common.net.packet;

import de.intektor.pixelshooter_common.files.pstf.PSTagCompound;
import de.intektor.pixelshooter_common.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Intektor
 */
public class PublishLevelPacketToServer implements Packet {

    public PSTagCompound levelTag;
    public PSTagCompound infoTag;

    public PublishLevelPacketToServer(PSTagCompound levelTag, PSTagCompound infoTag) {
        this.levelTag = levelTag;
        this.infoTag = infoTag;
    }

    public PublishLevelPacketToServer() {
    }

    @Override
    public void write(DataOutputStream out) throws IOException {
        levelTag.writeToStream(out);
        infoTag.writeToStream(out);
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        levelTag = new PSTagCompound();
        levelTag.readFromStream(in);
        infoTag = new PSTagCompound();
        infoTag.readFromStream(in);
    }
}
