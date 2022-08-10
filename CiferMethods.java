import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CiferMethods {
    final private List<Character> alfabetArrayUp = new ArrayList<>();
    final private List<Character> alfabetArrayLow = new ArrayList<>();
    final private List<Character> alfabetArrayOther = new ArrayList<>();
    final private static Character[] alfabetrusUp = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И',
            'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х',
            'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ь', 'Ы', 'Э', 'Ю', 'Я'};
    final private static Character[] alfabetrusLow = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и',
            'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х',
            'ц', 'ч', 'ш', 'щ', 'ъ', 'ь', 'ы', 'э', 'ю', 'я'};
    final private static Character[] alfabetrusOther = {'.', ',', '"', ':', '-', '!', '?', ' ', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
            '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', '=', '`', '~', '/'};

    public void alfabetToArray() {
        alfabetArrayUp.addAll(Arrays.asList(alfabetrusUp));
        alfabetArrayLow.addAll(Arrays.asList(alfabetrusLow));
        alfabetArrayOther.addAll(Arrays.asList(alfabetrusOther));
    }

    public void runEncrypt(FileReader fileReader, int key) {
        CiferMethods ciferMethods = new CiferMethods();
        ciferMethods.encryptText(fileReader, key);
    }

    public void runDecrypt(FileReader fileReader, int key) {
        CiferMethods ciferMethods = new CiferMethods();
        ciferMethods.decryptText(fileReader, key);
    }

    public void runBrute() {
        CiferMethods ciferMethods = new CiferMethods();
        ciferMethods.bruteForce();
    }

    private void encryptText(FileReader fileReader, int key) {
        List<Character> textChars = new ArrayList<>();
        List<Character> cryptTextChars = new ArrayList<>();
        try (fileReader;
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                textChars.add((char) bufferedReader.read());


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (alfabetArrayUp.isEmpty()) {
            alfabetToArray();
        }
        for (Character textChar : textChars) {
            for (int j = 0; j < alfabetArrayLow.size(); j++) {
                if (textChar.equals(alfabetArrayUp.get(j))) {
                    cryptTextChars.add(alfabetArrayUp.get((j + key) % alfabetArrayUp.size()));
                } else if (textChar.equals(alfabetArrayLow.get(j))) {
                    cryptTextChars.add(alfabetArrayLow.get((j + key) % alfabetArrayLow.size()));
                } else if (textChar.equals(alfabetArrayOther.get(j))) {
                    cryptTextChars.add(alfabetArrayOther.get((j + key) % alfabetArrayOther.size()));
                }

            }
        }


        try (FileWriter fileWriter = new FileWriter("output.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Character cryptTextChar : cryptTextChars) {
                bufferedWriter.write(cryptTextChar);

            }
            bufferedWriter.flush();

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

    private void decryptText(FileReader fileReader, int key) {
        if (alfabetArrayUp.isEmpty()) {
            alfabetToArray();
        }
        List<Character> textChars = new ArrayList<>();
        List<Character> decryptTextChars = new ArrayList<>();
        try (fileReader;
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                textChars.add((char) bufferedReader.read());


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Character textChar : textChars) {
            for (int j = 0; j < alfabetArrayUp.size(); j++) {
                if (textChar.equals(alfabetArrayUp.get(j))) {
                    decryptTextChars.add(alfabetArrayUp.get((((j - key) % alfabetArrayUp.size())
                            + alfabetArrayUp.size()) % alfabetArrayUp.size()));
                } else if (textChar.equals(alfabetArrayLow.get(j))) {
                    decryptTextChars.add(alfabetArrayLow.get((((j - key) % alfabetArrayLow.size())
                            + alfabetArrayLow.size()) % alfabetArrayLow.size()));
                } else if (textChar.equals(alfabetArrayOther.get(j))) {
                    decryptTextChars.add(alfabetArrayOther.get((((j - key) % alfabetArrayOther.size())
                            + alfabetArrayOther.size()) % alfabetArrayOther.size()));
                }
            }
        }


        try (FileWriter fileWriter = new FileWriter("output-decrypt.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Character decryptTextChar : decryptTextChars) {
                bufferedWriter.write(decryptTextChar);

            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }


    }

    private void bruteForce() {
        if (alfabetArrayUp.isEmpty()) {
            alfabetToArray();
        }
        ArrayList<Character> arr = new ArrayList<>();
        ArrayList<Character> arrBrute = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("output.txt"))) {
            while (bufferedReader.ready()) {
                arr.add((char) bufferedReader.read());

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int key = 0; key < alfabetArrayUp.size(); key++) {
            arrBrute.clear();

            for (int i = 0; i < arr.size(); i++) {
                for (int j = 0; j < alfabetArrayUp.size(); j++) {
                    if (arr.get(i).equals(alfabetArrayUp.get(j))) {
                        arrBrute.add(alfabetArrayUp.get((((j - key) % alfabetArrayUp.size())
                                + alfabetArrayUp.size()) % alfabetArrayUp.size()));
                    } else if (arr.get(i).equals(alfabetArrayLow.get(j))) {
                        arrBrute.add(alfabetArrayLow.get((((j - key) % alfabetArrayLow.size())
                                + alfabetArrayLow.size()) % alfabetArrayLow.size()));
                    } else if (arr.get(i).equals(alfabetArrayOther.get(j))) {
                        arrBrute.add(alfabetArrayOther.get((((j - key) % alfabetArrayOther.size())
                                + alfabetArrayOther.size()) % alfabetArrayOther.size()));
                    }
                }
            }
            for (int j = 0, l = 1; l < arrBrute.size(); j++, l++) {
                if (arrBrute.get(j).equals(',') && arrBrute.get(l).equals(' ')) {
                    if (arrBrute.get((arrBrute.size() - 1)).equals('.')
                            || arrBrute.get((arrBrute.size() - 1)).equals('!')
                            || arrBrute.get((arrBrute.size() - 1)).equals('?')) {

                        System.out.println("Ключ равен " + key);

                        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("brute.txt"))) {

                            for (Character chars : arrBrute) {
                                bufferedWriter.write(chars);
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    }
                }
            }
        }
    }
}


