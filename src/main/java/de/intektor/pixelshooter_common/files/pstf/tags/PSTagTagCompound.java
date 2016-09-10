package de.intektor.pixelshooter_common.files.pstf.tags;

import de.intektor.pixelshooter_common.files.pstf.PSTagBase;
import de.intektor.pixelshooter_common.files.pstf.PSTagCompound;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Intektor
 */
public class PSTagTagCompound extends PSTagBase<PSTagCompound> {

    public PSTagTagCompound(String key) {
        super(key);
        value = new PSTagCompound();
    }

    @Override
    public void writeToFile(DataOutputStream out) throws IOException {
        value.writeToStream(out);
    }

    @Override
    public void readFromFile(DataInputStream in) throws IOException {
        value = new PSTagCompound();
        value.readFromStream(in);
    }
}
