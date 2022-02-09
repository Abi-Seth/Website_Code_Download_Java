package customs;

public class ShowOptions<K> {
    public int generateOptions() {
        System.out.println("What do you want to do:");
        System.out.println("\t1. Clone a website");
        System.out.println("\t0. Exit");
        PromoteUserInput promoteInput = new PromoteUserInput();
        int promotevalue = promoteInput.promoteUserInt("Enter option: ");
        return promotevalue;
    }
}
