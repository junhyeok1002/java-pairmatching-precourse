package pairmatching;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String fileName = "./src/main/resources/backend-crew.md";
        List<String> names = View.FileReader("backend-crew.md");
        for (String name : names){
            System.out.println(name);
        }

        int isQuit = 0;

        while(isQuit == 0){
            isQuit = View.SelectMenu();
        }


    }
}
