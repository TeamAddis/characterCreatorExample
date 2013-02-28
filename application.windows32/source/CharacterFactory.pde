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
