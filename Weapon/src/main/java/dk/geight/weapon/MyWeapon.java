package dk.geight.weapon;

import dk.geight.bullet.Bullet;

public class MyWeapon {
    private Weapon weapon;


    public MyWeapon() {
        weapon = new Weapon();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void dispose() {
        weapon.dispose();
    }
}
