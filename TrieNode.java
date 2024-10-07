import java.util.ArrayList;

public class TrieNode {
    private final char label;
    private final TrieNode parent;
    private final ArrayList<TrieNode> children;
    
    
    public TrieNode(char label, TrieNode parent) {
        this.label = label;
        this.parent = parent;
        this.children = new ArrayList<>();
    }


    public char getLabel() {
        return label;
    }

    public TrieNode getParent() {
        return parent;
    }

    public ArrayList<TrieNode> getChildren() {
        return children;
    }
    
    public void addChild(TrieNode newChild){
        children.add(newChild);
    }
}
