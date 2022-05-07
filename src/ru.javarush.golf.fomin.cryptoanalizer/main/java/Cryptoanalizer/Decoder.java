package Cryptoanalizer;

public class Decoder {
    public static void decoder(){
        KeyCrypt keyCryptDecoder = new KeyCrypt();
        FilePath filePath = new FilePath();
        СodingFileImputStream.codingFileImputStream(filePath,"decoder", keyCryptDecoder.getKeyCrypt());
        System.out.println("Готово! Возвращайся если понадобится помощь в криптографии!");
    }
}

