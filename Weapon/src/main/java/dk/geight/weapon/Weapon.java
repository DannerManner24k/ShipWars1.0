package dk.geight.weapon;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import dk.geight.bullet.Bullet;

public class Weapon {
    private float lastFireTime;
    private Bullet bullet; // A prototype Bullet used for cloning when firing

    public Weapon(float fireRate, Bullet bulletPrototype) {
        this.lastFireTime = 0;
        this.bullet = bulletPrototype;
    }

    public boolean canFire() {
        return (TimeUtils.nanoTime() - lastFireTime) / 1_000_000_000 > 1 / bullet.getVelocity();
    }

    public Bullet fire(Vector2 position, Vector2 direction) {
        if (canFire()) {
            lastFireTime = TimeUtils.nanoTime();
            // Create a new bullet based on the prototype
            return new Bullet(
                    bullet.getVelocity(),
                    bullet.getDamage(),
                    position.cpy(), // Copy the position to prevent reference sharing
                    direction.cpy(), // Copy the direction for the same reason
                    bullet.getTexture() // Assuming the bullet texture is shared
            );
        }
        return null;
    }

    // Getters and setters...
}

