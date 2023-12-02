package com.kostyniuk.Crypt;

public class CaesarCipher {
    final private char[] charMessage;
    final private int key;

    public CaesarCipher(final char[] charMessage, final int key) {
        this.charMessage = charMessage;
        this.key = key;
    }

    public char[] encryptMessage() {
        char[] newCharMessage = charMessage;
        for (int i = 0; i < newCharMessage.length; i++) {
            if (Character.isLetter(newCharMessage[i])) {
                if (Character.isUpperCase(newCharMessage[i])) {
                    encryptUpperCase(newCharMessage, i);

                } else if (Character.isLowerCase(newCharMessage[i])) {
                    encryptLowerCase(newCharMessage, i);
                }

            }
        }
        return newCharMessage;
    }

    private void encryptUpperCase(char[] newCharMessage, int i) {
        if (newCharMessage[i] >= 'A' && newCharMessage[i] <= 'Z') {
            encryptor(newCharMessage, i, 'A', 'Z');
        }
        if (newCharMessage[i] >= 'А' && newCharMessage[i] <= 'Я') {
            encryptor(newCharMessage, i, 'А', 'Я');
        }
    }

    private void encryptLowerCase(char[] newCharMessage, int i) {
        if (newCharMessage[i] >= 'a' && newCharMessage[i] <= 'z') {
            encryptor(newCharMessage, i, 'a', 'z');
        }
        if (newCharMessage[i] >= 'а' && newCharMessage[i] <= 'я') {
            encryptor(newCharMessage, i, 'a', 'я');
        }
    }

    private void encryptor(char[] newCharMessage, int i, char start, char end) {
        char letter = newCharMessage[i];
        for (int j = 0; j < key; j++) {
            letter++;
            if (letter > end) {
                letter = start;
            }
        }
        newCharMessage[i] = letter;
    }

    public char[] decryptMessage() {
        char[] newCharMessage = charMessage;
        for (int i = 0; i < newCharMessage.length; i++) {
            if (Character.isLetter(newCharMessage[i])) {
                if (Character.isUpperCase(newCharMessage[i])) {
                    decryptUpperCase(newCharMessage, i);

                } else if (Character.isLowerCase(newCharMessage[i])) {
                    decryptLowerCase(newCharMessage, i);
                }
            }
        }
        return newCharMessage;
    }

    private void decryptUpperCase(char[] newCharMessage, int i) {
        if (newCharMessage[i] >= 'A' && newCharMessage[i] <= 'Z') {
            decode(newCharMessage, i, 'A', 'Z');
        }
        if (newCharMessage[i] >= 'А' && newCharMessage[i] <= 'Я') {
            decode(charMessage, i, 'А', 'Я');
        }
    }

    private void decryptLowerCase(char[] newCharMessage, int i) {
        if (newCharMessage[i] >= 'a' && newCharMessage[i] <= 'z') {
            decode(newCharMessage, i, 'a', 'z');
        }
        if (newCharMessage[i] >= 'а' && newCharMessage[i] <= 'я') {
            decode(newCharMessage, i, 'а', 'я');
        }
    }

    private void decode(char[] newCharMessage, int i, char start, char end) {
        char letter = newCharMessage[i];
        for (int j = 0; j < key; j++) {
            letter--;
            if (letter < start) {
                letter = end;
            }
        }

        newCharMessage[i] = letter;
    }

}
