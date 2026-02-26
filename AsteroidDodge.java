import java.util.ArrayList;

public class AsteroidDodge { 
    public static void main(String[] args) {
        // Create arena and game objects
        GameArena arena = new GameArena(500, 300);
        Spaceship spaceship = new Spaceship(250, 250);
        /* Be careful - evenutally it will run out of memory! Fix Later. */
        ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>(); // Array List to spawn as many asteroids as required
        spaceship.addTo(arena);

        // Used for spawn of asteroids
        long lastSpawnTime = System.nanoTime();
        long spawnDelay = 3_000_000_000L;

        while(true) {
            // Controls movement of player
            if (arena.rightPressed()) {
                spaceship.move(1, 0);
            }
            if (arena.leftPressed()) {
                spaceship.move(-1, 0);
            }

            // Controls spawn of asteroids
            long currentTime = System.nanoTime();
            if (currentTime - lastSpawnTime >= spawnDelay) {
                asteroids.add(new Asteroid((int)((Math.random()*500) + 1), 0)); // Randomises x coords
                asteroids.get(asteroids.size()-1).addTo(arena);
                lastSpawnTime = currentTime;
            }

            // Iterate through array and move/check collision for each asteroid
            for (int i = 0; i < asteroids.size(); i++) {
                asteroids.get(i).move(0, 1);
                asteroids.get(i).checkCollision(spaceship, arena);
            }

            arena.pause(); // Stops from dropping out of main
        }
    }
}