class FibIteration implements FindFib {
    int total = 1;
    public int calculateFib (int i) {
        if (i == 1 || i ==2) return 1;
        return calculateFib(i - 1) + calculateFib(i - 2);
    }
}