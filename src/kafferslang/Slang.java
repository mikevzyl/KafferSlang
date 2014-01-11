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
    Direction direction = Direction.RIGHT;

    {
        body = new ArrayList<Point>();
    }

    public void move() {
        // create a new location for the head, using the direction
        int x = 0;
        int y = 0;

        switch (direction) {
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
        
        body.add(0, new Point(getHead().x + x, getHead().y + y));
        // delete tail
        body.remove(body.size() - 1);
    }

    public Point getHead() {
        return body.get(0);
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

    void setdirection(Direction direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
