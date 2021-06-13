import java.util.Random;

public class Computer implements Movable {
    Randomizer randomizer = new Randomizer();




    @Override
    public Move getMove() {
        Move[] moves = Move.values();
        int index = randomizer.secureRandom.nextInt(moves.length);
        return moves[index];
    }
}
