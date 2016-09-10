package de.intektor.pixelshooter_common.files.pstf.tags;

import de.intektor.pixelshooter_common.files.pstf.PSTagBase;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Intektor
 */
public class PSTagLong extends PSTagBase<Long> {

    public PSTagLong(String key) {
        super(key);
        value = 0L;
    }

    @Override
    public void writeToFile(DataOutputStream out) throws IOException {
        out.writeLong(value);
    }

    @Override
    public void readFromFile(DataInputStream in) throws IOException {
        value = in.readLong();
    }
}
