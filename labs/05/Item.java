abstract class Item {
    private String title;
//Constructors
    Item ()             { this.title = "";    }
    Item (String title) { this.title = title; }
//Getters/Setters
    String getTitle ()             { return title;       }
    void   setTitle (String title) { this.title = title; }
    abstract String getListing();
//Methods
    public String toString() { return title; }
}