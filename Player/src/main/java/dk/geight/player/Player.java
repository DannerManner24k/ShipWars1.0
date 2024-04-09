package dk.geight.player;

import com.badlogic.gdx.graphics.Texture;
import dk.geight.character.Character;

public class Player extends Character{
    private Texture playerTexture;

    public Player(int maxHealth, float x, float y) {
        super(maxHealth, x, y);

        playerTexture = new Texture("Player/assets/Character.png");
        // Correct path to your texture file
    }
    public Texture getPlayerTexture() {
        return playerTexture;
    }

    public void dispose() {
        playerTexture.dispose();
    }

}
