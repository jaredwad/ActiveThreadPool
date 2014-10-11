/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package activethreadpool;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Jared
 */
public class ActiveThread extends Thread{
   
   ActiveThread() {
      queue = new LinkedList<Action>();
   }
   
   @Override
   public void run(){
      
   }
   
   private Queue queue;
   
}
