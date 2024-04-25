package dk.geight.bullet;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bullet {
    private float velocity;
    private int damage;
    private Vector2 position;
    private Vector2 direction;
    private Texture texture;

    public Bullet(float speed, int damage, Vector2 position, Vector2 direction, Texture texture) {
        this.velocity = speed;
        this.damage = damage;
        this.position = position;
        this.direction = direction;
        this.texture = texture;
    }

    public void update(float deltaTime) {
        // Logic to move the bullet each frame
    }

    public void render(SpriteBatch batch) {
        // Logic to draw the bullet
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getDirection() {
        return direction;
    }

    public void setDirection(Vector2 direction) {
        this.direction = direction;
    }

    public Texture getTexture() {
        return texture;
    }

}
