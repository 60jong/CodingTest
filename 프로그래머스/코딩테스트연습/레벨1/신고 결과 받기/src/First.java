import java.util.*;

public class First {
    public int[] solution(String[] id_list, String[] report, int k) {
//        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
//        int k = 2;
        Map<String, Integer> map = new HashMap<>(id_list.length);
        List<LinkedList<String>> list = new ArrayList<>();

        int[] answer = new int[id_list.length];
        Arrays.fill(answer,0);

        int memberIdx = 0;
        for (String m : id_list) {
            map.put(m, memberIdx++);
            list.add(new LinkedList<>());
        }

        for (String s : report) {
            String[] element = s.split(" ");
            int index = map.get(element[1]);

            LinkedList<String> reporters = list.get(index);
            if(reporters.size()!=0) {
                int i = 0;
                while (i < reporters.size()) {
                    if(reporters.get(i).equals(element[0]))
                        break;
                    if(i == reporters.size()-1)
                        reporters.add(element[0]);
                    i++;
                }
            } else
                reporters.add(element[0]);
        }
        for (int i = 0; i < list.size(); i++) {
            LinkedList<String> a = list.get(i);
            if (a.size() >= k) {
                for (int j = 0; j < a.size(); j++) {
                    int resIndex = map.get(a.get(j));
                    answer[resIndex]++;
                }
            }
        }
        return answer;
    }
}
