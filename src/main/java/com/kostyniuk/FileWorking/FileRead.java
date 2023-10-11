package com.kostyniuk.FileWorking;

import java.io.*;

public class FileRead {
	private final String filepath;
	public FileRead(String filepath){
		this.filepath=filepath;
	}

	public char[] read() {
		try (FileReader fileReader = new FileReader(filepath)
		) {
			StringBuilder stringBuilder = new StringBuilder();
			int n;
			while ((n = fileReader.read()) != -1) {
				stringBuilder.append((char) n);
			}
			return stringBuilder.toString().toCharArray();

		} catch (Exception e) {
			throw new RuntimeException("Помилка при читанні");
		}

	}


}

