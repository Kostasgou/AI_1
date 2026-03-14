import java.util.*;

public class FC_PL {
    public static boolean fc(Base kb, String typos) {
        Queue<String> agenda = new LinkedList<>(kb.gegonota); // Gegonota poy kseroume
        Set<String> symberasmena = new HashSet<>(); // gegonota pou exoyn symerastei
        Map<Horn, Integer> ypoloipa = new HashMap<>(); // protasis poy apomenoyn gia kathe kanona

        // arxikopoihsi tou pinaka ypoloipa
        for (Horn protasi : kb.protasis) {
            ypoloipa.put(protasi, protasi.proypothesis.size());
        }

        // epeksergasia tis agenda
        while (!agenda.isEmpty()) {
            String gegonos = agenda.poll();

            // an to gegonos den exei symberastei
            if (!symberasmena.contains(gegonos)) {
                symberasmena.add(gegonos); // prosthetoume to gegonos sta symberasmena

                // epeksergasia twn kanonwn poy periexoyn to gegonos
                for (Horn protasi : kb.protasis) {
                    if (protasi.proypothesis.contains(gegonos)) {
                        ypoloipa.put(protasi, ypoloipa.get(protasi) - 1);

                        // an oles oi protasis ikanopoithoun
                        if (ypoloipa.get(protasi) == 0) {
                            String symberasma = protasi.symberasma;

                            // Αn to apotelesma einai o typos pou theloume na apodeiksoyme
                            if (symberasma.equals(typos)) {
                                return true;
                            }

                            // prosthetoume to apotelesma sthn agenda
                            agenda.add(symberasma);
                        }
                    }
                }
            }
        }

        // an den vrethike o typos poy theloume na apodeiksoume
        return false;
    }
}
