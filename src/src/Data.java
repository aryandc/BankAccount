package src;

import java.util.List;

public class Data {

    /**
     * computes average for a list of Measurable.
     * @param list list of measurable objects
     * @return average of measurables.
     */
    static float average(List<Measurable> list) {
        float sum = 0.0f;
        for (Measurable m: list) {
            sum = sum + m.getMeasure();
        }

        return sum/list.size();
    }
}
