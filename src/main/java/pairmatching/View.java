package pairmatching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class View {
    public static List<String> FileReader(String name) {
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

    public static Integer SelectMenu() {
        System.out.println("기능을 선택하세요.\n" + "1. 페어 매칭\n" + "2. 페어 조회\n" + "3. 페어 초기화\n" + "Q. 종료");
        String input = Console.readLine();

        if (Objects.equals(input, "1")) {
            System.out.println("페어 매칭");
            return 0;
        }

        if (Objects.equals(input, "2")) {
            System.out.println("페어 조회");
            return 0;
        }

        if (Objects.equals(input, "3")) {
            System.out.println("페어 초기화");
            return 0;
        }

        if (Objects.equals(input, "Q")) {
            System.out.println("종료");
            return 1;
        }

        // 나머지의 경우
        try {
            throw new IllegalArgumentException("잘못된 입력 값입니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 입력 값입니다. 1,2,3,Q 중에서 입력해주십시오.");
            return SelectMenu();
        }
    }
}
