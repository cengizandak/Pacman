/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.state;
import controller.Game;
import java.awt.*;

/**
 * @author shan
 */
public class SuccessRender extends RenderingState {

    @Override
    public void display() {
        System.out.println("display success board point...");
    }

    @Override
    public void display(Graphics2D g2d) {

    }

    @Override
    public void display(Graphics2D g2d, Game game) {

    }

}