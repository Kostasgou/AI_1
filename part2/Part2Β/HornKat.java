import java.util.List;

public class HornKat {
    private List<String> proypothesisKat; // Προϋποθέσεις (συνθήκες) του κανόνα
    private String symberasmaKat;         // Συμπέρασμα (ή σώμα του κανόνα)

    // Κατασκευαστής για τη δημιουργία του κανόνα με προϋποθέσεις και συμπέρασμα
    public HornKat(List<String> proypothesisKat, String symberasmaKat) {
        this.proypothesisKat = proypothesisKat;
        this.symberasmaKat = symberasmaKat;
    }

    // Μέθοδος για να επιστρέφει τις προϋποθέσεις του κανόνα
    public List<String> getProypothesisKat() {
        return proypothesisKat;
    }

    // Μέθοδος για να επιστρέφει το συμπέρασμα του κανόνα
    public String getSymberasmaKat() {
        return symberasmaKat;
    }

    // Μέθοδος για την αναπαράσταση του κανόνα ως κείμενο
    @Override
    public String toString() {
        // Συνένωση των προϋποθέσεων με το σύμβολο ' & ', και εμφάνιση του κανόνα με το '->'
        String preconditions = String.join(" & ", proypothesisKat);
        return preconditions + " -> " + symberasmaKat;
    }
}
