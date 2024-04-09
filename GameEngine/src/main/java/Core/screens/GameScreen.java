package Core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import org.lwjgl.opengl.GL20;
import dk.geight.player.Player;

import dk.geight.map.Map;

import static Helper.Constants.PPM;

public class GameScreen extends ScreenAdapter {

    private OrthographicCamera camera; // Camera to render the game
    private SpriteBatch batch; // Batch to render the game
    private World world; // Box2D world
    private Box2DDebugRenderer box2DDebugRenderer; // Box2D debug renderer
    private final Map map;
    private Player player;

    public GameScreen(OrthographicCamera camera) {
        this.camera = camera; // Set the camera
        this.batch = new SpriteBatch();// Set the batch
        this.world = new World(new Vector2(0,0), false); // Set the world
        this.box2DDebugRenderer = new Box2DDebugRenderer(); // Set the debug renderer
        this.player = new Player(100, 50, 500); // Replace with actual values

        // Initialize the map
        this.map = new Map();
    }

    private void update() {
        world.step(1/60f, 6, 2); // Update the world
        cameraUpdate(); // Update the camera

        batch.setProjectionMatrix(camera.combined); // Set the batch projection matrix

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) { // If the escape key is pressed
            Gdx.app.exit(); // Exit the game
        }
    }

    private void cameraUpdate() {
        float deltaTime = Gdx.graphics.getDeltaTime(); // Get the time passed since the last frame
        float cameraMoveSpeed = 500; // Set the camera's movement speed (adjust as necessary)

        // Check for left or right arrow key press to move camera left or right
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            camera.position.x -= cameraMoveSpeed * deltaTime;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            camera.position.x += cameraMoveSpeed * deltaTime;
        }

        // Clamp the camera position to ensure it doesn't go past the map edges
        camera.position.x = Math.max(camera.position.x, 1920 / 2); // Half of window width
        camera.position.x = Math.min(camera.position.x, 7680 - 1920 / 2); // Map width minus half window width

        camera.position.set(1920, 1080, 0);

        camera.update(); // Update the camera with the new position
    }


    @Override
    public void render(float delta) {
        this.update();// Update the game
        Gdx.gl.glClearColor(0, 0, 0, 1); // Set the clear color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear the screen

        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();


        batch.begin(); // Begin the batch

        map.render(batch, screenWidth, screenHeight);

        batch.draw(player.getPlayerTexture(), player.getPosition().getX(), player.getPosition().getY()); // Draw the player

        batch.end();// End the batch
        box2DDebugRenderer.render(world, camera.combined.scl(PPM));// Render the Box2D world
    }

    @Override
    public void dispose() {
        // Dispose of resources
        batch.dispose();
        world.dispose();
        map.dispose();
        player.dispose();
        box2DDebugRenderer.dispose();
    }

}
