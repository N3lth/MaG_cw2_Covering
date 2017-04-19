import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kombinacja {

    public static List<List<Integer>> Kombinacja(List<Integer> strings) {
        if (strings.size() > 1) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();

            for (Integer str : strings) {
                List<Integer> subStrings = new ArrayList<Integer>(strings);
                subStrings.remove(str);

                result.add(new ArrayList<Integer>(Arrays.asList(str)));

                for (List<Integer> combinations : Kombinacja(subStrings)) {
                    combinations.add(str);
                    result.add(combinations);
                }
            }

            return result;
        } else {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(new ArrayList<Integer>(strings));
            return result;
        }
    }
}