/**
 * Write a description of class WinAction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
