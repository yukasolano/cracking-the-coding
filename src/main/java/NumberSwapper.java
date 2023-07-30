public class NumberSwapper {
    public static void main(String[] args) {
        Pair pair = new Pair(9, 4);
        System.out.println(pair);
        pair.swap();
        System.out.println(pair);
    }

}

class Pair {
    private Integer a;
    private Integer b;

    public Pair(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public void swap() {
        a = a - b;
        b = a + b;
        a = b - a;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}



