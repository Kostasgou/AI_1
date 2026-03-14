import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainKat {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BaseKat kb = new BaseKat();

        
        String filename = "knowledge_base_kat.txt";

        // Load knowledge base 
        loadKnowledgeBaseFromFile(kb, filename);

        System.out.println("\nthe base is good:");
        System.out.println(kb);

        System.out.print("\nEnter the query to prove: ");
        String query = scanner.nextLine();

        boolean result = FC_Kat.fc(kb, query);

        System.out.println("\nResult:");
        if (result) {
            System.out.println("The query \"" + query + "\" can be proven.");
        } else {
            System.out.println("The query \"" + query + "\" CANNOT be proven.");
        }
    }
    
    private static void loadKnowledgeBaseFromFile(BaseKat kb, String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
    
            
            if (line.isBlank() || line.startsWith("#")) {
                continue;
            }
    
            if (line.contains("->")) {
                // blepoume poia einai symperasmata kai ta kanoume spit
                String[] parts = line.split("->");
                if (parts.length != 2) {
                    continue; 
                }
                // epejergasia upothesh kai symperasmata
                List<String> proypothesis = Arrays.asList(parts[0].trim().split("&"));
                proypothesis.replaceAll(String::trim); // Αφαίρεση περιττών κενών στις υποθέσεις
    
                String symberasma = parts[1].trim();
                if (!symberasma.isEmpty()) {
                    kb.addProtasi(new HornKat(proypothesis, symberasma));
                }
            } else {
                // apothhkeush gegonotwn
                if (!line.isEmpty() && !line.contains(" ")) {
                    kb.addGegonos(line);
                }
            }
        }
        reader.close();
    }
    
    
}
