package Core;


import Core.screens.StartScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Boot extends Game {

    public static Boot INSTANCE; // Singleton instance
    private int widthScreen, heightScreen; // Screen dimensions
    private OrthographicCamera orthographicCamera; // Camera to render the game

    public Boot() {
        INSTANCE = this;
    }


    @Override
    public void create() {
        this.widthScreen = Gdx.graphics.getWidth();
        this.heightScreen = Gdx.graphics.getHeight();
        this.orthographicCamera = new OrthographicCamera();
        this.orthographicCamera.setToOrtho(false, widthScreen,heightScreen);
        setScreen(new StartScreen(orthographicCamera));
    }
}
