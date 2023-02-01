package stocker.storage;
import java.util.ArrayList;

public class ScrumCards {
    public static void scrum() {
        ArrayList<Double> scrumCards = new ArrayList<>();

        scrumCards.add(0.0);
        scrumCards.add(0.5);
        scrumCards.add(1.0);
        scrumCards.add(2.0);
        scrumCards.add(3.0);
        scrumCards.add(5.0);
        scrumCards.add(8.0);
        scrumCards.add(13.0);
        scrumCards.add(20.0);
        scrumCards.add(40.0);
        scrumCards.add(100.0);

        System.out.println("Scrum: " + scrumCards.get((int) (Math.random() * 100)%scrumCards.size()));
    }
}