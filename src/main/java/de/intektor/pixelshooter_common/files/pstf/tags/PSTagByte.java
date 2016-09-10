package de.intektor.pixelshooter_common.files.pstf.tags;

import de.intektor.pixelshooter_common.files.pstf.PSTagBase;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Intektor
 */
public class PSTagByte extends PSTagBase<Byte> {

    public PSTagByte(String key) {
        super(key);
        value = 0;
    }

    @Override
    public void writeToFile(DataOutputStream out) throws IOException {
        out.writeByte(value);
    }

    @Override
    public void readFromFile(DataInputStream in) throws IOException {
        value = in.readByte();
    }
}
