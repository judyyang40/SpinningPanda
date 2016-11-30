import greenfoot.*;

public class WinAction implements Action 
{
    public String getFinalResult() {
        return "win";
    }
    
    public void ExtraAction(Ship s) {
        s.setImage("Treasure.png");
        Greenfoot.delay(80);
    }
}
