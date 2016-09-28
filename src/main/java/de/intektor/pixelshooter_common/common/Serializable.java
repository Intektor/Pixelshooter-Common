package de.intektor.pixelshooter_common.common;

import de.intektor.pixelshooter_common.files.pstf.PSTagCompound;

/**
 * @author Intektor
 */
public interface Serializable {

    void writeToTag(PSTagCompound tag);

    void readFromTag(PSTagCompound tag);
}
