package de.intektor.pixelshooter_common.files.pstf.tags;

import de.intektor.pixelshooter_common.files.pstf.PSTagBase;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Intektor
 */
public class PSTagInteger extends PSTagBase<Integer> {

    public PSTagInteger(String key) {
        super(key);
        value = 0;
    }

    @Override
    public void writeToFile(DataOutputStream out) throws IOException {
        out.writeInt(value);
    }

    @Override
    public void readFromFile(DataInputStream in) throws IOException {
        value = in.readInt();
    }
}
