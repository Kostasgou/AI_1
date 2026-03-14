import java.util.*;

public class state {
    int ierapostoloiAristera;
    int ierapostoloiDexia;
    int kanibaloiAristera;
    int kanibaloiDexia;
    int boat; // thesi varkas, 0 = aristera, 1 = dexia
    int boatcapacity;
    int heuristic;
    int boatcrosses;
    List<String> transitions;
    public int count = 0;

    // constructor
    public state(int ierapostoloiAristera, int kanibaloiAristera, int ierapostoloiDexia, int kanibaloiDexia,
            int boat, int boatcapacity, int heuristic) {
        this.ierapostoloiAristera = ierapostoloiAristera;
        this.ierapostoloiDexia = ierapostoloiDexia;
        this.kanibaloiAristera = kanibaloiAristera;
        this.kanibaloiDexia = kanibaloiDexia;
        this.boat = boat;
        this.boatcapacity = boatcapacity;
        this.heuristic = heuristic();
        this.transitions = new ArrayList<>();

    }

    public int get_ierapostoloiAristera() {
        return this.ierapostoloiAristera;
    }

    public int get_boatcapacity() {
        return boatcapacity;
    }

    public int get_ierapostoloiDexia() {
        return this.ierapostoloiDexia;
    }

    public int get_kanibaloiAristera() {
        return this.kanibaloiAristera;
    }

    public int get_kanibaloiDexia() {
        return this.kanibaloiDexia;
    }

    public int get_boat() {
        return this.boat;
    }

    public int get_boatcrosses() {
        return this.boatcrosses;
    }

    public void set_ierapostoloiAristera(int i) {
        this.ierapostoloiAristera = i;
    }

    public void set_ierapostoloiDexia(int i) {
        this.ierapostoloiDexia = i;
    }

    public void set_kanibaloiAristera(int c) {
        this.kanibaloiAristera = c;
    }

    public void set_boatcapacity(int m) {
        this.boatcapacity = m;
    }

    public void set_kanibaloiDexia(int c) {
        this.kanibaloiDexia = c;
    }

    public void set_boat(int b) {
        this.boat = b;
    }

    public void set_boatcrosses(int k) {
        this.boatcrosses = k;
    }

    public boolean isValid() {
        // koitaei gia arnitikous arithmous
        if (ierapostoloiAristera < 0 || kanibaloiAristera < 0 || ierapostoloiDexia < 0 || kanibaloiDexia < 0) {
            return false;
        }
        // koitaei an einai perissoteroi oi kannbaloi sta aristera
        if (ierapostoloiAristera > 0 && ierapostoloiAristera < kanibaloiAristera) {
            return false;
        }
        // koitaei an einai perissoteroi oi kannbaloi sta dexia
        if (ierapostoloiDexia > 0 && ierapostoloiDexia < kanibaloiDexia) {
            return false;
        }
        return true;
    }

    // elegxei an h katastash einai telikh
    public boolean isFinal(int n) {
        if (ierapostoloiDexia == n && kanibaloiDexia == n && boat == 1) {
            return true;
        }
        return false;
    }

    // ypologismos euretikis sunarthshs
    public int heuristic() {
        int peopleLeft = ierapostoloiAristera + kanibaloiAristera;
        if (boat == 1) {
            if (peopleLeft == 1) {
                return 1;
            } else {
                return 2 * peopleLeft - 3;
            }
        } else {
            return 2 * peopleLeft;
        }
    }

    // metatrepei to antikeimeno se typou state
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        state state = (state) o;
        return ierapostoloiAristera == state.ierapostoloiAristera &&
                kanibaloiAristera == state.kanibaloiAristera &&
                ierapostoloiDexia == state.ierapostoloiDexia &&
                kanibaloiDexia == state.kanibaloiDexia &&
                boat == state.boat;
    }

    public List<state> getchildren(int heuristic) {
        List<state> children = new ArrayList<>(); // dimiourgei thn lista pou tha exei tis epomenes katastaseis
        for (int i = 0; i <= boatcapacity; i++) { // gennihtria katastasewn opou dokimazei olous tous pithanous
                                                  // sundiasmous metaforwn
            for (int j = 0; j <= boatcapacity; j++) {
                if (i + j >= 1 && i + j <= boatcapacity) {
                    // metafora atomwn
                    int iierapostoloiAristera = ierapostoloiAristera;
                    int kkanibaloiAristera = kanibaloiAristera;
                    int iierapostoloiDexia = ierapostoloiDexia;
                    int kkanibaloiDexia = kanibaloiDexia;
                    int bboat = (boat + 1) % 2;

                    if (boat == 0) {// metafora apo aristera pros ta dexia
                        iierapostoloiAristera -= i;
                        kkanibaloiAristera -= j;
                        iierapostoloiDexia += i;
                        kkanibaloiDexia += j;

                    } else {// metafora apo ta dexia sta aristera
                        iierapostoloiAristera += i;
                        kkanibaloiAristera += j;
                        iierapostoloiDexia -= i;
                        kkanibaloiDexia -= j;

                    }

                    state child = new state(iierapostoloiAristera, kkanibaloiAristera, iierapostoloiDexia,
                            kkanibaloiDexia, bboat, boatcapacity, heuristic);

                    // katagrafh metavashs
                    child.transitions = new ArrayList<>(transitions);
                    if (boat == 0) {
                        child.transitions.add("Boat moved: " + i + "M and " + j + "C from " + "left to right");
                    } else {
                        child.transitions.add("Boat moved: " + i + "M and " + j + "C from " + "right to left");
                    }

                    if (child.isValid())
                        children.add(child);// prosthetei ta egkura paidia
                }
            }
        }
        return children;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ierapostoloiAristera, kanibaloiAristera, ierapostoloiDexia, kanibaloiDexia, boat);
    }
}