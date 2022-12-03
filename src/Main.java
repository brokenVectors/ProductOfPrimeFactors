import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> decomposeIntoPrimeFactors(int n) {
        ArrayList<Integer> primeFactors = new ArrayList<>();
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                // If n is divisible by i...
                primeFactors.add(i);
                primeFactors.add(n / i);
                break;
            }
        }
        // Recursion
        for(int i = 0; i < primeFactors.size(); i++) {
            int factor = primeFactors.get(i);
            ArrayList<Integer> moreFactors = decomposeIntoPrimeFactors(factor);
            if(moreFactors.size() > 1) {
                // If factor wasn't prime and decomposition was doable...
                primeFactors.remove(i);
                for (Integer moreFactor : moreFactors) {
                    primeFactors.add(i, moreFactor);
                }
            }
        }
        // If prime:
        if(primeFactors.isEmpty()) primeFactors.add(n);
        return primeFactors;
    }
    public static void main(String[] args) {
        System.out.println(decomposeIntoPrimeFactors(999999));
    }
}
