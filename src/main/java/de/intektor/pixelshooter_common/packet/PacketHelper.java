package de.intektor.pixelshooter_common.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author Intektor
 */
public class PacketHelper {

    public static void writePacket(Packet packet, DataOutputStream out) throws IOException {
        out.writeInt(PacketRegistry.INSTANCE.getIdentifierByClass(packet.getClass()));
        packet.write(out);
    }

    public static Packet readPacket(DataInputStream in) throws IOException {
        Packet packet = null;
        try {
            packet = PacketRegistry.INSTANCE.getClassByIdentifier(in.readInt()).newInstance();
        } catch (Exception e) {
        }
        assert packet != null;
        packet.read(in);
        return packet;
    }

    public static void sendPacket(Packet packet, Socket to) {
        try {
            writePacket(packet, new DataOutputStream(to.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
