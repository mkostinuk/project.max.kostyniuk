package com.kostyniuk.Crypt;

import com.kostyniuk.FileWorking.FileRead;
import com.kostyniuk.FileWorking.WritingFile;

public class BRUTE_FORCE {
	private  String filepath;
	public BRUTE_FORCE(String filepath) {

		this.filepath = filepath;
	}


	public void bruteForceDecrypt() {
		FileRead fileRead = new FileRead(filepath);
		for (int key = 1; key <= 26; key++) {
			CaesarCipher decrypt = new CaesarCipher(fileRead.read(),key);
			char[] decryptedText = decrypt.decryptMessage();
			String newFilePlace = filepath.substring(0, filepath.indexOf('.'));
			String newFilePath = newFilePlace + "-" + key + "[DECRYPTED].txt";
			WritingFile.writeToFile(decryptedText, newFilePath);
		}
	}
}