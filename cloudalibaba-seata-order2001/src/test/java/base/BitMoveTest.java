package base;

/**
 * 移位操作示例
 */
public class BitMoveTest {

    public static void main(String[] args) {
//        test1();

//        test2();

//        test3();

//        test4();

//        test5();

//        test6();

//        test7();

//        test8();

//        test9();

        test10();
    }

    private static void test10() {
        byte i6 = -5;
        System.out.println("i6 binary string is " + Integer.toBinaryString(i6));
        //1000 0101 (原码)
        //1111 1010 (反码)
        //1111 1011 (补码)
    }

    private static void test9() {
        // float
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
        System.out.println("包装类：java.lang.Float");
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println();

        // double
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);
        System.out.println("包装类：java.lang.Double");
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println();

        // char
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
        System.out.println("包装类：java.lang.Character");
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("最小值：Character.MIN_VALUE="
                + (int) Character.MIN_VALUE);
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("最大值：Character.MAX_VALUE="
                + (int) Character.MAX_VALUE);

    }

    private static void test8() {
        int max = Integer.MAX_VALUE;
        System.out.println("max value is " + max);
        System.out.println("int max binary string is " + Integer.toBinaryString(max));
        int max1 = max + 1;
        System.out.println("max1 value is " + max1);
        System.out.println("int max1 binary string is " + Integer.toBinaryString(max1));
        long max2 = max + 1;
        System.out.println("long max2 value is " + max2);
        System.out.println("long max2 binary string is " + Long.toBinaryString(max2));
        long max3 = Long.valueOf(max) + 1;
        System.out.println("long max3 value is " + max3);
        System.out.println("long max3 binary string is " + Long.toBinaryString(max3));
    }

    private static void test7() {
        long i5 = -1;
        System.out.println("Before >>>, i5's value is " + i5);
        System.out.println("i5's binary string is " + Long.toBinaryString(i5));
        System.out.println("After >>> 63, i5's value is " + (i5 >>> 63));
        System.out.println("i5's binary string is " + Long.toBinaryString(i5));
        System.out.println("After >>> 64, i5's value is " + (i5 >>> 64));
        System.out.println("After >>> 124, i5's value is " + (i5 >>> 124));
    }

    /**
     * Java对移位操作的右操作符有特殊的处理，对int类型，只取其低5位(2^5)，也就是取rhs%32的结果。
     * 所以 i4>>>33 相当于i4>>>(33%32) 等同于 i4>>>1
     */
    private static void test6() {
        int i4 = -1;
        System.out.println("Before >>> , i4's value is " + i4);
        System.out.println("i4's binary string is " + Integer.toBinaryString(i4));
        System.out.println("After >>> 31 , i4's value is " + (i4 >>> 31));
        System.out.println("i4's binary string is " + Integer.toBinaryString(i4 >>> 31));
        System.out.println("After >>> 32 , i4's value is " + (i4 >>> 32));
        System.out.println("i4's binary string is " + Integer.toBinaryString(i4 >>> 32));
        System.out.println("After >>> 33 , i4's value is " + (i4 >>> 33));
        System.out.println("i4's binary string is " + Integer.toBinaryString(i4 >>> 33));

    }

    private static void test5() {
        byte b = -1;
        System.out.println("Before >> , b's value is " + b);
        System.out.println("b's binary string is " + Integer.toBinaryString(b));
        System.out.println("After >> , b's value is " + (b >>> 6)); // 未赋值，得到 67108863 ，说明确实是移位前先将-1转成int类型
        System.out.println("b's binary string is " + Integer.toBinaryString(b >>> 6));
    }

    private static void test4() {
        byte b = -1;
        System.out.println("Before >> , b's value is " + b);
        System.out.println("b's binary string is " + Integer.toBinaryString(b));
        b >>>= 6;
        System.out.println("After >> , b's value is " + b);
        System.out.println("b's binary string is " + Integer.toBinaryString(b));
    }

    /**
     * >>> 无符号右移操作
     */
    private static void test3() {
        int i3 = -4992;
        System.out.println("Before >>> , i3's value is " + i3);
        System.out.println("i3's binary string is " + Integer.toBinaryString(i3));
        i3 >>>= 10;
        System.out.println("After >>> , i3's value is " + i3);
        System.out.println("i3's binary string is " + Integer.toBinaryString(i3));
    }

    /**
     * >> 带符号右移操作
     */
    private static void test2() {
        // 对正数进行右移操作
        int i1 = 4992;
        System.out.println("Before >> , i1's value is " + i1);
        System.out.println("i1's binary string is " + Integer.toBinaryString(i1));

        i1 >>= 10;
        System.out.println("After >> , i1's value is " + i1);
        System.out.println("i1's binary string is " + Integer.toBinaryString(i1));

        // 对负数进行右移操作
        int i2 = -4992;
        System.out.println("Before >> , i2's value is " + i2);
        System.out.println("i2's binary string is " + Integer.toBinaryString(i2));

        i2 >>= 10;
        System.out.println("After >> , i2's value is " + i2);
        System.out.println("i2's binary string is " + Integer.toBinaryString(i2));
    }

    /**
     * << 左移操作
     */
    private static void test1() {
        int i = -1;
        System.out.println("Before << , i's value is " + i);
        System.out.println("i's binary string is " + Integer.toBinaryString(i));
        i <<= 10;
        System.out.println("After << , i's value is " + i);
        System.out.println("i's binary string is " + Integer.toBinaryString(i));
    }

}
