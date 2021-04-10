import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner inputUser = new Scanner(System.in);

        Boolean flag = true;

        System.out.println("Tentukan posisi awal robot: ");
        String start = inputUser.nextLine();

        while (flag){
            List<String> begin = new ArrayList(Arrays.asList(start.split(",")));

            if (!begin.get(0).toUpperCase().equals("E") && !begin.get(0).toUpperCase().equals("W") && !begin.get(0).toUpperCase().equals("S") && !begin.get(0).toUpperCase().equals("N")){
                System.out.println("WRONG INPUT\n " +
                        "Tentukan posisi awal robot: ");
                start = inputUser.nextLine();
            } else if (!isNumber(begin.get(1)) && !isNumber(begin.get(2))){
                System.out.println("WRONG INPUT\n " +
                        "Tentukan posisi awal robot: ");
                start = inputUser.nextLine();
            }
            else flag = false;
        }

        System.out.println("Input Perintah: ");
        String command = inputUser.nextLine();

        flag = true;

        while (flag){
            List<String> direction = new ArrayList(Arrays.asList(command.split("")));
            for (String d : direction){
                if (!d.toUpperCase().equals("A") && !d.toUpperCase().equals("R") && !d.toUpperCase().equals("L")){
                    System.out.println("WRONG INPUT \n" +
                            "Input Perintah: ");
                    command = inputUser.nextLine();
                } else flag = false;
            }
        }

        robot(start, command);

    }

    static void robot(String start, String command){
        String dir = String.valueOf(start.charAt(0));
        int x = (int) start.charAt(2);
        int y = (int) start.charAt(4);

        List<String> direction = new ArrayList(Arrays.asList(command.split("")));

        for (String d : direction){
            switch (d.toUpperCase()){
                case "A":
                    switch (dir) {
                        case "N":
                            y += 1;
                            break;
                        case "S":
                            y -= 1;
                            break;
                        case "E":
                            x += 1;
                            break;
                        default:
                            x -= 1;
                            break;
                    }
                    break;
                case "L":
                    switch (dir) {
                        case "N":
                            dir = "W";
                            break;
                        case "S":
                            dir = "E";
                            break;
                        case "E":
                            dir = "N";
                            break;
                        default:
                            dir = "S";
                            break;
                    }
                    break;
                case "R":
                    switch (dir) {
                        case "N":
                            dir = "E";
                            break;
                        case "S":
                            dir = "W";
                            break;
                        case "E":
                            dir = "S";
                            break;
                        default:
                            dir = "N";
                            break;
                    }
                    break;
            }
            System.out.println(d + " -> (" + dir + "," + x + "," + y + ")");
        }
    }

    public static boolean isNumber(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
