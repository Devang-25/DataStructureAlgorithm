package stack;


import java.util.*;

public class BalanceString {

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
        String input = new Scanner(System.in).nextLine();
        boolean ans = BalanceString.hasMatchingParens(input);
        if (ans)
            System.out.println("1");
        else
            System.out.println("-1");
    }

    public static boolean hasMatchingParens(String input) throws Exception{
        try {
            StackImpl<Character> stack = new StackImpl<>();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (openingParaSet.contains(c))
                    stack.push(c);
                if (matchingParaMap.containsKey(c)){
                    Character lastParen = stack.pop();
                    if (lastParen != matchingParaMap.get(c))
                        return false;
                }
            }
            return stack.isEmpty();
        }catch (Exception soe){
            return false;
        }
    }
}
