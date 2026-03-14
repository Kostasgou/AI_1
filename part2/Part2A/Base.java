import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Base {
    // Lista me tous kanones typou Horn (proypothesis kai symperasma)
    public List<Horn> protasis; // protasis Horn

    // Synolo me ta gnwsta gegonota
    public Set<String> gegonota; // gegonota

    // Constructor pou arxikopoiei tin vasi gnwsewn (lista kanonwn kai synolo
    // gegonotwn)
    public Base() {
        this.protasis = new ArrayList<>(); // Arxikopoiisi tis listas me tous kanones
        this.gegonota = new HashSet<>(); // Arxikopoiisi tou synolou me ta gegonota
    }

    // Methodos gia na prosthesoume enan kanona sti lista protasis
    public void addProtasi(Horn protasi) {
        protasis.add(protasi); // Prosthetei ton kanona sti lista protasis
    }

    // Methodos gia na prosthesoume ena gegonos sto synolo gegonota
    public void addgegonos(String gegonos) {
        gegonota.add(gegonos); // Prosthetei to gegonos sto synolo gegonota
    }

    // Methodos pou epistrefei tin vasi gnwsewn os string (gegonota kai kanones)
    @Override
    public String toString() {
        return "Gegonota:" + gegonota + "\nProtasis:" + protasis;
        // Epistrefei ta gegonota kai tous kanones os string gia emfanish
    }
}
