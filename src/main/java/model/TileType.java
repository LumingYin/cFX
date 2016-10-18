package model;

enum TileType {

    PLAINS('P', "Plains", 1),
    MOUNTAIN('M', "Mountain", 5),
    HILLS('H', "Hills", 3),
    ICE('I', "Ice", 3),
    WATER('W', "Water", 5),
    FOREST('F', "Forest", 2);

    private char symbol;
    private String name;
    private int cost;

    private TileType(char symbol, String name, int cost) {
        this.symbol = symbol;
        this.name = name;
        this.cost = cost;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public String getName() {
        return this.name;
    }

    public int getCost() {
        return this.cost;
    }
}
