package snakeladder;

public class Player {
    private String name;

    private int position;
   
    private boolean won;
    public Player(String name) {
        this.name = name;
        this.position = 0;
        this.won = false;
    }
}
