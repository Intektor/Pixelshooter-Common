package de.intektor.pixelshooter_common.net.packet;

import de.intektor.pixelshooter_common.files.pstf.PSTagCompound;
import de.intektor.pixelshooter_common.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Intektor
 */
public class BrowseCommunityLevelsLevelRequestToServer implements Packet {

    public Time time;
    public Type type;
    public Function function;
    public Order order;
    public PSTagCompound userData;

    public BrowseCommunityLevelsLevelRequestToServer() {
    }

    public BrowseCommunityLevelsLevelRequestToServer(Time time, Type type, Function function, Order order, PSTagCompound userData) {
        this.time = time;
        this.type = type;
        this.function = function;
        this.order = order;
        this.userData = userData;
    }

    @Override
    public void write(DataOutputStream out) throws IOException {
        out.writeInt(time.ordinal());
        out.writeInt(type.ordinal());
        out.writeInt(function.ordinal());
        PSTagCompound orderTag = new PSTagCompound();
        order.writeToTag(orderTag);
        orderTag.writeToStream(out);
        userData.writeToStream(out);
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        time = Time.values()[in.readInt()];
        type = Type.values()[in.readInt()];
        function = Function.values()[in.readInt()];
        PSTagCompound orderTag = new PSTagCompound();
        orderTag.readFromStream(in);
        order = new Order();
        order.readFromTag(orderTag);
        userData = new PSTagCompound();
        userData.readFromStream(in);
    }

    public static class Order {
        public OrderType type;
        public String lastOfficialID;
        public String search;
        public String userFilter;

        public Order() {
        }

        public Order(OrderType type, String lastOfficialID, String search, String userFilter) {
            this.type = type;
            this.lastOfficialID = lastOfficialID;
            this.search = search;
            this.userFilter = userFilter;
        }

        public enum OrderType {
            NEW,
            MORE
        }

        public void writeToTag(PSTagCompound tag) {
            tag.setInteger("type", type.ordinal());
            tag.setString("lastOfficialID", lastOfficialID);
            tag.setString("search", search);
            tag.setString("userFilter", userFilter);
        }

        public void readFromTag(PSTagCompound tag) {
            type = OrderType.values()[tag.getInteger("type")];
            lastOfficialID = tag.getString("lastOfficialID");
            search = tag.getString("search");
            userFilter = tag.getString("userFilter");
        }
    }

    public enum Function {
        NORMAL,
        SEARCH,
        USER_LEVEL
    }

    public enum Time {
        TODAY(86400000L),
        LAST_WEEK(604800000L),
        LAST_MONTH(18748800000L),
        LAST_YEAR(31536000000L),
        ANYTIME(Long.MAX_VALUE);

        long timeInMilliSec;

        Time(long timeInMilliSec) {
            this.timeInMilliSec = timeInMilliSec;
        }

        public long getTimeInMilliSec() {
            return timeInMilliSec;
        }
    }

    public enum Type {
        BEST_RATED,
        MOST_DOWNLOADS,
        PLAY_COUNT,
        NEWEST,
        OLDEST
    }
}
