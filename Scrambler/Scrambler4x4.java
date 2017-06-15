package Scrambler;

/**
 * Created by Kooi on 15/05/2017.
 */
public class Scrambler4x4 extends CubeScrambler{

    private final static String[] DOUBLE_ROTATION = {"","w"};


    protected Scrambler4x4(){
        super.scrambleLength = 40;
        super.puzzleName = "4x4";
        generateScramble();
    }


    @Override
    public String generateScramble() {
        lastScramble = scramble;

        //last face returned
        int last=0;
        int doubleRotate =0;


        //the first roation in the scramble
        boolean first = true;

        StringBuilder scramble = new StringBuilder();


        for(int i = 0; i< scrambleLength; i++) {
            String turn;
            if (first) {

                int randomFace = (int) (Math.random() * (FACES.length));
                int randomDouble = (int) (Math.random()*(DOUBLE_ROTATION.length));
                int randomRotation = (int) (Math.random() * (ROTATION.length));

                turn = FACES[randomFace] +DOUBLE_ROTATION[randomDouble]+ ROTATION[randomRotation];
                scramble.append(turn+" ");

                //store the last random number
                last = randomFace;
                doubleRotate = randomDouble;

                first = false;
            } else {
                int randomFace = (int) (Math.random() * (FACES.length));
                int randomDouble = (int) (Math.random()*(DOUBLE_ROTATION.length));
                int randomRotation = (int) (Math.random() * (ROTATION.length));

                //Don't allow same face twice
                while (randomFace == last && doubleRotate == randomDouble) {
                    randomFace = (int) (Math.random() * (FACES.length));
                    randomDouble = (int) (Math.random()*(DOUBLE_ROTATION.length));
                }


                last = randomFace;
                doubleRotate = randomDouble;


                turn = FACES[randomFace] + DOUBLE_ROTATION[randomDouble]+ ROTATION[randomRotation];



                scramble.append(turn+" ");
            }

        }
        super.scramble = scramble.toString();
        return super.scramble;

    }
}
