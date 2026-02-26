public class Asteroid {
    private Rectangle[] asteroid = new Rectangle[3]; // Stores all shapes that make up character

    // Constructor method that creates one Ball that makes up ship
    public Asteroid(int x_spawn, int y_spawn) {
        Rectangle r1 = new Rectangle(x_spawn, y_spawn, 20, 20, "WHITE");
        Rectangle r2 = new Rectangle(x_spawn-2, y_spawn+5, 20, 20, "WHITE");
        Rectangle r3 = new Rectangle(x_spawn+3, y_spawn-3, 20, 20, "WHITE");
        asteroid[0] = r1; // Adds new Balls to end of array
        asteroid[1] = r2;
        asteroid[2] = r3;
    }

    // Adds character to game arena
    public void addTo(GameArena arena) {
        for (int i = 0; i < asteroid.length; i++) {
            arena.addRectangle(asteroid[i]);
        }
    }

    // Moves character relative to current position
    public void move(int move_x, int move_y) {
        for (int i = 0; i < asteroid.length; i++) {
            asteroid[i].move(move_x, move_y);
        }
    }

    // Checks whether asteroid touches character
    public void checkCollision(Spaceship s, GameArena arena) {
        boolean collision = false;
        for (int i = 0; i < asteroid.length; i++) {
            for (int j = 0; j < s.access_length(); j++) {
                if (asteroid[i].collides(s.access_collision(j))) {
                    collision = true;
                }
            }
        }
        if (collision) {
            s.removeFrom(arena);
        }
    }
}