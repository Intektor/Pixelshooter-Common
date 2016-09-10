package de.intektor.pixelshooter_common.files.pstf.tags;

import de.intektor.pixelshooter_common.files.pstf.PSTagBase;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Intektor
 */
public class PSTagShort extends PSTagBase<Short> {

    public PSTagShort(String key) {
        super(key);
        value = 0;
    }

    @Override
    public void writeToFile(DataOutputStream out) throws IOException {
        out.writeShort(value);
    }

    @Override
    public void readFromFile(DataInputStream in) throws IOException {
        value = in.readShort();
    }
}
