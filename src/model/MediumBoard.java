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
public class MediumBoard extends Board{
    @Override
    public void setParameters(){
        super.setNumberOfColumns(50);
        super.setNumberOfRows(50);
        super.setNumberOfFruits(6);
        super.setNumberOfGhosts(8);
    }
}
