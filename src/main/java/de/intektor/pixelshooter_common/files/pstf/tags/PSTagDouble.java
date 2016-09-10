package de.intektor.pixelshooter_common.files.pstf.tags;

import de.intektor.pixelshooter_common.files.pstf.PSTagBase;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Intektor
 */
public class PSTagDouble extends PSTagBase<Double> {

    public PSTagDouble(String key) {
        super(key);
        value = 0D;
    }

    @Override
    public void writeToFile(DataOutputStream out) throws IOException {
        out.writeDouble(value);
    }

    @Override
    public void readFromFile(DataInputStream in) throws IOException {
        value = in.readDouble();
    }
}
