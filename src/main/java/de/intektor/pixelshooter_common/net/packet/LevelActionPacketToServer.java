package de.intektor.pixelshooter_common.net.packet;

import de.intektor.pixelshooter_common.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Intektor
 */
public class LevelActionPacketToServer implements Packet {

    public String officialID;
    public UUID playerUUID;
    public Action action;

    public LevelActionPacketToServer(String officialID, UUID playerUUID, Action action) {
        this.officialID = officialID;
        this.playerUUID = playerUUID;
        this.action = action;
    }

    public LevelActionPacketToServer() {
    }

    @Override
    public void write(DataOutputStream out) throws IOException {
        out.writeUTF(officialID);
        out.writeUTF(playerUUID.toString());
        out.writeInt(action.ordinal());
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        officialID = in.readUTF();
        playerUUID = UUID.fromString(in.readUTF());
        action = Action.values()[in.readInt()];
    }

    public enum Action {
        PLAY,
        DOWNLOAD
    }
}
