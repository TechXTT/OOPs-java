public class HeroField {
    private final int height;
    private final int width;
    private final Hero[][] field;

    public HeroField(int height, int width) {
        this.height = height;
        this.width = width;
        this.field = new Hero[height][width];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Hero[][] getField() {
        return field;
    }

    public int[] getHeroPosition(Hero hero) {
        for(int i = 0; i < this.getHeight(); i++) {
            for(int j = 0; j < this.getWidth(); j++) {
                if(this.getField()[i][j] == hero) {
                    return new int[] {j, i};
                }
            }
        }
        return null;
    }

    public void addHero(Hero hero) {
        // x and y are random numbers
        int x = (int)(Math.random() * this.getWidth());
        int y = (int)(Math.random() * this.getHeight());
        while(this.getField()[y][x] != null) {
            x = (int)(Math.random() * this.getWidth());
            y = (int)(Math.random() * this.getHeight());
        }
        this.getField()[y][x] = hero;

    }

    public void moveHero(Hero hero, int x, int y) {
        int[] heroPosition = this.getHeroPosition(hero);
        this.getField()[heroPosition[1]][heroPosition[0]] = null;
        this.getField()[y][x] = hero;
    }

    public Hero getHero(int x, int y) {
        return this.getField()[y][x];
    }

    public Hero[] getHeroes() {
        Hero[] heroes = new Hero[this.getHeight() * this.getWidth()];
        int index = 0;
        for(int i = 0; i < this.getHeight(); i++) {
            for(int j = 0; j < this.getWidth(); j++) {
                if(this.getField()[i][j] != null) {
                    heroes[index] = this.getField()[i][j];
                    index++;
                }
            }
        }
        return heroes;
    }
}
