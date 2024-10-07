import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class WordTrie {
    private final String[] validWords;
    private final TrieNode trieRoot;
    
    public WordTrie(String[] validWords) {
        this.validWords = validWords;
        this.trieRoot = buildTrie();
    }
    
    public String[] getValidWords() {
        return validWords;
    }
    
    //
    public boolean isValidWord(String word) {
        boolean isValid = false;
        
        if (word.length() == validWords[0].length()) {
            isValid = true;
            TrieNode node = trieRoot;
            ListIterator<TrieNode> childIterator = node.getChildren().listIterator();
            List<Character> chars = new LinkedList<>();
            word.chars().mapToObj(c -> (char) c).forEach(chars::add);
            ListIterator<Character> charIterator = chars.listIterator();
            
            while (charIterator.hasNext() && isValid) {
                char c = charIterator.next();
                isValid = false;
                
                while (childIterator.hasNext() && !isValid) {
                    TrieNode child = childIterator.next();
                    
                    if (child.getLabel() == c) {
                        isValid = true;
                        node = child;
                    }
                }
            }
        }
        
        return isValid;
    }
    
    //
    private TrieNode buildTrie() {
        ListIterator<String> wordIterator = Arrays.asList(validWords).listIterator();
        Queue<TrieNode> nodeQueue = new LinkedList<>();
        TrieNode root = new TrieNode('\0', "");
        nodeQueue.add(root);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        while (!nodeQueue.isEmpty()) {
            TrieNode node = nodeQueue.remove();
            String substring = node.getSubstring();
            ArrayList<Character> potentialChildren = new ArrayList<>();
            alphabet.chars().mapToObj(c -> (char) c).forEach(potentialChildren::add);
            
            while (wordIterator.hasNext() && !potentialChildren.isEmpty()) {
                String word = wordIterator.next();
                
                if (word.startsWith(substring)) {
                    char letter = word.charAt(substring.length());
                    
                    if (potentialChildren.contains(letter)) {
                        potentialChildren.remove(letter);
                        TrieNode child = new TrieNode(letter, substring + letter);
                        node.addChild(child);
                        nodeQueue.add(child);
                    }
                }
            }
        }
        
        return root;
    }
}