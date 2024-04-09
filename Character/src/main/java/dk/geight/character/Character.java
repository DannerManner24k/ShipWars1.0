package dk.geight.character;

import dk.geight.character.details.Health;
import dk.geight.character.details.Position;

public class Character {
    private Health health;
    private Position position;

    public Character(int maxHealth, float x, float y) {
        health = new Health(maxHealth);
        position = new Position(x, y);
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
