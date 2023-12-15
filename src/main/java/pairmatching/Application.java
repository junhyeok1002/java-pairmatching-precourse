package pairmatching;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        String fileName = "./src/main/resources/backend-crew.md";
        FileReader("backend-crew.md");



        // TODO 구현 진행
    }
    public static void FileReader(String name){
        String fileName = "./src/main/resources/" + name;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            // 파일에서 한 줄씩 읽어오기
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("파일 읽기 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

}
