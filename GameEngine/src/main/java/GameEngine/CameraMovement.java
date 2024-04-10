package GameEngine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraMovement {

    private final OrthographicCamera camera;

    public CameraMovement(int width, int height) {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void updateCamera() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        float cameraMoveSpeed = 500; // Adjust as necessary

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            camera.position.x -= cameraMoveSpeed * deltaTime;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            camera.position.x += cameraMoveSpeed * deltaTime;
        }

        camera.position.x = Math.max(camera.position.x, 1920 / 2);
        camera.position.x = Math.min(camera.position.x, 7680 - 1920 / 2);

        camera.update();
    }


}
