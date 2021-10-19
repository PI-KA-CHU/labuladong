package com.labuladong.分类.树;

public class _208_实现Trie_前缀树 {

    private Trie root = new Trie();

    public void insert(String word) {
        Trie trie = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (trie.children[index] == null) {
                trie.children[index] = new Trie();
            }
            trie = trie.children[index];
        }
        trie.isEnd = true;
    }

    public boolean search(String word) {

        Trie endNode = searchPrefix(word);
        return endNode != null && endNode.isEnd;
    }

    private Trie searchPrefix(String word) {
        Trie trie = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (trie.children[index] == null) {
                return null;
            }
            trie = trie.children[index];
        }
        return trie;
    }

    public boolean startsWith(String prefix) {
        Trie endNode = searchPrefix(prefix);
        return endNode != null;
    }
}
