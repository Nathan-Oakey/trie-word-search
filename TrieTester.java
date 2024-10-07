public class TrieTester {
    public static void main(String[] args) {
        String[] validWords = {"kitty", "puppy", "meows", "barks"};
        WordTrie trie = new WordTrie(validWords);
        
        System.out.println(trie.isValidWord("kitty"));
        System.out.println(trie.isValidWord("BARKS"));
        System.out.println(trie.isValidWord("cat"));
        System.out.println(trie.isValidWord("puppy"));
    }
}