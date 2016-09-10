package de.intektor.pixelshooter_common.packet;

import de.intektor.pixelshooter_common.common.Side;

import java.net.Socket;

/**
 * @author Intektor
 */
public interface PacketHandler<T extends Packet> {

    void handlePacket(T packet, Socket socketFrom, Side from);

}
