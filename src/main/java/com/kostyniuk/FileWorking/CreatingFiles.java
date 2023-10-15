package com.kostyniuk.FileWorking;
public class CreatingFiles {
	public static String getFilePlaceEncrypted(String newFilePlace) {
		return newFilePlace + "[ENCRYPTED].txt";
	}

	public static String getFilePlaceDecrypted(String newFilePlace) {
		return newFilePlace + "[DECRYPTED].txt";
	}
	public static String getFilePlaceBruteForce(String newFilePlace){return newFilePlace + "[BRUTEFORCE].txt";}
}