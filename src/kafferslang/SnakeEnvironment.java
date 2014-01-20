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
import java.util.ArrayList;

/**
 *
 * @author michael
 */
class SnakeEnvironment extends Environment {

    private Grid grid;
    private int score = 0;
    private Slang slang;
    private ArrayList<Point> apples;
    private ArrayList<Point> poisonbottles;
    private int delay = 4;
    private int moveCounter = delay;


    public SnakeEnvironment() {
        this.setBackground(ResourceTools.loadImageFromResource("resources/DopeKaffer.jpg"));

        this.grid = new Grid();
        this.grid.setColor(Color.WHITE);
        this.grid.setColumns(40);
        this.grid.setRows(23);
        this.grid.setCellHeight(20);
        this.grid.setCellWidth(20);
        this.grid.setPosition(new Point(50, 100));

        this.apples = new ArrayList<Point>();
        for (int i = 0; i < 5; i++) {
            this.apples.add(getRandomGridPoint());
        }

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
//           System.out.println("Timer");
        if (slang != null) {
            if (moveCounter <= 0) {
                slang.move();
                moveCounter = delay;
                checkSnakeIntersection();
            } else {
                moveCounter--;
            }
        }
    }

    private void checkSnakeIntersection() {
        //if the snake location is the same as any apple location then grow body
        //and remove apple, later move the apple and make a sound and increase
        //score.
        for (int i = 0; i < this.apples.size(); i++) {
            if (slang.getHead().equals(this.apples.get(i))) {
                System.out.println("APPLE CHOMP!!");
                this.score += 30;
                this.apples.get(i).setLocation(getRandomGridPoint());
                //grow snake
                if (this.slang.getBody().size() >= 10){
                    this.slang.setGrowthCounter(3);
                } else {
                    this.slang.setGrowthCounter(1);
                }
                //                slang.set
           }
        }
    }
    
    private Point getRandomGridPoint(){
        return new Point((int) (Math.random() * this.grid.getColumns()), (int) (Math.random() * this.grid.getRows()));
    }
        
    
    @Override
    public void keyPressedHandler(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.score += 25;
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            slang.setDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            slang.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            slang.setDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            slang.setDirection(Direction.DOWN);
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


            if (this.apples != null) {
                for (int i = 0; i < this.apples.size(); i++) {
                    this.apples.get(i);
                    GraphicsPalette.drawApple(graphics, this.grid.getCellPosition(this.apples.get(i)), this.grid.getCellSize());
                }
            }

            Point cellLocation;
            graphics.setColor(Color.YELLOW);
            if (slang != null) {
                for (int i = 0; i < slang.getBody().size(); i++) {
                    {
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