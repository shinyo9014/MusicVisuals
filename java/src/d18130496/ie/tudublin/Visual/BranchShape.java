package d18130496.ie.tudublin.Visual;

import processing.core.PApplet;

public class BranchShape {
    int flushSize = 200;
    public void drawMySelf(PApplet pApplet,float len,float theta1){
        pApplet.line(0,0,0,-len);
        pApplet.translate(0,-len);
        len*=0.66;
        if(len>2){
            pApplet.pushMatrix();
            pApplet.rotate(theta1);
            drawMySelf(pApplet,len,theta1);
            pApplet.popMatrix();
            pApplet.pushMatrix();
            pApplet.rotate(-theta1);
            drawMySelf(pApplet,len,theta1);
            pApplet.popMatrix();
        }
    }

}
