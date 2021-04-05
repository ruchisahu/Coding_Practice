package snakeladder;

public class Board {
    private int size;
    private int start;
    private int end;

    public Board(int size) {
        this.start = 1;
        this.end = start + size - 1;
        this.size = size;
    }

	public int getStart() {
		// TODO Auto-generated method stub
		return start;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}
}
