package de.intektor.pixelshooter_common.files.pstf.tags;

import de.intektor.pixelshooter_common.files.pstf.PSTagBase;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Intektor
 */
public class PSTagBoolean extends PSTagBase<Boolean> {

    public PSTagBoolean(String key) {
        super(key);
        value = false;
    }

    @Override
    public void writeToFile(DataOutputStream out) throws IOException {
        out.writeBoolean(value);
    }

    @Override
    public void readFromFile(DataInputStream in) throws IOException {
        value = in.readBoolean();
    }
}
