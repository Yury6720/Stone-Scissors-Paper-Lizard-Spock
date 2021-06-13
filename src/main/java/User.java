import java.util.Scanner;

public class User implements Movable {

    private Scanner inputScanner;

    public User() {
        inputScanner = new Scanner(System.in);
    }

    @Override
    public Move getMove() {
        // Выведем запрос на ввод
        System.out.print("Камень - 'К',\nНожницы - 'Н', \nБумага - 'Б' \nЯщерица - 'Я' \nСпок - 'С' \nКаков будет Ваш ход?");

        // Прочитаем ввод пользователя
        String userInput = inputScanner.nextLine();
        userInput = userInput.toUpperCase();
        char firstLetter = userInput.charAt(0);
        if (firstLetter == 'К' || firstLetter == 'Н' || firstLetter == 'Б'|| firstLetter == 'Я' || firstLetter == 'С') {
            // Ввод корректный
            switch (firstLetter) {
                case 'К':
                    return Move.ROCK;
                case 'Б':
                    return Move.PAPER;
                case 'Н':
                    return Move.SCISSORS;
                case 'Я':
                    return Move.LIZARD;
                case 'C':
                    return Move.SPOCK;
            }
        }
        // Ввод некорректный. Выведем запрос на ввод снова.
        return getMove();
    }

    public boolean playAgain() {
        System.out.print("Хотите сыграть еще раз? \n Д/Н");
        String userInput = inputScanner.nextLine();
        userInput = userInput.toUpperCase();
        return userInput.charAt(0) == 'Д';
    }

}
