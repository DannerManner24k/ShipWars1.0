package dk.geight.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dk.geight.character.Character;

public class MyPlayer {
    private Player player;

    public MyPlayer() {
        player = new Player(100, 500, 500);
    }

    public Player getPlayer() {
        return player;
    }

    public void render(SpriteBatch batch, float x, float y) {
        batch.draw(player.getPlayerTexture(), player.getPosition().getX(), player.getPosition().getY());
    }

    public void dispose() {
        player.dispose();
    }
}
