import java.util.Scanner;
import java.util.ArrayList;

public class listmenu {
    public static void main(String[] args) {
        boolean done = false;
        Scanner pipe = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        do {
            String menu = safeinput.getRegExString(pipe,
                    "Enter a command to put into the list [A = add] [D = delete] [I = insert] [P = print] [Q = quit] ",
                    "[AaDdIiPpQq]");

            switch (menu.toUpperCase()) {
                case "A":
                    addItem(pipe, list);
                    break;
                case "D":
                    deleteItem(pipe, list);
                    break;
                case "I":
                    insertItem(pipe, list);
                    break;
                case "P":
                    printList(list);
                    break;
                case "Q":
                    done = quitProgram(pipe);
                    break;
            }

            System.out.println("List is: " + list);

        } while (!done);
    }


    public static void addItem(Scanner pipe, ArrayList<String> list) {
        String add = safeinput.getNonZeroLenString(pipe, "Enter a string to add to the list");
        list.add(add);
    }


    public static void deleteItem(Scanner pipe, ArrayList<String> list) {
        if (list.size() == 0) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        displayIndexedList(list);
        int delete = safeinput.getRangedInt(pipe,
                "Enter the index of the string to delete",
                0, list.size() - 1);
        list.remove(delete);
    }


    public static void insertItem(Scanner pipe, ArrayList<String> list) {
        if (list.size() == 0) {
            System.out.println("List is empty. Inserting at index 0.");
            String insertString = safeinput.getNonZeroLenString(pipe, "Enter a string to insert");
            list.add(insertString);
            return;
        }

        displayIndexedList(list);
        int insertIndex = safeinput.getRangedInt(pipe,
                "Enter the index of the string to insert",
                0, list.size() - 1);

        String insertString = safeinput.getNonZeroLenString(pipe, "Enter a string to insert into the list");
        list.add(insertIndex, insertString);
    }


    public static void printList(ArrayList<String> list) {
        System.out.println("List is: " + list);
    }


    public static boolean quitProgram(Scanner pipe) {
        boolean confirm = safeinput.getYNConfirm(pipe, "Are you sure you want to quit?");
        return confirm;
    }


    public static void displayIndexedList(ArrayList<String> list) {
        System.out.println("List is: " + list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ": " + list.get(i));
        }
    }
}