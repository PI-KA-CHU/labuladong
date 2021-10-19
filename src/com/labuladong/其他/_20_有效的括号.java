package com.labuladong.其他;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class _20_有效的括号 {

    public boolean isValid(String s) {

        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || map.get(stack.peek()) != c) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
