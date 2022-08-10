import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CiferController {


    public static void main(String[] args) throws FileNotFoundException {
//        try {
//            Files.createFile(Path.of("input.txt"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
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
        switch(userChoise)
        {
            case 0 -> {
                return;
            }
            case 1 -> {
                System.out.println("Введите ключ");
                ciferMethods.encryptText(new FileReader("input.txt"), sc.nextInt());
                System.out.println("Фаил зашифрован, смотри 'output.txt'");
            }
            case 2 ->{
                System.out.println("Введите ключ");
                ciferMethods.decryptText(new FileReader("output.txt"), sc.nextInt());
                System.out.println("Фаил дешифрован, смотри 'output-decrypt.txt'");
            }
            case 3 -> {ciferMethods.bruteForce();
                System.out.println("Фаил дешифрован методом Bruteforce, смотри 'brute.txt'");
            }

        } }

//        while (true) {
//            Scanner sc = new Scanner(System.in);
//            int userC = sc.nextInt();
//
//            switch(userC)
//            {
//                case 0 -> {
//                    return;
//                }
//                case 1 -> { Scanner sc1 = new Scanner(System.in);
//                    System.out.println("Введите ключ:");
//                    ciferMethods.runEncrypt((new FileReader("input.txt")),sc1.nextInt());
//                    System.out.println("Фаил зашифрован, смотри 'output.txt'");
//                }
//                case 2 ->{ Scanner sc2 = new Scanner(System.in);
//                    System.out.println("Введите ключ:");
//                    ciferMethods.runDecrypt(new FileReader("output.txt"),sc2.nextInt());
//                    System.out.println("Фаил дешифрован, смотри 'output-decrypt.txt'");
//                }
//                case 3 -> {ciferMethods.runBrute();
//                    System.out.println("Фаил дешифрован методом Bruteforce, смотри 'brute.txt'");
//                }
//
//            } }


//        CiferMethods ciferMethods = new CiferMethods();
//        ciferMethods.encryptText(new FileReader("input.txt"),500);
//       ciferMethods.decryptText(new FileReader("output.txt"),500);
//        ciferMethods.bruteForce();
    }
}
