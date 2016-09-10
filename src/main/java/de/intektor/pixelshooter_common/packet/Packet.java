package de.intektor.pixelshooter_common.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Intektor
 */
public interface Packet {

    void write(DataOutputStream out) throws IOException;

    void read(DataInputStream in) throws IOException;
}
