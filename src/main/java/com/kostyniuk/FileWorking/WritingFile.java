package com.kostyniuk.FileWorking;
import java.io.FileWriter;

public class WritingFile {


	public  static void writeToFile( char[] charText, String filepath) {
		try (FileWriter fileWriter = new FileWriter(filepath)) {
			for (int i = 0; i < charText.length; i++) {
				fileWriter.write(charText[i]);
			}
			System.out.println("Файл успішно створено");
		}

		catch (Exception e){
			throw new RuntimeException("Помилка запису");
		}
	}

}
