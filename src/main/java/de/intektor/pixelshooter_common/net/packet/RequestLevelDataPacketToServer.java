package de.intektor.pixelshooter_common.net.packet;

import de.intektor.pixelshooter_common.files.pstf.PSTagCompound;
import de.intektor.pixelshooter_common.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Intektor
 */
public class RequestLevelDataPacketToServer implements Packet {

    public String officialID;
    public PSTagCompound userInfoTag;

    public RequestLevelDataPacketToServer() {
    }

    public RequestLevelDataPacketToServer(String officialID, PSTagCompound userInfoTag) {
        this.officialID = officialID;
        this.userInfoTag = userInfoTag;
    }

    @Override
    public void write(DataOutputStream out) throws IOException {
        out.writeUTF(officialID);
        userInfoTag.writeToStream(out);
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        officialID = in.readUTF();
        userInfoTag = new PSTagCompound();
        userInfoTag.readFromStream(in);
    }
}
