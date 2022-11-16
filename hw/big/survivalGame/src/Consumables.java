public class Consumables {
    private final String name;
    private final String initial;
    private int level;

    public Consumables(String name, String initial, int level) {
        this.name = name;
        this.initial = initial;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getInitial() {
        return initial;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void apply(Hero hero) {
        switch (this.getInitial()) {
            case "Br" -> hero.setHealth(hero.getHealth() + 2 * this.getLevel());
            case "O " -> {
                hero.setHealth(hero.getHealth() + this.getLevel());
                hero.setPower(hero.getPower() + this.getLevel());
            }
            case "R " -> hero.setPower(hero.getPower() + 2 * this.getLevel());
            case "P " -> hero.setPower(hero.getPower() + 13);
            case "M " -> {
                hero.setHealth(hero.getHealth() - 20);
                if (hero.getHealth() <= 0) {
                    hero.setHealth(0);
                }
            }
            case "B " -> {
                hero.setPower(hero.getPower() - 15);
                if (hero.getPower() < 0) {
                    hero.setPower(0);
                }
            }
        }
        System.out.println("Hero(name=" + hero.getName() + ", initial=" + hero.getInitial() + ", health="
                + hero.getHealth() + ", power=" + hero.getPower() + ")");
    }
}
