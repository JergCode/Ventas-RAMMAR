package com.rammar.interfaz;

public class Helpers {
    public static final int TABLE_WIDTH = 100;
    private static final String TITLE_FORMAT = "|%s|%n";

    public static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            System.out.println("No se pudo limpiar la pantalla");
        }
    }

    private static String centerMessage(String message) {
        StringBuilder centeredMessage = new StringBuilder(message);
        int padRight = (TABLE_WIDTH / 2) - (message.length() / 2) - 1;
        int padLeft = message.length() % 2 == 0 ? padRight : padRight - 1;
        centeredMessage.insert(0, " ".repeat(padLeft));
        centeredMessage.append(" ".repeat(padRight));
        return centeredMessage.toString();
    }

    public static void printTitleMessage(String message) {
        printLine();
        System.out.printf(TITLE_FORMAT, centerMessage(message));
        printLine();
    }

    public static void printLine() {
        String line = "+" + "-".repeat(TABLE_WIDTH - 2) + "+";
        System.out.println(line);
    }


}
