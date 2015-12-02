import java.io.File;
import java.util.Scanner;

public class AdventDay2 {

    public static void main(String args[]) throws Exception{

        Scanner scanFile = new Scanner(new File("paper.txt"));

        int paper_length = 0;
        int ribon_length = 0;

        while(scanFile.hasNext()){
            int length;
            int width;
            int height;

            String[] temp = scanFile.next().split("x");

            length = Integer.parseInt(temp[0]);
            width  = Integer.parseInt(temp[1]);
            height = Integer.parseInt(temp[2]);

            // TASK 1
            paper_length += ((2 * length * width) + (2 * width * height) + (2 * height * length));

            if(length >= width && length >= height){
                paper_length += width*height;
                ribon_length += 2*width + 2*height;
            }else if(width >= height && width >= length){
                paper_length += length*height;
                ribon_length += 2*length + 2*height;
            }else if(height >= length && height >= width){
                paper_length += length*width;
                ribon_length += 2*width + 2*length;
            }

            // TASK 2
            ribon_length += length * height * width;
        }
        
        System.out.println(String.format("The required paper length: %d", paper_length));
        System.out.println(String.format("The required ribon length: %d", ribon_length));
    }
}
