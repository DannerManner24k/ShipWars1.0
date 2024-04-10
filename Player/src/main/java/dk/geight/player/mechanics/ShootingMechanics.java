package dk.geight.player.mechanics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.geight.player.Player;

public class ShootingMechanics{
    private Player player;
    private ShapeRenderer shapeRenderer;

    public ShootingMechanics (Player player) {
        this.player = player;
        shapeRenderer = new ShapeRenderer();
    }

    public void render() {
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.setColor(Color.RED);
            Gdx.gl.glLineWidth(3);
            shapeRenderer.line(player.getPosition().getX()+160, player.getPosition().getY()+115, Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
            shapeRenderer.end();
        }
    }

    public void dispose() {
        shapeRenderer.dispose();
    }
}
