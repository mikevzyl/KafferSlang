/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kafferslang;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author michael
 */
public class Slang {

    private ArrayList<Point> body;
    private Direction direction = Direction.RIGHT;
    private int delay;
    private int growthCounter;

    {
        body = new ArrayList<>();
    }

    public void move() {
        // create a new location for the head, using the direction
        int x = 0;
        int y = 0;

        switch (getDirection()) {
            case UP:
                x = 0;
                y = -1;
                break;

            case DOWN:
                x = 0;
                y = 1;
                break;

            case RIGHT:
                x = 1;
                y = 0;
                break;

            case LEFT:
                x = -1;
                y = 0;
                
        }
        
        getBody().add(0, new Point(getHead().x + x, getHead().y + y));
        
        if (growthCounter <= 0) {
            getBody().remove(getBody().size() - 1);
        } else {
            growthCounter--;
        }
    }

    public Point getHead() {
        return getBody().get(0);
    }

    /**
     * @return the body
     */
    public ArrayList<Point> getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(ArrayList<Point> body) {
        this.body = body;
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * @return the delay
     */
    public int getDelay() {
        return delay;
    }

    /**
     * @param delay the delay to set
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }

    /**
     * @return the growthCounter
     */
    public int getGrowthCounter() {
        return growthCounter;
    }

    /**
     * @param growthCounter the growthCounter to set
     */
    public void setGrowthCounter(int growthCounter) {
        this.growthCounter = growthCounter;
    }
}
