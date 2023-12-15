package pairmatching;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
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
            View.pair_maching_print();
            return pair_check(system);
        }

        if (Objects.equals(input, "3")) {
            return system.Pair_Reset();
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

    private static int pair_check(Pair_Matching_DB system) {
        // 입력함수 구현하기
        One_Pair_Maching searched;
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
            searched = system.search_info(course, level, mission);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 매칭 이력이 없습니다.");
            View.pair_maching_print();
            return pair_maching(system);
        }catch (NullPointerException e){
            View.pair_maching_print();
            return pair_maching(system);
        }


        // 가져와서 프린트
        List<List<String>> resultList = new ArrayList<>();
        resultList = searched.getMission_pair().get(mission);
        View.pair_maching_result(resultList);
        return 0;
    }


    private static int pair_maching(Pair_Matching_DB system){
        // 입력함수 구현하기
        One_Pair_Maching searched;
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
            searched = system.search(course, level, mission);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 현재 페어 매칭단계 : 잘못된 입력입니다.");
            View.pair_maching_print();
            return pair_maching(system);
        }catch (NullPointerException e){
            View.pair_maching_print();
            return pair_maching(system);
        }
        return shuffle_maching(course, mission, searched, system);
    }

    private static int shuffle_maching(String course, String mission, One_Pair_Maching searched, Pair_Matching_DB system) {
        // 페이매칭 결과
        List<String> names = new ArrayList<>();
        if (course.equals("백엔드")){
            names = View.FileReader("backend-crew.md");
        }
        if (course.equals("프론트엔드")){
            names = View.FileReader("frontend-crew.md");
        }

        System.out.println();
        List<String> shuffledCrew = Randoms.shuffle(names);

        List<List<String>> resultList = new ArrayList<>();
        // 원본 리스트를 2개씩 끊어서 새로운 리스트에 추가
        for (int i = 0; i < shuffledCrew.size(); i += 2) {
            List<String> temp = new ArrayList<>();
            temp.add(shuffledCrew.get(i));
            temp.add(shuffledCrew.get(i+1));

            if (i+3 == shuffledCrew.size()){
                temp.add(shuffledCrew.get(i+2));
                resultList.add(temp);
                break;
            }
            resultList.add(temp);
        }

        View.pair_maching_result(resultList);
        searched.setMission_pair(mission,resultList);
        return 0;
    }
}
