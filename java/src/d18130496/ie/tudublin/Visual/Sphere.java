package d18130496.ie.tudublin.Visual;

import processing.core.PApplet;

public class Sphere{

    int x;
    int y;
    int z;

    public Sphere(int x,int y,int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void drawMySelf(PApplet pApplet, float angle,float smoothedBoxSize) {
        pApplet.pushMatrix();
        pApplet.translate(x, y, z);
        pApplet.rotateY(angle);
        pApplet.rotateX(angle);
        pApplet.strokeWeight(1);
        pApplet.sphere(smoothedBoxSize);
        pApplet.popMatrix();
    }
    
}
