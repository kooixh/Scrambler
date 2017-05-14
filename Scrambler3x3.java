package Scrambler;

/**
 * Created by Kooi on 14/05/2017.
 */
public class Scrambler3x3 extends CubeScrambler{

    public Scrambler3x3(){
        puzzleName = "3x3";
        scrambleLength = 21;
        generateScramble();
    }

    @Override
    public String generateScramble() {
        //last face returned
        int last=0;
        //the first roation in the scramble
        boolean first = true;

        StringBuilder scramble = new StringBuilder();


        for(int i = 0; i< scrambleLength; i++) {
            String turn;
            if (first) {

                int randomFace = (int) (Math.random() * (FACES.length));
                int randomRotation = (int) (Math.random() * (ROTATION.length));

                turn = FACES[randomFace] + ROTATION[randomRotation];
                scramble.append(turn+" ");

                //store the last random number
                last = randomFace;

                first = false;
            } else {
                int randomFace = (int) (Math.random() * (FACES.length));

                //Don't allow same face twice
                while (randomFace == last) {
                    randomFace = (int) (Math.random() * (FACES.length));
                }
                last = randomFace;


                int randomRotation = (int) (Math.random() * (ROTATION.length));

                turn = FACES[randomFace] + ROTATION[randomRotation];

                //store last random number


                scramble.append(turn+" ");
            }

        }
        super.scramble = scramble.toString();
        return super.scramble;
    }
}
