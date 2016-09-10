package de.intektor.pixelshooter_common.levels;

import de.intektor.pixelshooter_common.files.pstf.PSTagCompound;

/**
 * @author Intektor
 */
public class BasicLevelInformation {

    public String levelName;
    public String authorName;
    public String officialID;
    public long timeUploaded;
    public long playCount;
    public long downloadCount;
    public float rating;
    public long timesRated;

    public BasicLevelInformation() {
    }

    public BasicLevelInformation(String levelName, String authorName, String officialID, long timeUploaded, long playCount, long downloadCount, float rating, long timeRated) {
        this.levelName = levelName;
        this.authorName = authorName;
        this.officialID = officialID;
        this.timeUploaded = timeUploaded;
        this.playCount = playCount;
        this.downloadCount = downloadCount;
        this.rating = rating;
        this.timesRated = timeRated;
    }

    public void writeToTag(PSTagCompound tag) {
        tag.setString("level_name", levelName);
        tag.setString("author_name", authorName);
        tag.setString("official_id", officialID);
        tag.setLong("time_uploaded", timeUploaded);
        tag.setLong("play_count", playCount);
        tag.setLong("download_count", downloadCount);
        tag.setFloat("rating", rating);
        tag.setLong("timesRated", timesRated);
    }

    public void readFromTag(PSTagCompound tag) {
        levelName = tag.getString("level_name");
        authorName = tag.getString("author_name");
        officialID = tag.getString("official_id");
        timeUploaded = tag.getLong("time_uploaded");
        playCount = tag.getLong("play_count");
        downloadCount = tag.getLong("download_count");
        rating = tag.getFloat("rating");
        timesRated = tag.getLong("timesRated");
    }
}
