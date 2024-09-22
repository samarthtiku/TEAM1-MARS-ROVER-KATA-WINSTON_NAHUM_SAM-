public final class RoverUtilities {

    private RoverUtilities() {} // Private constructor to prevent instantiation

    public static int calculateDistanceTraveled(final int initialX, final int initialY, final Orientation initialOrientation, final String commands) {
        int x = initialX;
        int y = initialY;
        Orientation orientation = initialOrientation;
        int distance = 0;

        for (final char command : commands.toCharArray()) {
            switch (command) {
                case 'L':
                case 'R':
                    orientation = (command == 'L') ? orientation.left() : orientation.right();
                    break;
                case 'M':
                    switch (orientation) {
                        case N: y++; break;
                        case E: x++; break;
                        case S: y--; break;
                        case W: x--; break;
                    }
                    distance++;
                    break;
            }
        }

        return distance;
    }

    public static void distanceCalculation() {
        final String commands = "LMLMLMLMM";
        final int distance = calculateDistanceTraveled(1, 2, Orientation.N, commands);
        System.out.println(StartMain.ANSI_BLUE + "Total distance traveled: " + distance + " units" + StartMain.ANSI_RESET);
    }
}
