import java.util.Scanner;

public class User implements Movable {

    private Scanner inputScanner;

    public User() {
        inputScanner = new Scanner(System.in);
    }

    @Override
    public Move getMove() {
        // Выведем запрос на ввод
        System.out.print("Камень, ножницы или бумага? ");

        // Прочитаем ввод пользователя
        String userInput = inputScanner.nextLine();
        userInput = userInput.toUpperCase();
        char firstLetter = userInput.charAt(0);
        if (firstLetter == 'К' || firstLetter == 'Н' || firstLetter == 'Б') {
            // Ввод корректный
            switch (firstLetter) {
                case 'К':
                    return Move.STONE;
                case 'Н':
                    return Move.PAPER;
                case 'Б':
                    return Move.SCISSORS;
            }
        }
        // Ввод некорректный. Выведем запрос на ввод снова.
        return getMove();
    }
    public boolean playAgain() {
        System.out.print("Хотите сыграть еще раз? ");
        String userInput = inputScanner.nextLine();
        userInput = userInput.toUpperCase();
        return userInput.charAt(0) == 'Д';
    }

}
