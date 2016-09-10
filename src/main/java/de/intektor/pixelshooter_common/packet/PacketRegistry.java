package de.intektor.pixelshooter_common.packet;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @author Intektor
 */
public class PacketRegistry {

    public static PacketRegistry INSTANCE = new PacketRegistry();

    private BiMap<Integer, Class<? extends Packet>> packetRegistry = HashBiMap.create();
    private BiMap<Class<? extends Packet>, Class<? extends PacketHandler>> packetHandlerRegistry = HashBiMap.create();

    public void registerPacket(Class<? extends Packet> clazz, int identifier) {
        packetRegistry.put(identifier, clazz);
    }

    public void registerHandlerForPacket(Class<? extends Packet> clazz, Class<? extends PacketHandler> handler) {
        packetHandlerRegistry.put(clazz, handler);
    }

    public Class<? extends PacketHandler> getHandlerForPacketClass(Class<? extends Packet> clazz) {
        return packetHandlerRegistry.get(clazz);
    }

    public int getIdentifierByClass(Class<? extends Packet> clazz) {
        return packetRegistry.inverse().get(clazz);
    }

    public Class<? extends Packet> getClassByIdentifier(int identifier) {
        return packetRegistry.get(identifier);
    }
}
