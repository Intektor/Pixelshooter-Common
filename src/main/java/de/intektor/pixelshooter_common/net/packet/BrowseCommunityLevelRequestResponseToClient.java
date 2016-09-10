package de.intektor.pixelshooter_common.net.packet;

import de.intektor.pixelshooter_common.files.pstf.PSTagCompound;
import de.intektor.pixelshooter_common.levels.BasicLevelInformation;
import de.intektor.pixelshooter_common.net.packet.BrowseCommunityLevelsLevelRequestToServer.Order;
import de.intektor.pixelshooter_common.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Intektor
 */
public class BrowseCommunityLevelRequestResponseToClient implements Packet {

    public List<BasicLevelInformation> levels = new ArrayList<BasicLevelInformation>();
    public Order order;
    public SupplyType supply;

    public BrowseCommunityLevelRequestResponseToClient(List<BasicLevelInformation> levels, Order order, SupplyType supply) {
        this.levels = levels;
        this.order = order;
        this.supply = supply;
    }

    public BrowseCommunityLevelRequestResponseToClient() {
    }

    @Override
    public void write(DataOutputStream out) throws IOException {
        out.writeInt(levels.size());
        for (BasicLevelInformation level : levels) {
            PSTagCompound tag = new PSTagCompound();
            level.writeToTag(tag);
            tag.writeToStream(out);
        }
        PSTagCompound orderTag = new PSTagCompound();
        order.writeToTag(orderTag);
        orderTag.writeToStream(out);
        out.writeInt(supply.ordinal());
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        int length = in.readInt();
        for (int i = 0; i < length; i++) {
            PSTagCompound tag = new PSTagCompound();
            tag.readFromStream(in);
            BasicLevelInformation info = new BasicLevelInformation();
            info.readFromTag(tag);
            levels.add(info);
        }
        PSTagCompound orderTag = new PSTagCompound();
        orderTag.readFromStream(in);
        order = new Order();
        order.readFromTag(orderTag);
        supply = SupplyType.values()[in.readInt()];
    }

    public enum SupplyType {
        LIMIT,
        MORE
    }
}
