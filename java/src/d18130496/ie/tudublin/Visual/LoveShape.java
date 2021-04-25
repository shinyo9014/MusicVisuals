package d18130496.ie.tudublin.Visual;

import processing.core.PApplet;

public class LoveShape {
  void drawlove(PApplet pApplet, int cubesize, int x, int y) {
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 6; j++) {
        if (j == 0) {
          pApplet.pushMatrix();
          pApplet.translate(cubesize * 1, x, y);
          pApplet.box(cubesize);
          pApplet.popMatrix();

          pApplet.pushMatrix();
          pApplet.translate(cubesize * 2, x, y);
          pApplet.box(cubesize);
          pApplet.popMatrix();

          pApplet.pushMatrix();
          pApplet.translate(cubesize * 4, x, y);
          pApplet.box(cubesize);
          pApplet.popMatrix();

          pApplet.pushMatrix();
          pApplet.translate(cubesize * 5, x, y);
          pApplet.box(cubesize);
          pApplet.popMatrix();

        }
        if (j == 1 || j == 2) {
          pApplet.pushMatrix();
          pApplet.translate(i * cubesize, j * cubesize, 0);
          pApplet.box(cubesize);
          pApplet.popMatrix();
        }
        if (j == 3 && i > 0 && i < 6) {
          pApplet.pushMatrix();
          pApplet.translate(i * cubesize, j * cubesize, 0);
          pApplet.box(cubesize);
          pApplet.popMatrix();
        }
        if (j == 4 && i > 1 && i < 5) {
          pApplet.pushMatrix();
          pApplet.translate(i * cubesize, j * cubesize, 0);
          pApplet.box(cubesize);
          pApplet.popMatrix();
        }
        if (j == 5 && i == 3) {
          pApplet.pushMatrix();
          pApplet.translate(i * cubesize, j * cubesize, 0);
          pApplet.box(cubesize);
          pApplet.popMatrix();
        }
      }
    }
  }
}
