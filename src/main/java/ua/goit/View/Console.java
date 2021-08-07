package ua.goit.View;


import java.util.Scanner;

public class Console  implements View<String> {
    @Override
    public String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void write(String message) {
        System.out.println(message);

    }
}
