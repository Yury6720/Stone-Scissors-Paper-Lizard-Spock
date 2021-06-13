public class RockScissorsPaperLizardSpock {

    private User user;
    private Computer computer;
    private int userScore;
    private int computerScore;
    private int numberOfGames;
    private Randomizer randomizer;

    public RockScissorsPaperLizardSpock() {
        user = new User();
        computer = new Computer();
        userScore = 0;
        computerScore = 0;
        numberOfGames = 0;
        randomizer = new Randomizer();
    }

    public void startGame() {
        System.out.println("КАМЕНЬ, НОЖНИЦЫ, БУМАГА, ЯЩЕРИЦА, СПОК!");
        Move computerMove = computer.getMove();
        String key = randomizer.GenerateSecureKey();
        String hex = randomizer.CalculateHMAC(computerMove.toString(), key);
        System.out.println("hex: " + hex);
        Move userMove = user.getMove();

        System.out.println("Ваш ход  " + userMove + ".");
        System.out.println("Ход компьютера  " + computerMove + ".\n");
        System.out.println("Key: " + key);

        int compareMoves = userMove.compareMoves(computerMove);
        switch (compareMoves) {
            case 0: // draw
                System.out.println("Ничья!");
                break;
            case 1: // //you win
                System.out.println(userMove + " beats " + computerMove + ". Вы победили!");
                userScore++;
                break;
            case -1: //computer wins
                System.out.println(computerMove + " beats " + userMove + ". Вы проиграли.");
                computerScore++;
                break;
        }
        numberOfGames++;

        if (user.playAgain()) {
            System.out.println();
            startGame();
        } else {
            printGameStats();
        }
    }

    private void printGameStats() {
        int wins = userScore;
        int losses = computerScore;
        int ties = numberOfGames - userScore - computerScore;
        double percentageWon = (wins + ((double) ties) / 2) / numberOfGames;

        System.out.printf("|  %6s  |  %6s  |  %6s  |  %12s  |  %14s  |\n",
                "ПОБЕДА", "ПОРАЖЕНИЕ", "НИЧЬЯ", "ВСЕГО ИГР", "ПРОЦЕНТ ПОБЕД");

        System.out.printf("|  %6d  |  %6d  |  %6d  |  %12d  |  %13.2f%%  |\n",
                wins, losses, ties, numberOfGames, percentageWon * 100);
    }

}
