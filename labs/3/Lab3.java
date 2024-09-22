import java.util.*;

class Lab3 {
    public static void main (String[] args) {
        int     inputInt;
        boolean bkeepRunning = true;

        Scanner sc   = new Scanner(System.in);
        Quiz    quiz = new Quiz();

        while (bkeepRunning) {
            System.out.println("What would you like to do?");
            System.out.println("1. Add a question to the quiz");
            System.out.println("2. Remove a question from the quiz");
            System.out.println("3. Modify a question in the quiz");
            System.out.println("4. Take the quiz");
            System.out.println("5. Quit");

            inputInt = sc.nextInt();
            System.out.println("");

            switch(inputInt) {
                case 1: quiz.add_question();    break;
                case 2: quiz.remove_question(); break;
                case 3: quiz.modify_question(); break;
                case 4: quiz.give_quiz();       break;
                case 5: bkeepRunning = false;   break;
            }
        }
        sc.close();
    }
}

class Quiz {
    String sAnswer, sQuestion;
    int    iDifficulty;
    ArrayList<Question> questions = new ArrayList<Question>();
    Scanner sc = new Scanner(System.in);

    void add_question() {
        System.out.println("What is the question Text?");
        sQuestion = sc.next();

        System.out.println("What is the answer?");
        sAnswer = sc.next();

        System.out.println("How Difficult (1-3)?");
        iDifficulty = sc.nextInt();
        Question question = new Question(sAnswer, sQuestion, iDifficulty);
        questions.add(question);
    }
    void remove_question() {
        System.out.println("Choose the question to remove?");
        for (int i = 0; i < questions.size(); i++) {
            System.out.println(i + ". " + questions.get(i).question());

        }
        int removeId = sc.nextInt();
        if (removeId <= questions.size()) {
            questions.remove(removeId);
        }
        System.out.println("");
    }
    void modify_question() {
        System.out.println("Choose the question to modify?");
        for (int i = 0; i < questions.size(); i++) {
            System.out.println(i + ". " + questions.get(i).question());

        }
        int modify = sc.nextInt();
        if (modify <= questions.size()) {
            questions.remove(modify);
            System.out.println("What is the question Text?");
            sQuestion = sc.next();

            System.out.println("What is the answer?");
            sAnswer = sc.next();

            System.out.println("How Difficult (1-3)?");
            iDifficulty = sc.nextInt();

            Question question = new Question(sAnswer, sQuestion, iDifficulty);
            questions.add(question);
        }
    }
    void give_quiz() {
        for (Question singleQuestion: questions) {
            System.out.println(singleQuestion.question());
            String answer = sc.next();
            System.out.println((singleQuestion.answer().equals(answer) ? "Correct" : "Incorrect"));
        }
    }
}

class Question {
    private        int    difficulty;
    private        String answer;
    private        String question;

    Question (String answer, String question, int difficulty) {
        this.answer     = answer;
        this.question   = question;
        this.difficulty = difficulty;
    }

    void answer    (String answer)   { this.answer = answer;         }
    void question  (String question) { this.question = question;     }
    void difficulty(int difficulty)  { this.difficulty = difficulty; }

    String answer    () { return this.answer;     }
    String question  () { return this.question;   }
    int    difficulty() { return this.difficulty; }
}