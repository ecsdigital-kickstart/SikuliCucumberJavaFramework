package step.pageObject;

import org.sikuli.script.*;
import java.util.logging.Logger;

public class General {

    private String button;
    public Region region;
    public Key key;
    public KeyModifier keymod;

    public void exitApplication (Screen screen) throws FindFailed {
        screen.keyDown(key.ALT);
        screen.keyDown(key.F4);
        screen.keyUp(key.ALT);
        screen.keyUp(key.F4);
    }

    public void clickImageWithinAnImage (String bigImage, String littleImage, Screen screen) throws FindFailed {
        Region area = screen.exists(bigImage, 20);
        area.click(littleImage);
    }

    public void cornerMouseMove (Screen screen) throws FindFailed {
        for(int idx=0; idx < 10; ++idx){
            double x = (int)(Math.random()*((screen.w)+1));
            double y = (int)(Math.random()*((screen.h)+1));
            Region nextPlace = new Region((int)x,(int)y);
            screen.mouseMove(nextPlace);
        }
    }

    public void crazyMouseMove (Screen screen, Logger logger) throws FindFailed {
        Region topLeft = new Region(0,0);
        Region topRight = new Region(screen.w-1,0);
        Region bottomLeft = new Region(0,screen.h-1);
        Region bottomRight = new Region(screen.w-1,screen.h-1);
        Region middle = new Region(screen.w/2,screen.h/2);

        logger.info("Moving to top left");
        screen.mouseMove(topLeft);
        logger.info("Moving to top right");
        screen.mouseMove(topRight);
        logger.info("Moving to bottom left");
        screen.mouseMove(bottomLeft);
        logger.info("Moving to bottom right");
        screen.mouseMove(bottomRight);
        logger.info("Moving to middle");
        screen.mouseMove(middle);
    }
}