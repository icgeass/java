package com.zeroq6.java.corejava.reference;

/**
 * @author icgeass
 * @date 2018/7/9
 */
public class BigClass {

    public static BigClass[] refs = new BigClass[TestReference.BIG_CLASS_ARRAY_SIZE];

    public int id;

    public String remark;

    public byte[] data;

    public BigClass(int id, String remark) {
        if (id > refs.length - 1 || id < 0) {
            throw new IllegalArgumentException("id: " + id);
        }
        this.id = id;
        this.remark = remark;
        data = new byte[TestReference.BIG_CLASS_DATA_SIZE_IN_BYTE];
    }


    @Override
    protected void finalize() throws Throwable {
        if (TestReference.RESURRECT_IN_STRONG_REFERENCE) {
            refs[id] = this;
        }
        System.out.println(this + ".finalize()");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "---" + id + "---" + remark;
    }
}
