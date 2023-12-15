package pairmatching;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class One_Pair_Maching {
    String course;
    String level;
    HashMap<String, List<List<String>>> mission_pair = new HashMap<>();

    public One_Pair_Maching(String course, String level, String mission){
        this.course = course;
        this.level = level;

        HashMap<String, List<List<String>>> mission_pair = new HashMap<>();
        List<List<String>> pairnames = new ArrayList<>();
        mission_pair.put(mission, pairnames);
        this.mission_pair = mission_pair;
    }

    public String getCourse() {
        return course;
    }

    public String getLevel() {
        return level;
    }

    public HashMap<String, List<List<String>>> getMission_pair() {
        return mission_pair;
    }

    public void setMission_pair(String key, List<List<String>> value) {
        HashMap<String, List<List<String>>> mission_pair = new HashMap<>();
        mission_pair.put(key, value);
        this.mission_pair = mission_pair;
    }
}
