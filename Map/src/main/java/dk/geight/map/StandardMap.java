package dk.geight.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StandardMap {

    private final Texture background;
    private final int width, height;

    public StandardMap() {
        // Load the background texture (make sure the path is relative to the assets' directory)
        background = new Texture("Map/assets/MapBackground.png");

        // Initialize your map's width and height
        this.width = background.getWidth();
        this.height = background.getHeight();
    }

    public void render(SpriteBatch batch, int screenWidth, int screenHeight) {

        // Calculate the horizontal and vertical offsets to center the scaled image on the screen
        float offsetX = (screenWidth - width) / 2f;
        float offsetY = -screenHeight / 2f;


        // Draw the background texture
        batch.draw(background, offsetX, offsetY);



        // Draw the background texture
        batch.draw(background, offsetX, -offsetY);
    }

    public void dispose() {
        // Dispose of the background texture when it's no longer needed
        background.dispose();
    }

}
