package Core;


import Core.screens.StartScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import GameEngine.CameraMovement;

public class Boot extends Game {

    public static Boot INSTANCE; // Singleton instance
    private int widthScreen, heightScreen; // Screen dimensions

    public Boot() {
        INSTANCE = this;
    }


    @Override
    public void create() {
        this.widthScreen = Gdx.graphics.getWidth();
        this.heightScreen = Gdx.graphics.getHeight();
        CameraMovement.initialize(widthScreen, heightScreen);
        setScreen(new StartScreen());
    }
}
