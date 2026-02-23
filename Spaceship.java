public class Spaceship {
    // Represents location of character
    private int x = 0;
    private int y = 0;

    private Rectangle[] ship = new Rectangle[4]; // Stores all shapes that make up character

    // Constructor method that creates one rectangle that makes up ship
    public Spaceship(int x_spawn, int y_spawn) {
        Rectangle r = new Rectangle(x_spawn, y_spawn, 20, 20, "BLUE");
        ship[0] = r; // Adds new rectangle to end of array
    }

    // Adds character to game arena
    public void addTo(GameArena arena) {
        for (int i = 0; i < ship.length; i++) {
            arena.addRectangle(ship[i]);
        }
    }

    // Moves character relative to current position
    public void move(int move_x, int move_y) {
        x += move_x;
        y += move_y;
        ship[0].move(move_x, move_y);
    }
}