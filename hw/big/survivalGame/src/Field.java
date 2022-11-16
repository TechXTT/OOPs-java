public class Field {
    private final int height;
    private final int width;
    private final String[][] field;

    public Field(int height, int width) {
        this.height = height;
        this.width = width;
        this.field = new String[height][width];
    }

    public Field(HeroField heroField, ConsumableField consumableField) {
        this.height = heroField.getHeight();
        this.width = heroField.getWidth();
        this.field = new String[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (heroField.getHero(i, j) != null) {
                    this.field[i][j] = heroField.getHero(i, j).getInitial();
                } else if (consumableField.getConsumable(i, j) != null) {
                    this.field[i][j] = consumableField.getConsumable(i, j).getInitial();
                } else {
                    this.field[i][j] = "  ";
                }
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void updateField(HeroField heroField, ConsumableField consumableField) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (heroField.getHero(i, j) != null) {
                    this.field[i][j] = heroField.getHero(i, j).getInitial();
                } else if (consumableField.getConsumable(i, j) != null) {
                    this.field[i][j] = consumableField.getConsumable(i, j).getInitial();
                } else {
                    this.field[i][j] = "  ";
                }
            }
        }
    }

    public String[][] getField() {
        return field;
    }

    public String printField() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < height; i++) {
            sb.append("|");
            for (int j = 0; j < width; j++) {
                sb.append(field[i][j]).append("|");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
