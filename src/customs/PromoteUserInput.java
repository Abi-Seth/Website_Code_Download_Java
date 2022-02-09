package customs;

import java.util.Scanner;

public class PromoteUserInput {
    Scanner scan = new Scanner(System.in);

    public int promoteUserInt(String msg) {
        System.out.print(msg);
        int option = scan.nextInt();
        return option;
    }

    public String promoteUserString(String msg) {
        System.out.print(msg);
        String userinput = scan.nextLine();
        return userinput;
    }
}
