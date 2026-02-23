public class AsteroidDodge { 
    public static void main(String[] args) {
        // Create arena and characters
        GameArena arena = new GameArena(500, 300);
        Spaceship spaceship = new Spaceship(250, 150);

        spaceship.addTo(arena);

        while(true) {
            arena.pause(); // Stops from dropping out of main
        }
    }
}