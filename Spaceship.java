public class Spaceship {
    private Rectangle[] ship = new Rectangle[3]; // Stores all shapes that make up character

    // Constructor method that creates one rectangle that makes up ship
    public Spaceship(int x_spawn, int y_spawn) {
        Rectangle r1 = new Rectangle(x_spawn, y_spawn, 20, 20, "BLUE");
        Rectangle r2 = new Rectangle(x_spawn-20, y_spawn, 20, 20, "RED");
        Rectangle r3 = new Rectangle(x_spawn+20, y_spawn, 20, 20, "RED");
        ship[0] = r1; // Adds new rectangles to end of array
        ship[1] = r2;
        ship[2] = r3;
    }

    // Adds character to game arena
    public void addTo(GameArena arena) {
        for (int i = 0; i < ship.length; i++) {
            arena.addRectangle(ship[i]);
        }
    }

    // Removes character from game arena
    public void removeFrom(GameArena arena) {
        for (int i = 0; i < ship.length; i++) {
            arena.removeRectangle(ship[i]);
        }
    }

    // Moves character relative to current position
    public void move(int move_x, int move_y) {
        for (int i = 0; i < ship.length; i++) {
            ship[i].move(move_x, move_y);
        }
    }

    // Returns each rectangle in array, used to check collisions
    public Rectangle access_collision(int i) {
        return ship[i];
    }

    // Returns number of rectangles in array, used to ensure correct no of loops when checkign collisions
    public int access_length() {
        return ship.length;
    }
}