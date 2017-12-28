public class Program {
    public static void main(String[] args) {
        int[] list1 = { -20, -10, 0, 1,2,3,20,30 };
        int[] list2 = { -160, -150, -140, -90, -40, -20, -10, 30, 60, 80, 85, 90, 100 };
        int[] list3 = { -30, 0, 30 };
        
        System.out.printf("%d\n", ThreeSumQuadratic.countThreeSum(list3));
    }
}