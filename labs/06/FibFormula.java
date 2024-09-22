class FibFormula implements FindFib {
    public int calculateFib (int i) {
        double fib =   (Math.pow(((1 + Math.sqrt(5)) / 2), i)  - Math.pow(((1 - Math.sqrt(5)) / 2), i))
                     / Math.sqrt(5);
        return (int) fib;
    }
}
