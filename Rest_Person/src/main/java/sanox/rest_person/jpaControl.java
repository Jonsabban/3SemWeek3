/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanox.rest_person;

import java.util.HashMap;
import javax.persistence.Persistence;

/**
 *
 * @author Sanox
 */
public class jpaControl {
    
    public static void main(String[] args) {
       Persistence.generateSchema("PU", null); 
    }
    
    
}
