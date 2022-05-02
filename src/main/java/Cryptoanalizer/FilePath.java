package Cryptanalysis13;

import java.util.Scanner;

public class FilePath {
    private String filePathInput;
    private String filePathOutput;
    private String filePathIn;
    private String filePathOut;

    public FilePath(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите полный URL файла который нужно обработать");
        if (scanner.hasNextLine()) {
            filePathIn = scanner.nextLine();
            System.out.println("А также ведите полный URL файла куда нужно сохранить информацию");
            filePathOut = scanner.nextLine();
            setFilePathInput(filePathIn);
            setFilePathOutput(filePathOut);
        } else System.out.println("Введите корректный URL");
    }

    public String getFilePathInput() {
        return filePathInput;
    }

    private void setFilePathInput(String filePathIn) {
        this.filePathInput = filePathIn;
    }

    public String getFilePathOutput() {
        return filePathOutput;
    }

    private void setFilePathOutput(String filePathOut) {
        this.filePathOutput = filePathOut;
    }
}
