package dk.geight.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map {
    private StandardMap standardMap;

    public Map() {
        // Initialize the standard map
        standardMap = new StandardMap();
    }

    public void render(SpriteBatch batch, int  screenWidth, int screenHeight) {
        // Render the standard map
        standardMap.render(batch, screenWidth, screenHeight);
    }

    public void dispose() {
        // Dispose of resources
        standardMap.dispose();
    }
}