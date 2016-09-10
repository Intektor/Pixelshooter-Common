package de.intektor.pixelshooter_common.net.packet;

import de.intektor.pixelshooter_common.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Intektor
 */
public class InternalServerErrorWhileGettingLevelDataPacketToClient implements Packet {

    public InternalServerErrorWhileGettingLevelDataPacketToClient() {
    }

    @Override
    public void write(DataOutputStream out) throws IOException {

    }

    @Override
    public void read(DataInputStream in) throws IOException {

    }
}
