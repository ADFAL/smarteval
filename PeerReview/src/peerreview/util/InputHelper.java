package peerreview.util;

import java.util.Scanner;

public class InputHelper {

    private static Scanner scanner =
            new Scanner(System.in);

    public static String lireString(
            String message
    ) {

        System.out.print(message);

        return scanner.nextLine();
    }

    public static int lireInt(
            String message
    ) {

        System.out.print(message);

        return Integer.parseInt(
                scanner.nextLine()
        );
    }
}