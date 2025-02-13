package byteArray_stream_convert_image_to_byte_array;


import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        File inputFile = new File("src/main/java/byteArray_stream_convert_image_to_byte_array/sampleimg.jpg");
        File outputFile = new File("src/main/java/byteArray_stream_convert_image_to_byte_array/copy_image.jpg");

        try (FileInputStream fis = new FileInputStream(inputFile);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageData = baos.toByteArray();
            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
                 FileOutputStream fos = new FileOutputStream(outputFile)) {
                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }
            System.out.println("Image copied successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
