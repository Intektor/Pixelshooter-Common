package de.intektor.pixelshooter_common.net.packet;

import de.intektor.pixelshooter_common.common.Serializable;
import de.intektor.pixelshooter_common.common.Version;
import de.intektor.pixelshooter_common.files.pstf.PSTagCompound;
import de.intektor.pixelshooter_common.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Intektor
 */
public class CampaignWorldsUpdateRequestResponseToClient implements Packet {

    public boolean update;
    public List<CampaignWorld> worlds = new ArrayList<CampaignWorld>();
    public Version newVersion;

    public CampaignWorldsUpdateRequestResponseToClient(List<CampaignWorld> worlds, boolean update, Version newVersion) {
        this.worlds = worlds;
        this.update = update;
        this.newVersion = newVersion;
    }

    public CampaignWorldsUpdateRequestResponseToClient() {
    }

    @Override
    public void write(DataOutputStream out) throws IOException {
        PSTagCompound tag = new PSTagCompound();
        tag.setBoolean("update", update);
        tag.setInteger("aow", worlds.size());
        for (int i = 0; i < worlds.size(); i++) {
            CampaignWorld world = worlds.get(i);
            PSTagCompound worldTag = new PSTagCompound();
            world.writeToTag(worldTag);
            tag.setTag("w" + i, worldTag);
        }
        PSTagCompound versionTag = new PSTagCompound();
        newVersion.writeToTag(versionTag);
        tag.setTag("versionTag", versionTag);
        tag.writeToStream(out);
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        PSTagCompound tag = new PSTagCompound();
        tag.readFromStream(in);
        update = tag.getBoolean("update");
        int aow = tag.getInteger("aow");
        for (int i = 0; i < aow; i++) {
            CampaignWorld world = new CampaignWorld();
            world.readFromTag(tag.getTag("w" + i));
            worlds.add(world);
        }
        newVersion = new Version();
        newVersion.readFromTag(tag.getTag("versionTag"));
    }

    public static class CampaignWorld implements Serializable {

        public List<PSTagCompound> levels = new ArrayList<PSTagCompound>();
        public int worldID;

        public CampaignWorld(List<PSTagCompound> levels, int worldID) {
            this.levels = levels;
        }

        public CampaignWorld() {
        }

        @Override
        public void writeToTag(PSTagCompound tag) {
            tag.setInteger("wID", worldID);
            tag.setInteger("aol", levels.size());
            for (int i = 0; i < levels.size(); i++) {
                PSTagCompound level = levels.get(i);
                tag.setTag("l" + i, level);
            }
        }

        @Override
        public void readFromTag(PSTagCompound tag) {
            worldID = tag.getInteger("wID");
            int aol = tag.getInteger("aol");
            for (int i = 0; i < aol; i++) {
                levels.add(tag.getTag("l" + i));
            }
        }
    }
}
