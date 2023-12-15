package pairmatching;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Objects;

public class Pair_Matching_DB {
    private List<One_Pair_Maching> DB = new ArrayList<>();

    public Pair_Matching_DB(){
        DB.add(new One_Pair_Maching("백엔드","레벨1","자동차경주"));
        DB.add(new One_Pair_Maching("백엔드","레벨1","로또"));
        DB.add(new One_Pair_Maching("백엔드","레벨1","숫자야구게임"));
        DB.add(new One_Pair_Maching("백엔드","레벨2","장바구니"));
        DB.add(new One_Pair_Maching("백엔드","레벨2","결제"));
        DB.add(new One_Pair_Maching("백엔드","레벨2","지하철노선도"));
        DB.add(new One_Pair_Maching("백엔드","레벨3",""));
        DB.add(new One_Pair_Maching("백엔드","레벨4","성능개선"));
        DB.add(new One_Pair_Maching("백엔드","레벨4","배포"));
        DB.add(new One_Pair_Maching("백엔드","레벨5",""));

        DB.add(new One_Pair_Maching("프론트엔드","레벨1","자동차경주"));
        DB.add(new One_Pair_Maching("프론트엔드","레벨1","로또"));
        DB.add(new One_Pair_Maching("프론트엔드","레벨1","숫자야구게임"));
        DB.add(new One_Pair_Maching("프론트엔드","레벨2","장바구니"));
        DB.add(new One_Pair_Maching("프론트엔드","레벨2","결제"));
        DB.add(new One_Pair_Maching("프론트엔드","레벨2","지하철노선도"));
        DB.add(new One_Pair_Maching("프론트엔드","레벨3",""));
        DB.add(new One_Pair_Maching("프론트엔드","레벨4","성능개선"));
        DB.add(new One_Pair_Maching("프론트엔드","레벨4","배포"));
        DB.add(new One_Pair_Maching("프론트엔드","레벨5",""));
    }


    private void add(One_Pair_Maching input){
        DB.add(input);
    }
    public One_Pair_Maching search(String course, String level, String mission){
        course_valid(course);
        level_valid(level);

        for(One_Pair_Maching pair : DB){
            if (Objects.equals(course, pair.getCourse()) && Objects.equals(level, pair.getLevel())){
                System.out.println(course + level + mission);

                if(pair.getMission_pair().containsKey("")){
                    System.out.println("비어 있는 레벨");
                    return null;
                }
                if(pair.getMission_pair().containsKey(mission)){
                    System.out.println("있는 레벨");
                    return pair;
                }
                throw new IllegalArgumentException("없는 미션입니다만;;");
            }
        }
        return null;
    }
    private void course_valid(String course){
        List<String> okList = new ArrayList<>();
        okList.add("백엔드");
        okList.add("프론트엔드");

        if(!okList.contains(course)){
            throw new IllegalArgumentException("없는 과정입니다만;;");
        }
    }

    private void level_valid(String level){
        List<String> okList = new ArrayList<>();
        okList.add("레벨1");
        okList.add("레벨2");
        okList.add("레벨3");
        okList.add("레벨4");
        okList.add("레벨5");

        if(!okList.contains(level)){
            throw new IllegalArgumentException("없는 레벨입니다만;;");
        }
    }

}
