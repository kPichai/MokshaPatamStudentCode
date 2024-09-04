public class Space {
    private int space;

    // 0 = ladder
    // 1 = snake
    private int type;

    public Space(int s, int t) {
        space = s;
        type = t;
    }

    public int getSpace() {
        return space;
    }

    public int getType() {
        return type;
    }
}
