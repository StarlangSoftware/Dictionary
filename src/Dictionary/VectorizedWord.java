package Dictionary;

import Math.Vector;

public class VectorizedWord extends Word{
    private Vector vector;

    public VectorizedWord(String name, Vector vector){
        super(name);
        this.vector = vector;
    }

    public Vector getVector(){
        return vector;
    }
}
