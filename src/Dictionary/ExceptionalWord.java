package Dictionary;

public class ExceptionalWord extends Word{
    private String root;
    private Pos pos;

    public ExceptionalWord(String name, String root, Pos pos){
        super(name);
        this.root = root;
        this.pos = pos;
    }

    public String getRoot(){
        return root;
    }

    public Pos getPos(){
        return pos;
    }
}
