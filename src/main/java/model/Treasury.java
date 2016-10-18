package model;

class Treasury {
    private int coins;

    public Treasury(int coins) {
        this.coins = coins;
    }

    public Treasury() {
        this(500);
    }

    public int getCoins() {
        return coins;
    }

    public boolean spend(int cost) {
        this.coins -= cost;
        return true;
    }

    public void earn(int pay) {
        this.coins += pay;
    }
}
