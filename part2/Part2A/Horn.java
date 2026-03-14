import java.util.List;

public class Horn {
    // H lista proypothesis periexei tis proypothesis tou kanona
    public List<String> proypothesis; // proypothesis

    // To symberasma einai to symperasma tou kanona
    public String symberasma; // symberasma

    // Constructor gia arxikopoiisi tou kanona me proypothesis kai symperasma
    public Horn(List<String> proypothesis, String symberasma) {
        this.proypothesis = proypothesis; // Orizoume tis prokimenes
        this.symberasma = symberasma; // Orizoume to symperasma
    }

    // Methodos gia na orisoume to symperasma
    public void setConclusion(String symberasma) {
        this.symberasma = symberasma; // Allazoume to symperasma
    }

    // Methodos gia na orisoume tis proypothesis
    public void setProypothesis(List<String> proypothesis) {
        this.proypothesis = proypothesis; // Allazoume tis prokimenes
    }

    // Methodos gia na epistrepsei to symperasma
    public String getSymberasma() {
        return symberasma; // Epistrefei to symperasma
    }

    // Methodos gia na epistrepsei tis proypothesis
    public List<String> getProypothesis() {
        return proypothesis; // Epistrefei tis prokimenes
    }

    // Methodos gia na epistrepsei ton kanona os string
    @Override
    public String toString() {
        return proypothesis + " -> " + symberasma; // Typonei tis prokimenes kai to symperasma
    }
}
