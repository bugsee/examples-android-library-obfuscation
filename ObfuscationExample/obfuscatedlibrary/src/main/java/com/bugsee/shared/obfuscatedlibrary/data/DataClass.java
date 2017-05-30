package com.bugsee.shared.obfuscatedlibrary.data;

import com.bugsee.shared.obfuscatedlibrary.util.HelperClass;

/**
 * Created by denis.druzhinin, Bugsee Inc, <a href="https://www.bugsee.com">https://www.bugsee.com</a>
 */
public class DataClass {
    private final int count;
    private final String name;
    private final ExtendedInfo extendedInfo;
    private final Type type;

    public DataClass(int count, String name) {
        this.count = count;
        this.name = name;
        extendedInfo = new ExtendedInfo(name + "_" + HelperClass.getRandomInt());
        type = Type.Type1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataClass)) return false;

        DataClass dataClass = (DataClass)o;

        if (count != dataClass.count) return false;
        if (name != null ? !name.equals(dataClass.name) : dataClass.name != null) return false;
        if (extendedInfo != null ? !extendedInfo.equals(dataClass.extendedInfo) : dataClass.extendedInfo != null)
            return false;
        return type == dataClass.type;

    }

    @Override
    public int hashCode() {
        int result = count;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (extendedInfo != null ? extendedInfo.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    public enum Type {
        Type1,
        Type2
    }

    private static class ExtendedInfo {
        final String code;

        public ExtendedInfo(String code) {
            this.code = code;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ExtendedInfo)) return false;

            ExtendedInfo that = (ExtendedInfo)o;

            return code != null ? code.equals(that.code) : that.code == null;

        }

        @Override
        public int hashCode() {
            return code != null ? code.hashCode() : 0;
        }
    }
}
