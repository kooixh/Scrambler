package Scrambler;

/**
 * Created by Kooi on 14/05/2017.
 */
public abstract class CubeScrambler implements Scrambler {

    protected String puzzleName;
    protected String scramble="";
    protected int scrambleLength;
    protected static String[] FACES = {"R","F","D","L","U","B"};
    protected   static String[] ROTATION ={"","2","'"};



    public abstract String generateScramble();

    public String getScramble(){

        if(scramble == null)
            throw new NullPointerException();

        return scramble;
    }

    public String getPuzzleName(){
        return puzzleName;
    }

    public int getScrambleLength(){
        return scrambleLength;
    }



}
