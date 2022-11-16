public class ConsumableField {
    private int height;
    private int width;
    private Consumables[][] field;

    public ConsumableField(int height, int width) {
        this.height = height;
        this.width = width;
        this.field = new Consumables[height][width];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Consumables[][] getField() {
        return field;
    }

    public void setField(Consumables[][] field) {
        this.field = field;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int[] getConsumablePosition(Consumables consumable) {
        for(int i = 0; i < this.getHeight(); i++) {
            for(int j = 0; j < this.getWidth(); j++) {
                if(this.getField()[i][j] == consumable) {
                    return new int[] {j, i};
                }
            }
        }
        return null;
    }

    public int[] addConsumable(Consumables consumable) {
        // x and y are random numbers
        int x = (int)(Math.random() * this.getWidth());
        int y = (int)(Math.random() * this.getHeight());
        while(this.getField()[y][x] != null) {
            x = (int)(Math.random() * this.getWidth());
            y = (int)(Math.random() * this.getHeight());
        }
        this.getField()[y][x] = consumable;

        return new int[] {x, y};
    }

    public void removeConsumable(Consumables consumable) {
        int[] position = this.getConsumablePosition(consumable);
        this.getField()[position[1]][position[0]] = null;
    }

    public Consumables getConsumable(int x, int y) {
        return this.getField()[y][x];
    }
}