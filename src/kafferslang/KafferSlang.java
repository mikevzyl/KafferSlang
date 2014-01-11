/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kafferslang;

import environment.ApplicationStarter;

/**
 *
 * @author michael
 */
public class KafferSlang {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        ApplicationStarter.run("Kaffer Slang!", new SnakeEnvironment());
    }
}
