import java.util.*;

public class searcher {

    private ArrayList<state> list;
    private Set<state> closedSet = new HashSet<state>();

    // arxikopoihsh listwn
    searcher() {
        list = new ArrayList<>();
        closedSet = new HashSet<>();
    }

    // an h katastash einai telikh, thn epistrefei ws lush
    state BestFSClosedSet(state initialState, int heuristic) {

        if (initialState.isFinal(heuristic))
            return initialState;
        // eisagwgh stoixeiou sthn anoixth lista
        list.add(initialState);

        // eksetazei an h lista einai kenh
        while (list.size() > 0) {

            // pairnei to prwto node
            state currentState = list.remove(0);

            // an einai telikh katastash to epistrefei ws lush
            if (currentState.isFinal(heuristic))
                return currentState;

            // to prosthetei sthn kleisth lista
            closedSet.add(currentState);

            // dhmiourgia paidiwn
            List<state> children = currentState.getchildren(heuristic);
            // an to paidi den einai sthn kleisth lista, to vazei sthn anoixth
            for (state child : children) {
                if (!closedSet.contains(child)) {
                    list.add(child);
                }

                // taksinomish anoixths lista basei ths euretikhs timhs
                Collections.sort(list, new Comparator<state>() {
                    @Override
                    public int compare(state s1, state s2) {
                        return Integer.compare(s1.heuristic(), s2.heuristic());
                    }
                });
            }

        }

        return null;
    }

}
