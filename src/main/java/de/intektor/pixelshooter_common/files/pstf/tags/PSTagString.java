package de.intektor.pixelshooter_common.files.pstf.tags;

import de.intektor.pixelshooter_common.files.pstf.PSTagBase;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Intektor
 */
public class PSTagString extends PSTagBase<String> {

    public PSTagString(String key) {
        super(key);
        value = "";
    }

    @Override
    public void writeToFile(DataOutputStream out) throws IOException {
        out.writeUTF(value);
    }

    @Override
    public void readFromFile(DataInputStream in) throws IOException {
        value = in.readUTF();
    }
}
