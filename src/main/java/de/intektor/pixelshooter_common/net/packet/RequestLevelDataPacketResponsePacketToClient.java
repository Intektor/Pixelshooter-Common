package de.intektor.pixelshooter_common.net.packet;

import de.intektor.pixelshooter_common.files.pstf.PSTagCompound;
import de.intektor.pixelshooter_common.levels.BasicLevelInformation;
import de.intektor.pixelshooter_common.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Intektor
 */
public class RequestLevelDataPacketResponsePacketToClient implements Packet {

    public BasicLevelInformation info;
    public String writtenInfo;
    public PSTagCompound worldTag;
    public boolean prevRated;
    public int ratedStars;

    public RequestLevelDataPacketResponsePacketToClient(BasicLevelInformation info, String writtenInfo, PSTagCompound worldTag, boolean prevRated, int ratedStars) {
        this.info = info;
        this.writtenInfo = writtenInfo;
        this.worldTag = worldTag;
        this.prevRated = prevRated;
        this.ratedStars = ratedStars;
    }

    public RequestLevelDataPacketResponsePacketToClient() {
    }

    @Override
    public void write(DataOutputStream out) throws IOException {
        PSTagCompound combinedTag = new PSTagCompound();
        PSTagCompound infoTag = new PSTagCompound();
        info.writeToTag(infoTag);
        combinedTag.setTag("infoTag", infoTag);
        combinedTag.setString("writtenInfo", writtenInfo);
        combinedTag.setTag("world_tag", worldTag);
        combinedTag.setBoolean("prevRated", prevRated);
        combinedTag.setInteger("ratedStars", ratedStars);
        combinedTag.writeToStream(out);
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        PSTagCompound combinedTag = new PSTagCompound();
        combinedTag.readFromStream(in);
        info = new BasicLevelInformation();
        info.readFromTag(combinedTag.getTag("infoTag"));
        writtenInfo = combinedTag.getString("writtenInfo");
        worldTag = combinedTag.getTag("world_tag");
        prevRated = combinedTag.getBoolean("prevRated");
        ratedStars = combinedTag.getInteger("ratedStars");
    }
}
