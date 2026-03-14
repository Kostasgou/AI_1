import java.util.HashMap;
import java.util.Map;

public class Unifier {
    public static Map<String, String> unify(String x, String y, Map<String, String> orisma) {
        if (orisma == null) {
            return null;
        } else if (x.equals(y)) {
            return orisma;
        } else if (isVariable(x)) {
            return unifyVar(x, y, orisma);
        } else if (isVariable(y)) {
            return unifyVar(y, x, orisma);
        } else if (isCompound(x) && isCompound(y)) {
            String[] prvto_part = decompose(x);
            String[] deutero_part = decompose(y);

            // ariumos apo arguments einai svstos
            if (!prvto_part[0].equals(deutero_part[0]) || prvto_part.length != deutero_part.length) {
                return null; 
            }

            for (int i = 1; i < prvto_part.length; i++) {
                orisma = unify(prvto_part[i], deutero_part[i], orisma);
                if (orisma == null) {
                    return null; 
                }
            }
            return orisma;
        } else {
            return null; 
        }
    }

    private static Map<String, String> unifyVar(String var, String x, Map<String, String> orisma) {
        if (orisma.containsKey(var)) {
            return unify(orisma.get(var), x, orisma);
        } else if (orisma.containsKey(x)) {
            return unify(var, orisma.get(x), orisma);
        } else if (occursCheck(var, x)) { // blepoume an ginetai circular unification kai to apofeugoume
            return null;
        } else if (isCompound(x) && occursCheck(var, x)) { 
            return null;
        } else {
            orisma.put(var, x);
            return orisma;
        }
    }

    private static boolean occursCheck(String var, String x) {
        if (var.equals(x)) {
            return true;
        } else if (isCompound(x)) {
            String[] parts = decompose(x);
            for (String part : parts) {
                if (occursCheck(var, part)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isVariable(String x) {
        return Character.isLowerCase(x.charAt(0)) && !x.contains("("); 
    }

    private static boolean isCompound(String x) {
        return x.contains("(") && x.contains(")");
    }

    private static String[] decompose(String x) { // diaspash synueto orou se synarthsh kai orimsta
        int idx = x.indexOf('(');
        String functionName = x.substring(0, idx);
        String args = x.substring(idx + 1, x.length() - 1); 
        return combineFunctionAndArgs(functionName, args.split(","));
    }

    private static String[] combineFunctionAndArgs(String functionName, String[] args) { //kanei ena combination me to onoma ths synasrthshs  kai ta orimsata se enan pinaka
        String[] result = new String[args.length + 1];
        result[0] = functionName;
        System.arraycopy(args, 0, result, 1, args.length);
        return result;
    }
}
