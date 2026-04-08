
import  java.util.Scanner;
import java.util.ArrayList;

public class listmenu {
    public static void main(String[] args) {
        boolean done = false;
        Scanner pipe = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        do {
            String menu = safeinput.getRegExString(pipe, "Enter a command to put into the list [A = add] [D = delete] [I = insert] [P = print] [Q = quit] ", "[AaDdIiPpQq]");
            switch (menu.toUpperCase()) {
                case "A":
                    String add = safeinput.getNonZeroLenString(pipe, "Enter a string to add to the list");
                    list.add(add);
                    break;
                case "D":
                    System.out.println("List is: " + list);
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(i + ": " + list.get(i));
                    }

                    int delete = safeinput.getRangedInt(pipe, "Enter the index of the string to delete", 0, list.size() - 1);
                    list.remove(delete);
                    break;
                case "I":
                    System.out.println("List is: " + list);
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(i + ": " + list.get(i));
                    }

                    int insertIndex = safeinput.getRangedInt(pipe, "Enter the index of the string to insert", 0, list.size() - 1);
                    String insertString = safeinput.getNonZeroLenString(pipe, "Enter a string to insert into the list");
                    list.add(insertIndex, insertString);
                    break;
                case "P":
                    //System.out.println("List is: " + list);
                    break;

                case "Q":
                    boolean confirm = safeinput.getYNConfirm(pipe, "Are you sure you want to quit?");
                    if (confirm) {
                        done = true;

                    }

                    break;
            }
            System.out.println("List is: " + list);


        }while(!done);
    }
}
