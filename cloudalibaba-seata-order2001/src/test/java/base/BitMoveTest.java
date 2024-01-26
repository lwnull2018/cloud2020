package base;

/**
 * 位移操作示例
 */
public class BitMoveTest {

    public static void main(String[] args) {
        int i = -1;
        System.out.println("Before << , i's value is " + i);
        System.out.println("i's binary string is " + Integer.toBinaryString(i));
        i <<= 10;
        System.out.println("After << , i's value is " + i);
        System.out.println("i's binary string is " + Integer.toBinaryString(i));
    }

}
