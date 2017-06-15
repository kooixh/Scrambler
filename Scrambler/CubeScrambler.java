package Scrambler;

/**
 * Created by Kooi on 14/05/2017.
 */
public abstract class CubeScrambler implements Scrambler {

    protected String puzzleName;
    protected String scramble="";
    protected String lastScramble;
    protected int scrambleLength;
    protected static String[] FACES = {"R","F","D","L","U","B"};
    protected static String[] ROTATION ={"","2","'"};


    public static Scrambler getInstance(String puzzle){

        if(puzzle.equals("3x3")){
            return new Scrambler3x3();
        }else if(puzzle.equals("4x4")){
            return new Scrambler4x4();
        }else if(puzzle.equals("5x5")){
            return new Scrambler5x5();
        }else if(puzzle.equals("2x2")){
            return new Scrambler2x2();
        }
        else{
            throw new IllegalArgumentException();
        }

    }
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


    /**
     *
     * get the ast scramble generated
     * @return N/A if no scramble is generated before
     */
    public String getLastScramble(){

        if (lastScramble.equals("") || lastScramble == null){
            return "N/A";
        }else{
            return lastScramble;
        }
    }



}
