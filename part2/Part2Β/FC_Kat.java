import java.util.*;
import java.util.regex.Pattern; // Prosthiki eisagwghs gia thn pattern.


public class FC_Kat {

    public static boolean fc(BaseKat kb, String query) {
        // oura me gegonata
        Queue<String> agenda = new LinkedList<>(kb.gegonotaKat);
        Map<String, Boolean> inferred = new HashMap<>();

        // prostihkh gegonotwn sto map
        for (String gegonos : kb.gegonotaKat) {
            inferred.put(gegonos, false);
        }

       
        while (!agenda.isEmpty()) {
            String p = agenda.poll();
            
            // an exei apodixthei idi proxwra
            if (inferred.getOrDefault(p, false)) {
                continue;
            }
            inferred.put(p, true);

            // an einai auto pou theloume to gegonos
            if (p.equals(query)) {
                return true;
            }

            for (HornKat protasi : kb.protasisKat) {
                // ennopoihsh
                boolean allPremisesSatisfied = true;
                Map<String, String> orisma = new HashMap<>();
                for (String premise : protasi.getProypothesisKat()) {
                    boolean premiseSatisfied = false;
                    for (String fact : kb.getGegonotaKat()) {
                        Map<String, String> temporisma = Unifier.unify(fact, premise, new HashMap<>(orisma));
                        if (temporisma != null) {
                            orisma.putAll(temporisma); // oles h hηnoipoihshs  kai oi syndiasmoi tous
                            premiseSatisfied = true;
                            break;
                        }
                    }
                    if (!premiseSatisfied) {
                        allPremisesSatisfied = false;
                        break;
                    }
                }

                if (allPremisesSatisfied) {
                    // upologismos sympoerasmatos
                    String unifiedConclusion = applySubstitution(protasi.getSymberasmaKat(), orisma);
                
                    // an den uparxei symperasmsa balto
                    if (!kb.getGegonotaKat().contains(unifiedConclusion)) {
                        kb.addGegonos(unifiedConclusion); // prosuhkh bashs
                        agenda.add(unifiedConclusion);   // prosuhkh oura
                        System.out.println("Derived conclusion: " + unifiedConclusion);
                    }
                }
                            }
                        }

        return false; 
    }

    // allagh gramatvn bash to unification
    private static String applySubstitution(String str, Map<String, String> orisma) {
        for (Map.Entry<String, String> entry : orisma.entrySet()) {
           
            String key = entry.getKey();
            String value = entry.getValue();
            
           
            str = str.replaceAll("\\b" + Pattern.quote(key) + "\\b", value);
        }
        return str;
    }
}
