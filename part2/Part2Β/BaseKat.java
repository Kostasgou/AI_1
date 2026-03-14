import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseKat {
    public List<HornKat> protasisKat; // Horn rules in the knowledge base
    public Set<String> gegonotaKat;   // einai gegonata a opoia einai h empeirika h ta paragoume

    public BaseKat() {
        this.protasisKat = new ArrayList<>();
        this.gegonotaKat = new HashSet<>();
    }

    // prosuetei tis protasei
    public void addProtasi(HornKat protasiKat) {
        this.protasisKat.add(protasiKat); 
    }

    // prosuesei gegonotvn
    public void addGegonos(String gegonosKat) {
        gegonotaKat.add(gegonosKat);
    }

    
    public List<HornKat> getProtasisKat() {
        return protasisKat;
    }

    public Set<String> getGegonotaKat() {
        return gegonotaKat;
    }

    @Override
    public String toString() {
        return "Facts: " + gegonotaKat + "\nRules: " + protasisKat;
    }
}
