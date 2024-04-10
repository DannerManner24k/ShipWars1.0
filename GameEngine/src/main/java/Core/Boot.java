package Core;


import Core.screens.StartScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import GameEngine.CameraMovement;

public class Boot extends Game {

    public static Boot INSTANCE; // Singleton instance
    private int widthScreen, heightScreen; // Screen dimensions
    private CameraMovement cameraMovement; // Camera to render the game

    public Boot() {
        INSTANCE = this;
    }


    @Override
    public void create() {
        this.widthScreen = Gdx.graphics.getWidth();
        this.heightScreen = Gdx.graphics.getHeight();
        this.cameraMovement = new CameraMovement(widthScreen, heightScreen);
        setScreen(new StartScreen(cameraMovement));
    }
}
