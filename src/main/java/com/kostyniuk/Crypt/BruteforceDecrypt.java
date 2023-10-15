package com.kostyniuk.Crypt;
public class BruteforceDecrypt {
	private static final String alphabetEng = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private char [] ciphertext;
	public BruteforceDecrypt(char[] ciphertext){
		this.ciphertext=ciphertext;
	}
	public char[] bruteForceEng() {
		StringBuilder decryptedText = new StringBuilder();
		for (int i = 1; i <= 25; i++) {
			for (char c : ciphertext) {
				if (Character.isLetter(c)) {
					char base = Character.isUpperCase(c) ? 'A' : 'a';
					int charIndex = alphabetEng.indexOf(Character.toUpperCase(c));
					int decryptedIndex = (charIndex - i + 26) % 26;
					char decryptedChar = (char) (base + decryptedIndex);
					decryptedText.append(Character.isLowerCase(c) ? Character.toLowerCase(decryptedChar) : decryptedChar);
				} else {
					decryptedText.append(c);
				}
			}
		}
		return decryptedText.toString().toCharArray();
	}

	}
