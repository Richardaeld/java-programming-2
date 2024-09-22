class Periodical extends Item {
    private int issueNum;
//Constructors
    Periodical () {}
    Periodical (String title, int issueNum) {
        super (title);
        this.issueNum = issueNum;
    }
//Getter/Setter
    int  getIssueNum ()             { return issueNum;          }
    void setIssueNum (int issueNum) { this.issueNum = issueNum; }
//Method
    String getListing() {
        return "Periodical Title - " + getTitle()    + "\n" +
                "Issue # - "         + getIssueNum() + "\n";
    }
}