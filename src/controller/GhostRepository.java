/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.*;
/**
 *
 * @author christos
 */
public class GhostRepository implements Container {
    public Ghost ghosts[] ; //THIS HAS TO CHANGE BASED ON THE BOARD SIZE AND NUMBER OF GHOSTS
    
    public GhostRepository(Ghost ghosts[]){
        this.ghosts=ghosts;
    }
    
    @Override
    public Iterator getIterator(){
        return new GhostIterator();
    }
    
    private class GhostIterator implements Iterator{
        int count=0;
        
        @Override
        public boolean hasNext(){
            if (count < ghosts.length){
                return true;
            }
            return false;
        }
        
        
        @Override
        public Object next(){
            if (this.hasNext()){
                return ghosts[count++]; 
            }
            return null;
        }
    
    }
}
