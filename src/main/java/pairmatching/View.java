package pairmatching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static String SelectMenu() {
        System.out.println("기능을 선택하세요.\n" + "1. 페어 매칭\n" + "2. 페어 조회\n" + "3. 페어 초기화\n" + "Q. 종료");
        String input = Console.readLine();
        return input;
    }
    public static void pair_maching_print(){
        System.out.println("\n#############################################\n"
                + "과정: 백엔드 | 프론트엔드\n"
                + "미션:\n"
                + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
                + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
                + "  - 레벨3: \n"
                + "  - 레벨4: 성능개선 | 배포\n"
                + "  - 레벨5: \n"
                + "############################################\n"
                + "과정, 레벨, 미션을 선택하세요.\n"
                + "ex) 백엔드, 레벨1, 자동차경주");
    }
}
