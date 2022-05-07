package Cryptoanalizer;

import java.io.IOException;
import java.util.Scanner;

public class Cryptoanalizer {
    public static void main(String[] args) throws IOException {
        boolean isWorked = true;
        while (isWorked) {
            System.out.println("Здравствуйте");
            System.out.println("Меня зовут JavaRush, я лучший в критографии");
            System.out.println("1. Я умею зашивровывать текст методом Цезаря");
            System.out.println("2. Я умею расшифровывать текст методом Цезаря");
            System.out.println("3. Я умею взламывать зашифрованный текст методом Цезаря");
            System.out.println("4. Выйти из программы");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите номер пункта для начало работы со мной!");
            int programNumber = scanner.nextInt();
            if (programNumber > 0 && programNumber < 5) {
                System.out.printf("Вы выбрали программу %d", programNumber);
                System.out.println("");
                System.out.println("Ответьте на несколько уточняющих вопросов и я все сделаю");
                switch (programNumber) {
                    case 1:
                        Encryptor.encrypt();
                        break;
                    case 2:
                        Decoder.decoder();
                        break;
                    case 3:
                        Hacking.hacking();
                        break;
                    case 4:
                        isWorked = false;
                        System.out.println("Вы закрыли программу! Всего доброго!");
                        break;
                }
            } else {
                System.out.println("Запустите программу заново");
                System.out.println("И введите число от 1 до 3");
            }
        }
    }
}






