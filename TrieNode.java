import java.util.ArrayList;

public class TrieNode {
    private final char label;
    private final String substring;
    private final ArrayList<TrieNode> children;
    
    
    public TrieNode(char label, String substring) {
        this.label = label;
        this.substring = substring;
        this.children = new ArrayList<>();
    }


    public char getLabel() {
        return label;
    }
    
    public String getSubstring() {
        return substring;
    }

    public ArrayList<TrieNode> getChildren() {
        return children;
    }
    
    public void addChild(TrieNode newChild){
        children.add(newChild);
    }
}
