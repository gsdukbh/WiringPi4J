package top.werls.pi4j;

import com.sun.jna.IntegerType;
public  class UnsignedInt extends IntegerType{

    public UnsignedInt(int size) {
        super(4, size, true);
    }
    public UnsignedInt() {
        this(0);
    }
}
