package ie.tudublin.D18130496;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;

public class MyVisualOfBands extends Visual {


    public void settings()
    {
        size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        //fullScreen(P3D, SPAN);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            
        }
 
    }

    public void setup()
    {
        colorMode(HSB);
        noCursor();
        
        setFrameSize(256);

        startMinim();
        loadAudio("heroplanet.mp3");
        getAudioPlayer().play();
        //startListening(); 
        
    }

    float radius = 200;

    float smoothedBoxSize = 0;

    float rot = 0;

    public void draw()
    {
        
        
        calculateAverageAmplitude();
        try
        {
            calculateFFT();
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        calculateFrequencyBands();
        background(0);
        noFill();
        stroke(255);
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        camera(0, -500, 500, 0, 0, 0, 0, 1, 0);
        //translate(0, 0, -250);

        rot += getAmplitude() / 8.0f;

        rotateY(rot);
        float[] bands = getSmoothedBands();
        for(int i = 0 ; i < bands.length ; i ++)
        {
            float theta = map(i, 0, bands.length, 0, TWO_PI);
            theta1 = map(i, 0, bands.length, 0, TWO_PI);
            stroke(map(i, 0, bands.length, 0, 255), 255, 255);
            float x = sin(theta) * radius;
            float z = cos(theta) * radius;
            float h = bands[i];
            pushMatrix();
            translate(x, - h / 2 , z);
            rotateY(theta);
            box(50, h, 50);
            branch(h);
            popMatrix();
        }
        float boxSize = 50 + (getAmplitude() * 300);//map(average, 0, 1, 100, 400); 
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);  
            pushMatrix();
            translate(-100, 0, 0);
            rotateY(angle);
            rotateX(angle);
            // box(smoothedBoxSize);
            strokeWeight(1);
            sphere(smoothedBoxSize);
            popMatrix();
            pushMatrix();
            translate(100, 0, 0);
            rotateY(angle);
            rotateX(angle);
            stroke(map(4, 0, bands.length, 0, 255), 255, 255);
            // box(smoothedBoxSize);
            sphere(smoothedBoxSize);
            popMatrix();
            drawlove((int)boxSize,0,0);
            drawlove((int)boxSize,10,100);
    
}


void drawlove(int cubesize,int x, int y)
{
  for(int i=0;i<7;i++)
    {
      for(int j=0;j<6;j++)
      {
        if(j==0)
        {
           pushMatrix();
           translate(cubesize*1,x,y);
           box(cubesize);
           popMatrix();
           
           pushMatrix();
           translate(cubesize*2,x,y);
           box(cubesize);
           popMatrix();
           
           pushMatrix();
           translate(cubesize*4,x,y);
           box(cubesize);
           popMatrix();
           
           pushMatrix();
           translate(cubesize*5,x,y);
           box(cubesize);
           popMatrix();
           
        }
        if(j==1||j==2)
        {
           pushMatrix();
           translate(i*cubesize,j*cubesize,0);
           box(cubesize);
           popMatrix();
        }
        if(j==3&&i>0&&i<6)
        {
          pushMatrix();
           //translate(i*cubesize,0,j*cubesize);
             translate(i*cubesize,j*cubesize,0);
           box(cubesize);
           popMatrix();
        }
        if(j==4&&i>1&&i<5)
        {
          pushMatrix();
            translate(i*cubesize,j*cubesize,0);
           box(cubesize);
           popMatrix();
        }
        if(j==5&&i==3)
        {
          pushMatrix();
            translate(i*cubesize,j*cubesize,0);
           box(cubesize);
           popMatrix();
        }
      }
    }
}

    float angle = 0;
    float theta1 = 0;
    int flushSize = 200;
    void branch(float len){
        line(0,0,0,-len);
        translate(0,-len);
        len*=0.66;
        if(len>2){
          pushMatrix();
          rotate(theta1);
          branch(len);
          popMatrix();
          pushMatrix();
          rotate(-theta1);
          branch(len);
          popMatrix();
        }
    }
}