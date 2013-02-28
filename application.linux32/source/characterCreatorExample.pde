import sprites.utils.*;
import sprites.maths.*;
import sprites.*;

CCharacterFactory factory;

// use as enums. for determining which array list
// is our current focus.
public static final int BODY = 0;
public static final int HEAD = 1;
public static final int HAIR = 2;

void setup()
{
  size(500, 500, P2D);
  
  factory = new CCharacterFactory(this);
}

void draw()
{
  background(0xffffffff);
  
  // draw the buttons.
  drawButtons();
  
  // draw the factory.
  factory.draw();
  
  update();
}

void mousePressed()
{
  // println("The " + mouseButton + " mouse button was pressed.");
}

void mouseReleased()
{
  // println("The " + mouseButton + " mouse button was released.");
  if (mouseButton == LEFT)
  {
    // println("left button was clicked");
    checkIfMouseOverButtons();
  }
}

void drawButtons()
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

void update()
{
  
}

// check to see if the mouse is over the buttons.
void checkIfMouseOverButtons()
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
