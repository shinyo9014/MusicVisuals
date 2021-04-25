package d18130496.ie.tudublin.Visual;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;

public class MyVisualOfBands extends Visual {

    public void settings() {
        size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        // fullScreen(P3D, SPAN);
    }

    public void keyPressed() {
        if (key == ENTER) {
            if (!getAudioPlayer().isPlaying()) {
                getAudioPlayer().cue(0);
                getAudioPlayer().play();
            } else {
                getAudioPlayer().pause();
            }

        }

    }

    public void setup() {
        colorMode(HSB);
        noCursor();

        setFrameSize(256);
        sphere1 = new Sphere(100, 0, 0);
        sphere2 = new Sphere(-100, 0, 0);
        startMinim();
        loadAudio("heroplanet.mp3");

        // startListening();

    }

    float radius = 200;

    float smoothedBoxSize = 0;

    float rot = 0;

    float angle = 0;
    float theta1 = 0;
    BranchShape branchShape = new BranchShape();
    Sphere sphere1;
    Sphere sphere2;
    LoveShape loveShape = new LoveShape();

    public void draw() {
        if (getAudioPlayer().isPlaying()) {
            calculateAverageAmplitude();
            try {
                calculateFFT();
            } catch (VisualException e) {
                e.printStackTrace();
            }
            calculateFrequencyBands();
            background(0);
            noFill();
            stroke(255);
            lights();
            stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
            camera(0, -500, 500, 0, 0, 0, 0, 1, 0);
            // translate(0, 0, -250);

            rot += getAmplitude() / 8.0f;

            rotateY(rot);
            float[] bands = getSmoothedBands();
            for (int i = 0; i < bands.length; i++) {
                float theta = map(i, 0, bands.length, 0, TWO_PI);
                theta1 = map(i, 0, bands.length, 0, TWO_PI);
                stroke(map(i, 0, bands.length, 0, 255), 255, 255);
                float x = sin(theta) * radius;
                float z = cos(theta) * radius;
                float h = bands[i];
                pushMatrix();
                translate(x, -h / 2, z);
                rotateY(theta);
                box(50, h, 50);
                branchShape.drawMySelf(this, h, theta1);
                popMatrix();
            }
            float boxSize = 50 + (getAmplitude() * 300);// map(average, 0, 1, 100, 400);
            smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);
            stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
            sphere1.drawMySelf(this, angle, smoothedBoxSize);
            stroke(map(getSmoothedAmplitude(), 1, 1, 1, 255), 255, 255);
            sphere2.drawMySelf(this, angle, smoothedBoxSize);
            loveShape.drawlove(this, (int) boxSize, 0, 0);
        } else {
            fill(0);
            textSize(50);
            text("ENTER TO PLAY THE MUSIC.", width / 8, height / 3);
        }
    }

}