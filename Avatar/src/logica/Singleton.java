/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JOptionPane;

/**
 *
 * @author Caribe
 */
public final class Singleton extends Observable{
    private static Singleton instance;
    private ArrayList<Avatar> theListAvatar;               

    private Singleton() {        
        theListAvatar = new ArrayList<>();
    }
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    
    public void AddAvatarToList(Avatar theAvatar){

        for (Avatar avatar : theListAvatar) {
            if (avatar.getUserName().trim().toUpperCase().equals(theAvatar.getUserName().trim().toUpperCase())) {
                JOptionPane.showMessageDialog(null, "El avatar ya existe", "Warning", JOptionPane.WARNING_MESSAGE );
                return;
            }
        }
        
        theListAvatar.add(theAvatar);
        setChanged();
        notifyObservers();
    }            

    public ArrayList<Avatar> getTheListAvatar() {
        return theListAvatar;
    }
    
    
}
