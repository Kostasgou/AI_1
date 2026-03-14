import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Base kb = new Base();

        String onoma_arxeiou = "knowledge_base.txt";

        // fortosi vasis gnosis apo to arxeio
        loadKnowledgeBaseFromFile(kb, onoma_arxeiou);

        System.out.println("\n Knowledgebase is good:");
        System.out.println(kb);

        // typos pou theloyme na apodeixthei
        System.out.print("\nEnter the query to prove: ");
        String query = scanner.nextLine();

        // Forward Chaining
        boolean result = FC_PL.fc(kb,query);

        // ektiposi apotelesmatos
        System.out.println("\nResult:");
        if (result) {
            System.out.println("The query \"" + query + "\" can be proven.");
        } else {
            System.out.println("The query \"" + query + "\" CANNOT be proven.");
        }
    }

    private static void loadKnowledgeBaseFromFile(Base kb, String onoma_arxeiou) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(onoma_arxeiou));
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty() || line.startsWith("#")) { // Αγνοούμε κενές γραμμές και σχόλια
                continue;
            }
            if (line.contains("->")) {
                String[] parts = line.split("->");
                List<String> proypothesis = Arrays.asList(parts[0].trim().split("&"));
                String symberasma = parts[1].trim();
                kb.addProtasi(new Horn(proypothesis, symberasma));
            } else {
                kb.addgegonos(line);
            }
        }
        reader.close();
    }
}
