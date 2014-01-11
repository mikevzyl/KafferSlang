/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kafferslang;

import environment.Environment;
import environment.Grid;
import image.ResourceTools;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author michael
 */
class SnakeEnvironment extends Environment {

    private Grid grid;
    private int score = 0;
    private Slang slang;
    private int delay = 4;
    private int movecounter = delay;

    {
    }

    public SnakeEnvironment() { 
        this.setBackground(ResourceTools.loadImageFromResource("resources/DopeKaffer.jpg"));

        this.grid = new Grid();
        this.grid.setColor(Color.WHITE);
        this.grid.setColumns(40);
        this.grid.setCellHeight(20);
        this.grid.setCellWidth(20);
        this.grid.setPosition(new Point(50, 100));

        this.slang = new Slang();
        this.slang.getBody().add(new Point(5, 5));
        this.slang.getBody().add(new Point(5, 4));
        this.slang.getBody().add(new Point(5, 3));
        this.slang.getBody().add(new Point(4, 3));

    }

    @Override
    public void initializeEnvironment() {
    }

    @Override
    public void timerTaskHandler() {
        System.out.println("Timer");
        if (slang != null) {
            if (moveCounter <= 0){
           slang.move();
           moveCounter = speed; 
            } else {
                moveCounter--;
            }
        }
    }
    private int speed = 5;
    private int moveCounter = speed;  





@Override
        public void keyPressedHandler(KeyEvent e) {
    
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.score += 25;
        } else if (e.getKeyCode() == KeyEvent.VK_M) {
            slang.move();
        }
        else if (e.getKeyCode() == KeyEvent.VK_A) {
           // slang.setdirection()
            slang.move();
        }

        else if (e.getKeyCode() == KeyEvent.VK_M) {
            slang.move();
        }    
         else if (e.getKeyCode() == KeyEvent.VK_G) {
            slang.move();
            
        }
    }

    @Override
        public void keyReleasedHandler(KeyEvent e) {
        
    }

    @Override
        public void environmentMouseClicked(MouseEvent e) {
    }

    @Override
        public void paintEnvironment(Graphics graphics) {
        if (this.grid != null) {
            this.grid.paintComponent(graphics);

            Point cellLocation;
            graphics.setColor(Color.RED);
            if (slang != null) {
                    
                for (int i = 0; i < slang.getBody().size(); i++)  {
                    if (i == 0){ graphics.setColor(Color.yellow);} { 
                    cellLocation = grid.getCellPosition(slang.getBody().get(i));
                    graphics.fillOval(cellLocation.x, cellLocation.y, grid.getCellWidth(), grid.getCellHeight());

                }
            }
        }

        graphics.setFont(new Font("Calibri", Font.ITALIC, 50));
        graphics.drawString("Score: " + this.score, 50, 50);
    }
    }
}
