package com.zeroq6.java.algorithm.other.relation;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Triple;

/**
 * icgeass@hotmail.com
 * 2020/10/17 6:13 下午
 */
public class Relation {

    private static int VALUE_IN_CACHE = RelationType.ALL_NOT_ADD.getMask();

    public static void main(String[] args) {
        Triple<String, String, String> ab = Triple.of("1", "1,2", "2");
        Triple<String, String, String> ba = Triple.of("2", "2,1", "1");
        Relation relation = new Relation();
        // 获取
        System.out.println("==================获取==================");
        for (RelationType relationType : RelationType.values()) {
            System.out.println("当前关系: " + relationType);
            relation.resetValue(relationType.getMask());

            System.out.println(ab.getMiddle() + "\t" + relation.getRelation(ab.getLeft(), ab.getRight()));
            System.out.println("---");
            System.out.println(ba.getMiddle() + "\t" + relation.getRelation(ba.getLeft(), ba.getRight()));
        }
        System.out.println("==================添加==================");
        for (RelationType relationType : RelationType.values()) {
            for (RelationType toAddRelationType : RelationType.values()) {
                System.out.println("当前关系: " + relationType + ", 要添加的关系：" + toAddRelationType);
                relation.resetValue(relationType.getMask());
                relation.addRelation(toAddRelationType, ab.getLeft(), ab.getRight());
                System.out.println(ab.getMiddle() + "\t" + relation.getRelation(ab.getLeft(), ab.getRight()));
                // reset
                System.out.println("---");
                relation.resetValue(relationType.getMask());
                relation.addRelation(toAddRelationType, ba.getLeft(), ba.getRight());
                System.out.println(ba.getMiddle() + "\t" + relation.getRelation(ba.getLeft(), ba.getRight()));
            }
            System.out.println("---------------------");
        }
        System.out.println("==================删除==================");
        for (RelationType relationType : RelationType.values()) {
            for (RelationType toDeleteRelationType : RelationType.values()) {
                System.out.println("当前关系: " + relationType + ", 要删除的关系：" + toDeleteRelationType);
                relation.resetValue(relationType.getMask());
                relation.cancelRelation(toDeleteRelationType, ab.getLeft(), ab.getRight());
                System.out.println(ab.getMiddle() + "\t" + relation.getRelation(ab.getLeft(), ab.getRight()));
                // reset
                System.out.println("---");
                relation.resetValue(relationType.getMask());
                relation.cancelRelation(toDeleteRelationType, ba.getLeft(), ba.getRight());
                System.out.println(ba.getMiddle() + "\t" + relation.getRelation(ba.getLeft(), ba.getRight()));
            }
            System.out.println("---------------------");
        }

    }

    public RelationType getRelation(String a, String b) {
        // 假设a小于b，取出来直接返回，否则取相反
        int value = getValue(buildKey(a, b));
        RelationType result = RelationType.getRelation(value);
        return getFinalRelation(result, a, b);
    }

    public void cancelRelation(RelationType relationType, String a, String b) {
        relationType = getFinalRelation(relationType, a, b);
        String key = buildKey(a, b);
        int value = getValue(key);
        setValue(key, RelationType.cancelRelation(relationType, value));

    }

    public void addRelation(RelationType relationType, String a, String b) {
        relationType = getFinalRelation(relationType, a, b);
        String key = buildKey(a, b);
        int value = getValue(key);
        setValue(key, RelationType.addRelation(relationType, value));
    }


    /**
     * 小的排序到前面，1位表示a加b，0位表示b加a
     */
    private String buildKey(String a, String b) {
        final String prefix = "RelationType" ;
        if (isAB(a, b)) {
            return prefix + a + "_" + b;
        } else {
            return prefix + b + "_" + a;
        }
    }

    private RelationType getFinalRelation(RelationType relationType, String a, String b) {
        return isAB(a, b) ? relationType : RelationType.getOpposite(relationType);
    }


    private boolean isAB(String a, String b) {
        return a.compareTo(b) <= 0;
    }

    private int getValue(String key) {
        // 根据实际情况获得
        return VALUE_IN_CACHE;
    }

    private void setValue(String key, int value) {
        // 根据实际情况设置
        VALUE_IN_CACHE = value;
    }

    private void resetValue(int value) {
        // 根据实际情况设置
        VALUE_IN_CACHE = value;
    }

    // 


    public enum RelationType {


        A_ADD_B(0b10),
        B_ADD_A(0b01),
        ALL_ADD(0b11),
        ALL_NOT_ADD(0b00),

        ;

        private final int mask;

        RelationType(int mask) {
            this.mask = mask;
        }

        public int getMask() {
            return mask;
        }


        public static RelationType getOpposite(RelationType relationType) {
            if (null == relationType) {
                throw new RuntimeException("relationType can not be null");
            }
            if (relationType == RelationType.A_ADD_B) {
                return RelationType.B_ADD_A;
            } else if (relationType == RelationType.B_ADD_A) {
                return RelationType.A_ADD_B;
            } else if (relationType == RelationType.ALL_ADD) {
                return RelationType.ALL_ADD;
            } else if (relationType == RelationType.ALL_NOT_ADD) {
                return RelationType.ALL_NOT_ADD;
            }
            throw new RuntimeException(String.format("relationType %s is illegal", relationType));
        }

        public static RelationType getRelation(int value) {
            if (value < ALL_NOT_ADD.getMask() || value > ALL_ADD.getMask()) {
                throw new RuntimeException(String.format("value %s is illegal", value));
            }
            // value & mask == mask 操作只能取指定的位，获取全部的关系，value == mask判断
            for (RelationType relationType : RelationType.values()) {
                if (value == relationType.getMask()) {
                    return relationType;
                }
            }
            throw new RuntimeException(String.format("can not found relationType for value:%s", value));

        }

        public static int cancelRelation(RelationType relationType, int value) {
            // value其他位如果是0，异或掩码其他位0，结果0，再与，value其他位还是0--->value其他位不变，其他位关系不变
            // value其他位如果是1，异或掩码其他位0，结果1，再与，value其他位还是1--->value其他位不变，其他位关系不变
            // value掩码位如果是0，异或掩码位1，结果1，再与value掩码位0，value掩码位还是0--->value掩码位不变，没添加的关系还是没添加
            // value掩码位如果是1，异或掩码位1，结果0，再与value掩码位1，value掩码位变为0--->value掩码位变为0，已添加的关系被取消
            //
            // 另一种理解方式：
            // 由于value的0位被与了，所以0位还是0；
            // 对于value的1位，如果和掩码位对应，算出来0，最后为0，被取消；如果不和掩码位对应，算出来1，再与还是1，value其他1位不会取消
            return (value ^ relationType.getMask()) & value;
        }

        public static int addRelation(RelationType relationType, int value) {
            return relationType.getMask() | value;

        }


        @Override
        public String toString() {
            return this.name() + "(0b" + StringUtils.leftPad(Integer.toBinaryString(this.getMask()), 2, "0") + ")" ;
        }
    }


}
