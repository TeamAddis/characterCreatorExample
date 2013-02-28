import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import sprites.utils.*; 
import sprites.maths.*; 
import sprites.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class characterCreatorExample extends PApplet {





CCharacterFactory factory;

// use as enums. for determining which array list
// is our current focus.
public static final int BODY = 0;
public static final int HEAD = 1;
public static final int HAIR = 2;

public void setup()
{
  size(500, 500, P2D);
  
  factory = new CCharacterFactory(this);
}

public void draw()
{
  background(0xffffffff);
  
  // draw the buttons.
  drawButtons();
  
  // draw the factory.
  factory.draw();
  
  update();
}

public void mousePressed()
{
  // println("The " + mouseButton + " mouse button was pressed.");
}

public void mouseReleased()
{
  // println("The " + mouseButton + " mouse button was released.");
  if (mouseButton == LEFT)
  {
    // println("left button was clicked");
    checkIfMouseOverButtons();
  }
}

public void drawButtons()
{
  // draw buttons for the editor.
  fill(255);
  rect(50, 10, 50, 20);  // head selection button
  rect(110, 10, 50, 20);  // hair selection button
  rect(170, 10, 50, 20);  // body selection button
  rect(250, 10, 50, 20);  // prev button.
  rect(310, 10, 50, 20);  // next button.
  
  fill(0);
  text("head", 55, 25);
  text("hair", 115, 25);
  text("body", 175, 25);
  text("prev", 255, 25);
  text("next", 315, 25);
}

public void update()
{
  
}

// check to see if the mouse is over the buttons.
public void checkIfMouseOverButtons()
{
  if (mouseY > 10 && mouseY < 30)
  {
    if ( (mouseX > 50 && mouseX < 100) )            // head button.
    {
      factory.changeFocus(HEAD);
    }
    else if ( (mouseX > 110 && mouseX < 160) )      // hair button.
    {
      factory.changeFocus(HAIR);
    }
    else if ( (mouseX > 170 && mouseX < 220) )      // body button.
    {
      factory.changeFocus(BODY);
    }
    else if ( (mouseX > 250 && mouseX < 300) )      // prev button.
    {
      factory.prevSprite();
    }
    else if ( (mouseX > 310 && mouseX < 360) )      // next button.
    {
      factory.nextSprite();
    }
  }
}
public class CCharacter
{
  public CCharacter()
  {
  }
}
public class CCharacterBody
{
  public CCharacterBody()
  {
  }
}
public class CCharacterFactory 
{
  private PApplet applet;
  private ArrayList<String> textureFiles;
  private ArrayList<Sprite> bodies;
  private ArrayList<Sprite> heads;
  private ArrayList<Sprite> hairs;
  
  private int currBodyIndex, currHeadIndex, currHairIndex;
  private int currentFocus;   // the currently focused list of sprites to change.
  private String currentMode;
  
  public CCharacterFactory(PApplet applet)
  {
    this.applet = applet;
    currBodyIndex = 0;
    currHeadIndex = 0;
    currHairIndex = 0;
    currentMode = "";
    
    textureFiles = new ArrayList<String>();
    
    bodies = new ArrayList<Sprite>();
    heads = new ArrayList<Sprite>();
    hairs = new ArrayList<Sprite>();
    
    // loadTextureFiles();
    
    loadBodySprites();
    loadHeadSprites();
    loadHairSprites();
  }
  
  public CCharacter build()
  {
    return new CCharacter();
  }
  
  public void draw()
  {
    bodies.get(currBodyIndex).draw();
    heads.get(currHeadIndex).draw();
    hairs.get(currHairIndex).draw();
    
    text(currentMode, applet.width/2, 100);
    
    update();
  }
  
  private void update()
  {
    
    // update the text string displaying the mode.
    
    switch (currentFocus)
    {
      case HEAD:
      {
        currentMode = "Edit Head";
        return;
      }
      case HAIR:
      {
        currentMode = "Edit Hair";
        return;
      }
      case BODY:
      {
        currentMode = "Edit Body";
        return;
      }
      default:
      {
        return;
      }
    }
  }
  
  private void loadTextureFiles()
  {
    BufferedReader reader = createReader("textures.txt");

    String line = "";

    try 
    {
      while (line != null)
      {
        line = reader.readLine();
        textureFiles.add(line);
      }
    }
    catch (IOException e) 
    {
      e.printStackTrace();
    }
  }
  
  private void loadBodySprites()
  {
    Sprite s;
    
    s = new Sprite(applet, "body_1.png", 3, 4, 100, true);
    s.setXY(applet.width/2, applet.height/2);
    s.setFrame(7);
    bodies.add(s);
    
    s = new Sprite(applet, "body_2.png", 3, 4, 100, true);
    s.setXY(applet.width/2, applet.height/2);
    s.setFrame(7);
    bodies.add(s);
    
    s = new Sprite(applet, "body_3.png", 3, 4, 100, true);
    s.setXY(applet.width/2, applet.height/2);
    s.setFrame(7);
    bodies.add(s);
  }
  
  private void loadHeadSprites()
  {
    Sprite s;
    
    s = new Sprite(applet, "head_1.png", 3, 4, 100, true);
    s.setXY(applet.width/2, applet.height/2);
    s.setFrame(7);
    heads.add(s);
    
    s = new Sprite(applet, "head_2.png", 3, 4, 100, true);
    s.setXY(applet.width/2, applet.height/2);
    s.setFrame(7);
    heads.add(s);
    
    s = new Sprite(applet, "head_3.png", 3, 4, 100, true);
    s.setXY(applet.width/2, applet.height/2);
    s.setFrame(7);
    heads.add(s);
  }
  
  private void loadHairSprites()
  {
    Sprite s;
    
    s = new Sprite(applet, "hair_1.png", 3, 4, 100, true);
    s.setXY(applet.width/2, applet.height/2);
    s.setFrame(7);
    hairs.add(s);
    
    s = new Sprite(applet, "hair_2.png", 3, 4, 100, true);
    s.setXY(applet.width/2, applet.height/2);
    s.setFrame(7);
    hairs.add(s);
    
    s = new Sprite(applet, "hair_3.png", 3, 4, 100, true);
    s.setXY(applet.width/2, applet.height/2);
    s.setFrame(7);
    hairs.add(s);
  }
  
  public void changeFocus(int focus)
  {
    currentFocus = focus;
  }
  
  public void nextSprite()
  {
    switch (currentFocus)
    {
      case BODY:
      {
        if (currBodyIndex == bodies.size()-1)
          return;
          
        currBodyIndex++;
        return;
      }
      case HEAD:
      {
        if (currHeadIndex == heads.size()-1)
          return;
          
        currHeadIndex++;
        return;
      }
      case HAIR:
      {
        if (currHairIndex == hairs.size()-1)
          return;
          
        currHairIndex++;
        return;
      }
      default:
      {
        return;
      }
    }
  }
  
  public void prevSprite()
  {
    switch (currentFocus)
    {
      case BODY:
      {
        if (currBodyIndex == 0)
          return;
        
        currBodyIndex--;
        return;
      }
      case HEAD:
      {
        if (currHeadIndex == 0)
          return;
          
        currHeadIndex--;
        return;
      }
      case HAIR:
      {
        if (currHairIndex == 0)
          return;
          
        currHairIndex--;
        return;
      }
      default:
      {
        return;
      }
    }
  }
}
public class CCharacterHair
{
  public CCharacterHair()
  {
  }
}
public class CCharacterHead
{
  public CCharacterHead()
  {
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "characterCreatorExample" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
