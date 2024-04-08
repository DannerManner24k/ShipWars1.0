package Core;

import Core.Boot;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher {

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration(); // Create a new configuration
        config.setIdleFPS(60); // Set the idle FPS
        config.setTitle("ShipWars"); // Set the title

        config.setWindowedMode(1920, 1080); // Set the windowed mode
        new Lwjgl3Application(new Boot(), config); // Create a new Lwjgl3 application
    }
}
