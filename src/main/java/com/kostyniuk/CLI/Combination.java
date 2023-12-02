package com.kostyniuk.CLI;

import com.kostyniuk.Crypt.BruteforceDecrypt;
import com.kostyniuk.Crypt.CaesarCipher;
import com.kostyniuk.FileWorking.CreatingFiles;
import com.kostyniuk.FileWorking.FileRead;
import com.kostyniuk.FileWorking.WritingFile;

import java.util.Scanner;

public class Combination {
    final private String command;
    final private String filepath;
    final private int key;


    public Combination(String args[]) {
        try {
            this.command = args[0];
            this.filepath = args[1];
            this.key = Integer.parseInt(args[2]);

        } catch (Exception e) {
            throw new RuntimeException("Аргументів не знайдено " + e + e.getStackTrace());
        }

    }

    public Combination() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, write command : ENCRYPT/DECRYPT/BRUTE_FORCE");
        this.command = scanner.nextLine();
        System.out.println("Please a way to file?");
        this.filepath = scanner.nextLine();
        System.out.println("Key?");
        this.key = scanner.nextInt();
    }

    public void connecting() {
        FileRead fileRead = new FileRead(filepath);
        String newFilePlace = filepath.substring(0, filepath.indexOf('.'));
        CaesarCipher defaultcrypt = new CaesarCipher(fileRead.read(), key);
        if ("ENCRYPT".equalsIgnoreCase(command)) {
            WritingFile.writeToFile(defaultcrypt.encryptMessage(), CreatingFiles.getFilePlaceEncrypted(newFilePlace));
        } else if ("DECRYPT".equalsIgnoreCase(command)) {
            WritingFile.writeToFile(defaultcrypt.decryptMessage(), CreatingFiles.getFilePlaceDecrypted(newFilePlace));

        } else if ("BRUTE_FORCE".equalsIgnoreCase(command)) {
            BruteforceDecrypt bruteforceDecrypt = new BruteforceDecrypt(fileRead.read());
            WritingFile.writeToFile(bruteforceDecrypt.bruteForceEng(), CreatingFiles.getFilePlaceBruteForce(newFilePlace));
        }
    }


}

