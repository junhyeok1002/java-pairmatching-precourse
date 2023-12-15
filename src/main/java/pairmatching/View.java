package pairmatching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class View {
    public static List<String> FileReader(String name){
        List<String> names = new ArrayList<>();
        String fileName = "./src/main/resources/" + name;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            // 파일에서 한 줄씩 읽어오기
            while ((line = reader.readLine()) != null) {
                names.add(line);
            }
        } catch (IOException e) {
            System.err.println("파일 읽기 중 오류가 발생했습니다: " + e.getMessage());
        }
        return names;
    }
}
