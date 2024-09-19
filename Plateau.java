public  class Plateau {
    //Initialization of width and height of board
    private int width;
    private int height;
    public Plateau(int width, int height){
        this.width = width;
        this.height = height;
    }
    /*
    Check validity of positions
     */
    public boolean isValidPosition(int x, int y){
        if (x >= 0 && x <= width && y >= 0 && y <= height) {
            return true;
        }
        else{
            return false;
        }
    }
}
