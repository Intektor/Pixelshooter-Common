package de.intektor.pixelshooter_common.files.pstf.tags;

import de.intektor.pixelshooter_common.files.pstf.PSTagBase;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Intektor
 */
public class PSTagFloat extends PSTagBase<Float> {

    public PSTagFloat(String key) {
        super(key);
        value = 0F;
    }

    @Override
    public void writeToFile(DataOutputStream out) throws IOException {
        out.writeFloat(value);
    }

    @Override
    public void readFromFile(DataInputStream in) throws IOException {
        value = in.readFloat();
    }
}
