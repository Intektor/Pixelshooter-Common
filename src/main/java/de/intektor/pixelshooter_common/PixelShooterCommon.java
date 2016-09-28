package de.intektor.pixelshooter_common;

import de.intektor.pixelshooter_common.net.packet.*;
import de.intektor.pixelshooter_common.packet.PacketRegistry;

/**
 * @author Intektor
 */
public class PixelShooterCommon {

    public static void init() {
        PacketRegistry.INSTANCE.registerPacket(PublishLevelPacketToServer.class, 0);
        PacketRegistry.INSTANCE.registerPacket(BadAccessTokenPacketToClient.class, 1);
        PacketRegistry.INSTANCE.registerPacket(InternalServerErrorWhilePublishingPacketToClient.class, 2);
        PacketRegistry.INSTANCE.registerPacket(LevelPublishedPacketToClient.class, 3);
        PacketRegistry.INSTANCE.registerPacket(BrowseCommunityLevelsLevelRequestToServer.class, 4);
        PacketRegistry.INSTANCE.registerPacket(BrowseCommunityLevelRequestResponseToClient.class, 5);
        PacketRegistry.INSTANCE.registerPacket(RequestLevelDataPacketToServer.class, 6);
        PacketRegistry.INSTANCE.registerPacket(RequestLevelDataPacketResponsePacketToClient.class, 7);
        PacketRegistry.INSTANCE.registerPacket(InternalServerErrorWhileGettingLevelDataPacketToClient.class, 8);
        PacketRegistry.INSTANCE.registerPacket(LevelActionPacketToServer.class, 9);
        PacketRegistry.INSTANCE.registerPacket(RatingPacketToServer.class, 10);
        PacketRegistry.INSTANCE.registerPacket(ServerShutdownPacketToClient.class, 11);
        PacketRegistry.INSTANCE.registerPacket(ClientVersionPacketToServer.class, 12);
        PacketRegistry.INSTANCE.registerPacket(UnsupportedClientVersionPacketToClient.class, 13);
        PacketRegistry.INSTANCE.registerPacket(CampaignWorldsUpdateRequestPacketToServer.class, 14);
        PacketRegistry.INSTANCE.registerPacket(CampaignWorldsUpdateRequestResponseToClient.class, 15);
    }
}
