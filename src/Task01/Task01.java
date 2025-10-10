/*Есть сайт, на котором рассчитывается рейтинг игроков различных сетевых игр. Игрок при регистрации указывает ник, а так же список игр, в которые он играет.
Задача – написать программу, которая:
- регистрирует игроков в системе (должна быть проверка, занят ли ник);
- добавляет рейтинг игроку, в случае его выигрыша в игре;
- выводит список игр, в которые играют все игроки на сайте;
- выводит рейтинг по имени игрока и игре;
- выводит 10 лучших игроков в определенной игре;
- выводит 10 лучших игроков с учетом всех игр.
*/
package Task01;
import java.util.*;

public class Task01 {
    public static void main(String[] args) {
        RatingSystem ratingSystem = new RatingSystem();
        // Демонстрация работы системы
        System.out.println("\nРегистрация игроков");

        // Регистрируем игроков
        String[] players = {"Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace", "Henry", "Ivy", "Jack"};
        for (String player : players) {
            if (ratingSystem.registerPlayer(player)) {
                System.out.println("Зарегистрирован игрок: " + player);
            }
        }

        // Пытаемся зарегистрировать существующего игрока
        if (!ratingSystem.registerPlayer("Alice")) {
            System.out.println("Ник Alice уже занят!");
        }

        // Добавляем игры и рейтинги
        System.out.println("\n Добавление рейтингов");

        // Alice играет в Dota 2 и CS:GO
        ratingSystem.addRating("Alice", "Dota 2", 100);
        ratingSystem.addRating("Alice", "CS:GO", 150);
        ratingSystem.addRating("Alice", "Dota 2", 50); // Еще победа в Dota 2

        // Bob играет в CS:GO и Valorant
        ratingSystem.addRating("Bob", "CS:GO", 200);
        ratingSystem.addRating("Bob", "Valorant", 100);

        // Charlie играет во все игры
        ratingSystem.addRating("Charlie", "Dota 2", 300);
        ratingSystem.addRating("Charlie", "CS:GO", 250);
        ratingSystem.addRating("Charlie", "Valorant", 150);
        ratingSystem.addRating("Charlie", "League of Legends", 200);

        // Добавляем рейтинги остальным игрокам
        String[] games = {"Dota 2", "CS:GO", "Valorant", "League of Legends", "Overwatch"};
        Random random = new Random();
        for (String player : players) {
            for (String game : games) {
                if (random.nextBoolean()) {
                    int points = random.nextInt(200) + 50;
                    ratingSystem.addRating(player, game, points);
                }
            }
        }

        // Демонстрация функционала
        System.out.println("\nСписок всех игр на сайте");
        Set<String> allGames = ratingSystem.getAllGames();
        System.out.println("Все игры: " + allGames);

        System.out.println("\nРейтинг игрока по игре");
        System.out.println("Рейтинг Alice в Dota 2: " + ratingSystem.getPlayerRating("Alice", "Dota 2"));
        System.out.println("Рейтинг Bob в CS:GO: " + ratingSystem.getPlayerRating("Bob", "CS:GO"));

        System.out.println("\nТоп-5 игроков в Dota 2");
        List<Player> topDota = ratingSystem.getTopPlayersByGame("Dota 2", 5);
        for (int i = 0; i < topDota.size(); i++) {
            Player p = topDota.get(i);
            System.out.println((i + 1) + ". " + p.getNickname() + " - " + p.getRating("Dota 2"));
        }

        System.out.println("\nТоп-5 игроков по общему рейтингу");
        List<Player> topOverall = ratingSystem.getTopPlayersOverall(5);
        for (int i = 0; i < topOverall.size(); i++) {
            Player p = topOverall.get(i);
            System.out.println((i + 1) + ". " + p.getNickname() + " - " + p.getTotalRating());
        }

        System.out.println("\nДетальная информация о топ-игроках");
        for (Player p : topOverall) {
            System.out.println(p);
            System.out.println("  Детальный рейтинг: " + p.getAllRatings());
        }

    }
}