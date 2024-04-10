package GameEngine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class CameraMovement {

    //Camera setup
    private final OrthographicCamera camera;
    private final float initialX = 500;

    //Fixed positions
    private float fixedPosition1 = 5000;
    private float fixedPosition2 = 960;
    private boolean isPanning = false;
    private Vector3 targetPosition;


    public CameraMovement(int width, int height) {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);
        this.targetPosition = new Vector3();
        setInitialPosition(initialX);
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    private void setInitialPosition(float x){
        camera.position.set(x, 1080/2, 0);
        camera.update();
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
        handlePanning();
        camera.update();
    }

    private void handlePanning() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
            setTargetPosition(fixedPosition1);
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            setTargetPosition(fixedPosition2);
        }

        if (isPanning) {
            performPanning();
        }
    }

    private void setTargetPosition(float targetX) {
        if (!isPanning || targetPosition.x != targetX) {
            targetPosition.set(targetX, camera.position.y, camera.position.z);
            isPanning = true;
        }
    }

    private void performPanning() {
        if (camera.position.epsilonEquals(targetPosition, 0.1f)) {
            isPanning = false; // Stop panning if close to the target
        } else {
            camera.position.lerp(targetPosition, 0.1f); // Smoothly interpolate to target position
        }
    }




}
