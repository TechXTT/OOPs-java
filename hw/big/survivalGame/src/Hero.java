public class Hero {
    private final String name;
    private final String initial;
    private int health;
    private int power;
    private Consumables poison;

    public Hero(String name, String initial, int health, int power) {
        this.name = name;
        this.initial = initial;
        this.health = health;
        this.power = power;
        this.poison = null;
    }

    public String getName() {
        return name;
    }

    public String getInitial() {
        return initial;
    }

    public int getHealth() {
        return health;
    }

    public int getPower() {
        return power;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isAlive() {
        return this.getHealth() > 0;
    }

    public String toString() {
        return this.getName() + " " + this.getHealth() + " " + this.getPower();
    }

    public void weakenPoison() {
        if (this.poison != null) {
            this.poison.setLevel(this.poison.getLevel() - 1);
            if (this.poison.getLevel() == 0) {
                this.poison = null;
            }
        }
    }

    public boolean move(Field field, HeroField heroField, ConsumableField consumableField) {
        // Героя попада на използваемо, използва го
        // Героят попада на друг герой, сбиват се и героя с по-малко сила умира. Ако
        // силата е равна, то тогава умира героя с по-малко кръв. Ако и кръвта е равна,
        // то тогава умират и двамата. Ако някой от героите е консумирал отрова, първо
        // се прилага ефекта на отровата и след това се сбиват.
        // Ако героят е в някой край на полето и не може да мърда в падналата му се
        // посока, тогава той просто не прави нищо. Ако е консумирал отрова, ефекта се
        // прилага
        // Ако кръвта на героя падне под 0 следствие на консумиране на отрова, то той
        // умира.

        // Героят се мести на случаен съседен квадрат
        int[] heroPosition = heroField.getHeroPosition(this);
        int heroX = heroPosition[0];
        int heroY = heroPosition[1];

        int direction = (int) (Math.random() * 4);

        int newX = heroX;
        int newY = heroY;

        switch (direction) {
            case 0:
                newX = heroX - 1;
                System.out.println(this.getName() + " moves UP");
                break;
            case 1:
                newX = heroX + 1;
                System.out.println(this.getName() + " moves DOWN");
                break;
            case 2:
                newY = heroY - 1;
                System.out.println(this.getName() + " moves LEFT");
                break;
            case 3:
                newY = heroY + 1;
                System.out.println(this.getName() + " moves RIGHT");
                break;
        }

        // Проверяваме дали героят може да се мести в новата позиция

        if (newX < 0 || newX >= heroField.getWidth() || newY < 0 || newY >= heroField.getHeight()) {
            return false;
        }

        // Проверяваме дали в новата позиция има друг герой

        Hero otherHero = heroField.getHero(newX, newY);

        // Проверяваме дали героят е консумирал отрова

        if (this.poison != null) {
            this.poison.apply(this);
            this.weakenPoison();
        }

        if (otherHero != null) {
            // Сбиваме героите
            System.out.println(this.getName() + " fights " + otherHero.getName());
            if (this.getPower() > otherHero.getPower()) {
                otherHero.setHealth(0);
            } else if (this.getPower() < otherHero.getPower()) {
                this.setHealth(0);
            } else {
                if (this.getHealth() > otherHero.getHealth()) {
                    otherHero.setHealth(0);
                } else if (this.getHealth() < otherHero.getHealth()) {
                    this.setHealth(0);
                } else {
                    this.setHealth(0);
                    otherHero.setHealth(0);
                }
            }
        } else {
            // Проверяваме дали в новата позиция има използваемо

            Consumables consumable = consumableField.getConsumable(newX, newY);
            if (consumable != null) {
                // Използваме използваемото
                System.out.println(this.getName() + " consumes " + consumable.getName());
                consumable.apply(Hero.this);
                // слагаме poison да е равно на consumable ако е initial "М " или "B " и да е
                // null ако е друго
                if (consumable.getInitial().equals("M ") || consumable.getInitial().equals("B ")) {
                    this.poison = consumable;
                    this.weakenPoison();
                } else {
                    this.poison = null;
                }
                consumableField.removeConsumable(consumable);
            }

            // Преместваме героя
            heroField.moveHero(this, newX, newY);
            heroField.moveHero(null, heroX, heroY);
        }

        field.updateField(heroField, consumableField);
        System.out.println(field.printField());

        // Проверяваме дали героят е умрял

        if (this.getHealth() <= 0 && otherHero != null && otherHero.getHealth() > 0) {
            this.setHealth(0);
            heroField.moveHero(null, heroX, heroY);
            System.out.println(otherHero.getName() + " kills " + this.getName());
            return true;

        }

        if (otherHero != null && otherHero.getHealth() <= 0 && this.getHealth() > 0) {
            otherHero.setHealth(0);
            heroField.moveHero(null, newX, newY);

            return true;
        }

        return false;
    }
}
