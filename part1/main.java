import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter Number of Cannibals/Missionaries: ");
        int N = input.nextInt();
        System.out.println("Enter Capacity of Boat (>=2): ");
        int M = input.nextInt();
        System.out.println("Enter Max Routes Allowed: ");
        int K = input.nextInt();

        int initialMissionaries = N;
        int initialCannibals = N;
        int boatCapacity = M;
        int boatcrosses = K;

        //dimiourgia arxikhs katastashs constructor
        state initialState = new state(initialMissionaries, initialCannibals, 0, 0, 0, boatCapacity, 0);

        //dimiourgei to antikeimeno klashs pou kanei thn anazhthsh ths lushs
        searcher searcherInstance = new searcher();

        //arxh katagrafhs xronou
        long startTime = System.currentTimeMillis();

        //ulopoihsh BestFirst search
        state finalState = searcherInstance.BestFSClosedSet(initialState, initialMissionaries);

        //paush katagrafhs xronou
        long endTime = System.currentTimeMillis();

        //upologismos xronou
        double searchTimeInSeconds = (endTime - startTime) / 1000.0;
        
        //apotelesma:
        if (finalState != null&& finalState.transitions.size()<=boatcrosses) {
            System.out.println("Solution found!");
            System.out.println("Missionaries on the left: " + finalState.get_ierapostoloiAristera());
            System.out.println("Cannibals on the left: " + finalState.get_kanibaloiAristera());
            System.out.println("Missionaries on the right: " + finalState.get_ierapostoloiDexia());
            System.out.println("Cannibals on the right: " + finalState.get_kanibaloiDexia());
            System.out.println("Boat crosses the river: " + (finalState.transitions.size()));
            for(int i=0;i<finalState.transitions.size();i++){
                System.out.println(finalState.transitions.get(i));
            }
        } else {
            System.out.println("No solution found.");
        }

        //ektipwsh xronou 
        System.out.printf("Search time: %.3f seconds.%n", searchTimeInSeconds);
    }
}
