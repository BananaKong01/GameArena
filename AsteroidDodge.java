public class AsteroidDodge { 
    public static void main(String[] args) {
        // Create arena and characters
        GameArena arena = new GameArena(500, 300);
        Spaceship spaceship = new Spaceship(250, 150);
        Asteroid asteroid = new Asteroid(250, 50);
        spaceship.addTo(arena);
        asteroid.addTo(arena);

        while(true) {
            if (arena.rightPressed()) {
                spaceship.move(1, 0);
            }
            if (arena.leftPressed()) {
                spaceship.move(-1, 0);
            }

            asteroid.move(0,1);

            asteroid.checkCollision(spaceship);

            arena.pause(); // Stops from dropping out of main
        }
    }
}