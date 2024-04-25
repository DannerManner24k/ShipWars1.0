package dk.geight.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import dk.geight.bullet.Bullet;

public class Weapon {
   private Texture weaponTexture;
   private Bullet bullet;

   public Weapon(Bullet bullet) {
      weaponTexture = new Texture("Weapon/assets/StandardGun.png");
      this.bullet = bullet;
   }

    public Texture getWeaponTexture() {
        return weaponTexture;
    }

    public void dispose() {
        weaponTexture.dispose();
    }
}

