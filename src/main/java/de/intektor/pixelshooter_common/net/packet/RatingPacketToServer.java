package de.intektor.pixelshooter_common.net.packet;

import de.intektor.pixelshooter_common.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Intektor
 */
public class RatingPacketToServer implements Packet {

    public int starsRated;
    public String officialID;
    public String idToken;

    public RatingPacketToServer(int starsRated, String officialID, String idToken) {
        this.starsRated = starsRated;
        this.officialID = officialID;
        this.idToken = idToken;
    }

    public RatingPacketToServer() {
    }

    @Override
    public void write(DataOutputStream out) throws IOException {
        out.writeInt(starsRated);
        out.writeUTF(officialID);
        out.writeUTF(idToken);
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        starsRated = in.readInt();
        officialID = in.readUTF();
        idToken = in.readUTF();
    }
}
