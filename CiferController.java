import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CiferController {


    public static void main(String[] args) throws FileNotFoundException {
        CiferMethods ciferMethods = new CiferMethods();
        System.out.println("Добро пожаловать!");
        System.out.println(
                "0 - Выход\n" +
                        "1 - Зашифровать фаил\n" +
                        "2 - Расшифровать фаил\n" +
                        "3 - Расшифровка методом BruteForce\n"

        );

        while (true) {
            Scanner sc = new Scanner(System.in);
            int userChoise = sc.nextInt();
            switch (userChoise) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    System.out.println("Введите ключ");
                    ciferMethods.runEncrypt(new FileReader("input.txt"), sc.nextInt());
                    System.out.println("Фаил зашифрован, смотри 'output.txt'");
                }
                case 2 -> {
                    System.out.println("Введите ключ");
                    ciferMethods.runDecrypt(new FileReader("output.txt"), sc.nextInt());
                    System.out.println("Фаил дешифрован, смотри 'output-decrypt.txt'");
                }
                case 3 -> {
                    ciferMethods.runBrute();
                    System.out.println("Фаил дешифрован методом Bruteforce, смотри 'brute.txt'");
                }

            }
        }
    }
}
