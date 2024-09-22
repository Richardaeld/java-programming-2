public class BlueRayDisk {
    public String title;
    public String director;
    public int    year;
    public double cost;

    BlueRayDisk (String title, String director, int year,double cost) {
        this.title    = title;
        this.director = director;
        this.year     = year;
        this.cost     = cost;
    }

    public String toString () {
        return "$"   + cost  +
                " "  + year  +
                " "  + title +
                ", " + director;
    }
}
