public class Main {
    public static void main(String[] args) {

        HeroField heroField = new HeroField(5, 5);
        ConsumableField consumableField = new ConsumableField(5, 5);
        System.out.println("Field with size " + heroField.getHeight() + "x" + heroField.getWidth() + " was created.");
        boolean isGameFinished = false;

        Hero thor = new Hero("Thor", "Th", 2000, 300);
        Hero loki = new Hero("Loki", "Lo", 1500, 200);

        heroField.addHero(thor);
        System.out.println("Hero added Hero(name=" + thor.getName() + ", initial=" + thor.getInitial() + ", health="
                + thor.getHealth() + ", power=" + thor.getPower() + ") at x=" + heroField.getHeroPosition(thor)[0]
                + ", y="
                + heroField.getHeroPosition(thor)[1]);
        heroField.addHero(loki);
        System.out.println("Hero added Hero(name=" + loki.getName() + ", initial=" + loki.getInitial() + ", health="
                + loki.getHealth() + ", power=" + loki.getPower() + ") at x=" + heroField.getHeroPosition(loki)[0]
                + ", y="
                + heroField.getHeroPosition(loki)[1]);

        Consumables brocoli = new Consumables("Beer", "B ", 3);
        Consumables rice = new Consumables("Rice", "R ", 1);
        Consumables mushroom = new Consumables("Mushroom", "M ", 5);

        consumableField.addConsumable(brocoli);
        System.out.println("Consumable added Broccoli(initial=" + brocoli.getInitial() + ", level=" + brocoli.getLevel()
                + ") at x=" + consumableField.getConsumablePosition(brocoli)[0] + ", y="
                + consumableField.getConsumablePosition(brocoli)[1]);
        consumableField.addConsumable(rice);
        System.out.println("Consumable added Rice(initial=" + rice.getInitial() + ", level=" + rice.getLevel()
                + ") at x=" + consumableField.getConsumablePosition(rice)[0] + ", y="
                + consumableField.getConsumablePosition(rice)[1]);
        consumableField.addConsumable(mushroom);
        System.out
                .println("Consumable added Mushroom(initial=" + mushroom.getInitial() + ", level=" + mushroom.getLevel()
                        + ") at x=" + consumableField.getConsumablePosition(mushroom)[0] + ", y="
                        + consumableField.getConsumablePosition(mushroom)[1]);

        // combine the two fields into one
        Field field = new Field(heroField, consumableField);

        System.out.println("Game started!");
        // print the initial state of the field
        System.out.println(field.printField());
        while (!isGameFinished) {
            // Проверяваме дали има победител

            Hero[] heroes = heroField.getHeroes();

            // Проверяваме дали има победител
            int aliveHeroes = 0;
            Hero winner = null;
            for (Hero hero : heroes) {
                if (hero == null) {
                    break;
                }
                if (hero.isAlive()) {
                    if (hero.move(field, heroField, consumableField)) {
                        return;
                    }
                }
                if (hero.isAlive()) {
                    aliveHeroes++;
                    winner = hero;
                }
            }
        }

    }

}