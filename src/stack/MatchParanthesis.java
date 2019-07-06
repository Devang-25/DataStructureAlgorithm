package stack;

import java.util.*;

/**
 * Created by rakeshgupta on 10/1/16.
 */
public class MatchParanthesis {

    static Map<Character, Character> matchingParaMap = new HashMap<>();
    static Set<Character> openingParaSet = new HashSet<>();

    static {
        matchingParaMap.put(')', '(');
        matchingParaMap.put('}', '{');
        matchingParaMap.put(']', '[');
        matchingParaMap.put('*', '*');
        openingParaSet.addAll(matchingParaMap.values());
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Enter String to check matching paranthesis");
        String input = new Scanner(System.in).nextLine();
        boolean ans = MatchParanthesis.hasMatchingParens(input);
        if (ans) System.out.println("String is well formed balance paranthesis");
        else System.out.println("Not a matching paranthesis");
    }

    public static boolean hasMatchingParens(String input) {
        try {
            StackImpl<Character> stack = new StackImpl<>();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (openingParaSet.contains(c)) stack.push(c);
                if (matchingParaMap.containsKey(c)) {
                    Character lastParen = stack.pop();
                    if (lastParen != matchingParaMap.get(c)) return false;
                }
            }
            return stack.isEmpty();

        } catch (StackImpl.StackOverFlowException soe) {
            System.out.println("Stack Overflow Exception");
        } catch (StackImpl.StackUnderFlowException sue) {
            System.out.println("Stack Underflow Exception");
        }
        return false;
    }
}
