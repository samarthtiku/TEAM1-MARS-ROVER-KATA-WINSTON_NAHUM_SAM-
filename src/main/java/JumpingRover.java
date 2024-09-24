public class JumpingRover extends Rover {

    public JumpingRover(String id, int x, int y, Orientation orientation, Plateau plateau) {
        super(id, x, y, orientation, plateau);
    }

    public boolean jumpOverObstacle(Plateau plateau, String commands) {
        for (char command : commands.toCharArray()) {
            if (command == 'J') {
                int nextX = getX() + (getOrientation() == Orientation.EAST ? 1 : 0);
                int nextY = getY() + (getOrientation() == Orientation.NORTH ? 1 : 0);

                if (plateau.hasObstacle(nextX, nextY)) {
                    setPosition(getX() + 2, getY()); // Example jump: move 2 steps forward
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void processCommands(String commands) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'L':
                    rotateLeft();
                    break;
                case 'R':
                    rotateRight();
                    break;
                case 'M':
                    moveForward();
                    break;
                case 'J':
                    jumpOverObstacle(getPlateau(), commands);
                    break;
            }
        }
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position getPosition() {
        return new Position(x, y);
    }
}
