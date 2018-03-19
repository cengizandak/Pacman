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
public class LargeBoard extends Board{
    @Override
    public void setParameters(){
        super.setNumberOfColumns(100);
        super.setNumberOfRows(100);
        super.setNumberOfFruits(12);
        super.setNumberOfGhosts(16);
    }
}
