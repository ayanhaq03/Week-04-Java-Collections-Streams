package buffered_stream_efficient_file_copy;


import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        File source = new File("src/main/java/buffered_stream_efficient_file_copy/largefile.txt");
        File destination = new File("src/main/java/buffered_stream_efficient_file_copy/copy_largefile.txt");

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096];
            long startTime = System.nanoTime();

            int bytesRead;
            while ((bytesRead = bis.read()) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            long endTime = System.nanoTime();
            System.out.println("File copied using Buffered Streams in: " + (endTime - startTime) / 1_000_000 + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
