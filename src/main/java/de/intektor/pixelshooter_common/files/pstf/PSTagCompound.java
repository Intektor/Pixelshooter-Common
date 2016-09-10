package de.intektor.pixelshooter_common.files.pstf;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import de.intektor.pixelshooter_common.files.pstf.tags.*;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Intektor
 */
public class PSTagCompound {

    public static BiMap<Integer, Class<? extends PSTagBase>> registry = HashBiMap.create();
    public static BiMap<Class<? extends PSTagBase>, Class> objectMap = HashBiMap.create();
    public static Map<Class<? extends PSTagBase>, Constructor<? extends PSTagBase>> constructorMap = new HashMap<Class<? extends PSTagBase>, Constructor<? extends PSTagBase>>();

    public static void registerTagBase(Class<? extends PSTagBase> tagClass, Class typeClass) {
        registry.put(registry.size(), tagClass);
        objectMap.put(tagClass, typeClass);
        try {
            constructorMap.put(tagClass, tagClass.getConstructor(String.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static int getIdentifier(Class<? extends PSTagBase> clazz) {
        return registry.inverse().get(clazz);
    }

    public static Class<? extends PSTagBase> getClass(int identifier) {
        return registry.get(identifier);
    }

    static {
        registerTagBase(PSTagBoolean.class, Boolean.class);
        registerTagBase(PSTagByte.class, Byte.class);
        registerTagBase(PSTagShort.class, Short.class);
        registerTagBase(PSTagInteger.class, Integer.class);
        registerTagBase(PSTagFloat.class, Float.class);
        registerTagBase(PSTagLong.class, Long.class);
        registerTagBase(PSTagDouble.class, Double.class);
        registerTagBase(PSTagString.class, String.class);
        registerTagBase(PSTagTagCompound.class, PSTagCompound.class);
    }

    protected Map<String, PSTagBase> tags = new HashMap<String, PSTagBase>();

    public void writeToStream(DataOutputStream out) throws IOException {
        out.writeInt(tags.size());
        for (PSTagBase base : tags.values()) {
            assert base.key != null;
            out.writeInt(getIdentifier(base.getClass()));
            out.writeUTF(base.key);
            base.writeToFile(out);
        }
    }

    public void readFromStream(DataInputStream in) throws IOException {
        int tagSize = in.readInt();
        for (int i = 0; i < tagSize; i++) {
            Class<? extends PSTagBase> baseClass = getClass(in.readInt());
            try {
                Constructor<? extends PSTagBase> constructor = constructorMap.get(baseClass);
                PSTagBase base = constructor.newInstance(in.readUTF());
                base.readFromFile(in);
                tags.put(base.key, base);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected PSTagBase createTag(String key, Class type) {
        Class<? extends PSTagBase> baseClass = objectMap.inverse().get(type);
        try {
            Constructor<? extends PSTagBase> constructor = baseClass.getConstructor(String.class);
            return constructor.newInstance(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected <T> void setValue(String key, T value) {
        if (!tags.containsKey(key)) {
            PSTagBase tag = createTag(key, value.getClass());
            tag.setValue(value);
            tags.put(tag.key, tag);
        } else {
            tags.get(key).setValue(value);
        }
    }

    protected Object getValue(String key, Class type) {
        if (!tags.containsKey(key)) {
            PSTagBase tag = createTag(key, type);
            tags.put(key, tag);
            return tag.getValue();
        } else {
            return tags.get(key).getValue();
        }
    }

    public void setBoolean(String key, boolean value) {
        setValue(key, value);
    }

    public boolean getBoolean(String key) {
        return (Boolean) getValue(key, Boolean.class);
    }

    public void setByte(String key, byte value) {
        setValue(key, value);
    }

    public byte getByte(String key) {
        return (Byte) getValue(key, Byte.class);
    }

    public void setShort(String key, short value) {
        setValue(key, value);
    }

    public short getShort(String key) {
        return (Short) getValue(key, Short.class);
    }

    public void setInteger(String key, int value) {
        setValue(key, value);
    }

    public int getInteger(String key) {
        return (Integer) getValue(key, Integer.class);
    }

    public void setFloat(String key, float value) {
        setValue(key, value);
    }

    public float getFloat(String key) {
        return (Float) getValue(key, Float.class);
    }

    public void setLong(String key, long value) {
        setValue(key, value);
    }

    public long getLong(String key) {
        return (Long) getValue(key, Long.class);
    }

    public void setDouble(String key, double value) {
        setValue(key, value);
    }

    public double getDouble(String key) {
        return (Double) getValue(key, Double.class);
    }

    public void setString(String key, String value) {
        setValue(key, value);
    }

    public String getString(String key) {
        return (String) getValue(key, String.class);
    }

    public void setTag(String key, PSTagCompound value) {
        setValue(key, value);
    }

    public PSTagCompound getTag(String key) {
        return (PSTagCompound) getValue(key, PSTagCompound.class);
    }

    public PSTagBase getBase(String key) {
        return tags.get(key);
    }
}
