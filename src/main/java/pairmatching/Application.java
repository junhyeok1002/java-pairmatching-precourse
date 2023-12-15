package pairmatching;
import camp.nextstep.edu.missionutils.Console;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
//        List<String> names = View.FileReader("backend-crew.md");
//        for (String name : names){
//            System.out.println(name);
//        }
        Pair_Matching_DB system = new Pair_Matching_DB();

        String input;
        int isQuit = 0;

        while(isQuit != 1) {
            input = View.SelectMenu();
            isQuit = MenuOperation(input, system);
            System.out.println();
        }

    }
    private static int MenuOperation(String input, Pair_Matching_DB system) {
        if (Objects.equals(input, "1")) {
            View.pair_maching_print();
            return pair_maching(system);
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
            return 0;
        }
    }



    private static int pair_maching(Pair_Matching_DB system){
        // 입력함수 구현하기
        String input = Console.readLine();
        List<String> inputs = Arrays.asList(input.split(","));

        if (inputs.size() != 3){
            System.out.println("[ERROR] 3개가 입력되지 않았습니다");
            View.pair_maching_print();
            return pair_maching(system);
        }

        String course = inputs.get(0).trim();
        String level = inputs.get(1).trim();
        String mission = inputs.get(2).trim();

        try {
            One_Pair_Maching searched = system.search(course, level, mission);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 과정이나, 레벨, 미션이 잘못된 입력 되었습니다.");
            View.pair_maching_print();
            return pair_maching(system);
        }

        return 0;
    }
}
