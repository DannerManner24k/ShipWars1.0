package dk.geight.player.mechanics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import dk.geight.player.Player;

public class ShootingMechanics extends InputAdapter {
    private ShapeRenderer shapeRenderer;
    private Player player;
    private OrthographicCamera camera;
    private Vector2 shotStart;
    private Vector2 shotEnd;
    private boolean isShooting;
    private final float MAX_SHOT_LENGTH = 200f;

    public ShootingMechanics(Player player, OrthographicCamera camera) {
        this.player = player;
        this.camera = camera;
        shapeRenderer = new ShapeRenderer();
        shotStart = new Vector2(player.getPosition().getX(), player.getPosition().getY()); // Assuming getPosition returns a Vector2
        shotEnd = new Vector2();
        isShooting = false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button == Keys.LEFT) {
            // Start shooting
            isShooting = true;
            shotStart.set(player.getPosition().getX(), player.getPosition().getY()); // Set the starting point of the line at the player's position
            return true;
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (button == Keys.LEFT) {
            // Stop shooting
            isShooting = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (isShooting) {
            Vector3 screenCoordinates = new Vector3(screenX, screenY, 0);
            camera.unproject(screenCoordinates); // This converts screen coordinates to world coordinates

            Vector2 worldCoordinates = new Vector2(screenCoordinates.x, screenCoordinates.y);

            // Ensure the shot length does not exceed the maximum length
            if (worldCoordinates.dst(shotStart) > MAX_SHOT_LENGTH) {
                // Calculate the direction vector and set its length to MAX_SHOT_LENGTH
                shotEnd = shotStart.cpy().add(new Vector2(worldCoordinates).sub(shotStart).nor().scl(MAX_SHOT_LENGTH));
            } else {
                shotEnd.set(worldCoordinates);
            }
            return true;
        }
        return false;
    }

    public void render() {
        if (isShooting) {
            shapeRenderer.setProjectionMatrix(camera.combined); // Add this line
            Gdx.gl.glLineWidth(2);
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.setColor(Color.RED);
            shapeRenderer.line(shotStart.x, shotStart.y, shotEnd.x, shotEnd.y);
            shapeRenderer.end();
        }
    }

    public void dispose() {
        shapeRenderer.dispose();
    }
}
