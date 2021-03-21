package ru.itsector;

import java.util.Arrays;
import java.util.Scanner;

public class rockPaperScissors {
    static int yourScore = 0;
    static int computerScore = 0;

    public static void main(String[] args) {
        System.out.println("Игра \"Камень, Ножницы, Бумага\"");
        rockPaperScissors.game();
        System.out.println();
        System.out.println("Сыграть еще раз? (нажмите \"y\" или \"да\" чтобы продолжить или любую клавишу, чтобы прекратить");
        Scanner scanner = new Scanner(System.in);
        String keyIn = scanner.nextLine();
        while (keyIn.equals("y") | keyIn.equals("да")) {
            rockPaperScissors.game();
            System.out.println();
            System.out.println("Сыграть еще раз? (нажмите y/n для выбора ответа \"Да\" или \"Нет\")");
            keyIn = scanner.nextLine();
        }
        System.out.println("Таблица счета");
        System.out.format("%16s%4d%16s%4d", "Игрок", yourScore, "Компьютер", computerScore);
    }

    public static void game() {
        String[] variants = new String[]{"Камень", "Ножницы", "Бумага"};
        System.out.println("Введи свой вариант");
        Scanner scanner = new Scanner(System.in);
        String keyIn = scanner.nextLine();
        System.out.println(Arrays.asList(variants).contains(keyIn));
        while (!Arrays.asList(variants).contains(keyIn)) {
            System.out.println("В игре нет такого варианта \"" + keyIn + "\". Введите новое значение:");
            keyIn = scanner.nextLine();
        }

        System.out.println("Ваш варинт: " + keyIn);
        String computer = randomVariant();
        System.out.println("Вариант оппонента: " + computer);
        if (keyIn.equals(computer)) {
            System.out.println("Ничья!");
        }
        if (keyIn.equals("Камень") & computer.equals("Ножницы")) {
            System.out.println("Ты победил");
            yourScore += 1;
        }
        if (keyIn.equals("Камень") & computer.equals("Бумага")) {
            System.out.println("Ты проиграл");
            computerScore += 1;
        }
        if (keyIn.equals("Ножницы") & computer.equals("Бумага")) {
            System.out.println("Ты победил");
            yourScore += 1;
        }
        if (keyIn.equals("Ножницы") & computer.equals("Камень")) {
            System.out.println("Ты проиграл");
            computerScore += 1;
        }
        if (keyIn.equals("Бумага") & computer.equals("Камень")) {
            System.out.println("Ты победил");
            yourScore += 1;
        }
        if (keyIn.equals("Бумага") & computer.equals("Ножницы")) {
            System.out.println("Ты проиграл");
            computerScore += 1;
        }
        System.out.format("%16s%4d%10s%4d", "Твой счет: ", yourScore, ", Счет компьютера: ", computerScore);
        System.out.println();
    }

    public static String randomVariant() {
        String[] randomVariant = new String[]{"Камень", "Ножницы", "Бумага"};
        int n = (int) Math.floor(Math.random() * randomVariant.length);
        return randomVariant[n];
    }
}
