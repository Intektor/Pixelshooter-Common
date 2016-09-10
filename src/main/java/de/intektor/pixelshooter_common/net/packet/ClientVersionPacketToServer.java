package de.intektor.pixelshooter_common.net.packet;

import de.intektor.pixelshooter_common.common.ClientVersion;
import de.intektor.pixelshooter_common.files.pstf.PSTagCompound;
import de.intektor.pixelshooter_common.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Intektor
 */
public class ClientVersionPacketToServer implements Packet {

    public ClientVersion version;

    public ClientVersionPacketToServer() {
    }

    public ClientVersionPacketToServer(ClientVersion version) {
        this.version = version;
    }

    @Override
    public void write(DataOutputStream out) throws IOException {
        PSTagCompound tag = new PSTagCompound();
        version.writeToTag(tag);
        tag.writeToStream(out);
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        PSTagCompound tag = new PSTagCompound();
        tag.readFromStream(in);
        version = new ClientVersion();
        version.readFromTag(tag);
    }
}
