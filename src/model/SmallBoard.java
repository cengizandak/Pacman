/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author shan
 */
public class SmallBoard extends Board {

    @Override
    public void setParameters() {
        super.setNumberOfColumns(25);
        super.setNumberOfRows(25);
        super.setNumberOfFruits(3);
        super.setNumberOfGhosts(4);

        //Define the map later
        //char[25][25] map = {{'w', 'f', 'g', 'w', 'w','w', 'f', 'g', 'w', 'w','w', 'f', 'g', 'w', 'w','w', 'f', 'g', 'w', 'w','w', 'f', 'g', 'w', 'w','w', 'f', 'g', 'w', 'w','w', 'f', 'g', 'w', 'w'}}
        //super.setStructure(Structure);
    }

}
