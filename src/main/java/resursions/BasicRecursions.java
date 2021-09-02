package resursions;

public class BasicRecursions {
    public static void main(String[] args) {
        System.out.println(myFactorial(5));
    }

    public static int myFactorial(int n) {
        System.out.println(n);
        if(n >= 1)
        {
            System.out.println("inside if - ");
            return myFactorial(n-1) * n;
        }
        else
            return 1;
    }
}
