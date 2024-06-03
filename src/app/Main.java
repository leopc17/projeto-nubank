package app;

import utils.Menu;

import java.util.Scanner;

public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static final Scanner scString = new Scanner(System.in);

    public static void main(String[] args) {
        Menu.exibir();
        sc.close();
        scString.close();
    }
}