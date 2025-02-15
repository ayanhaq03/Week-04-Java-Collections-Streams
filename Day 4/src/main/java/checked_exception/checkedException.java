package checked_exception;

import java.io.BufferedReader;
        import java.io.FileNotFoundException;
        import java.io.FileReader;
        import java.io.IOException;

public class checkedException {
    public static void main(String[] args) {
        String path="src/main/java/checked_exception/data.txt";
        try(BufferedReader b=new BufferedReader(new FileReader(path))){
            String line;
            while ((line=b.readLine())!=null){
                System.out.println(line);
            }
        }catch(FileNotFoundException e){
            System.out.println("file not found");
        }catch(IOException e){
            System.out.println("error occured");
        }


    }
}

