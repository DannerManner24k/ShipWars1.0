package dk.geight.player.mechanics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;
import dk.geight.player.Player;

public class ShootingMechanics extends InputAdapter {
    private Player player;
    private Vector2 initialClick = new Vector2();
    private Vector2 dragPoint = new Vector2();
    private boolean isDragging = false;
    private float maxDragDistance = 200; // Max drag distance for full power

    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private boolean showShotPath = false;
    private Vector2 shotPathStart = new Vector2();
    private Vector2 shotPathEnd = new Vector2();

    public ShootingMechanics(Player player) {
        this.player = player;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button == 0) { // Left mouse button
            initialClick.set(screenX, screenY);
            isDragging = true;
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (isDragging) {
            dragPoint.set(screenX, screenY);
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (button == 0 && isDragging) {
            isDragging = false;
            Vector2 direction = new Vector2(initialClick).sub(dragPoint);
            float distance = direction.len();
            float power = Math.min(distance / maxDragDistance, 1f); // Normalize the power
            direction.nor(); // Normalize the direction
            shoot(direction, power); // Shoot with the calculated direction and power
        }
        return true;
    }

    public void render() {
        if (showShotPath) {
            Gdx.gl.glLineWidth(2); // Set the line width
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.setColor(Color.RED); // Set the line color
            shapeRenderer.line(shotPathStart.x, shotPathStart.y, shotPathEnd.x, shotPathEnd.y);
            shapeRenderer.end();
        }
    }


    private void shoot(Vector2 direction, float power) {
        // Set the start of the shot path to be the player's position
        shotPathStart.set(player.getPosition().getX(), player.getPosition().getY());

        // Calculate the end point of the shot path based on the power and direction
        shotPathEnd.set(shotPathStart).add(direction.scl(power * 100)); // Adjust multiplier to scale

        // Show the path for visual representation
        showShotPath = true;
    }

    public void hideShotPath() {
        showShotPath = false;
    }

    public void dispose() {
        shapeRenderer.dispose();
    }
}
