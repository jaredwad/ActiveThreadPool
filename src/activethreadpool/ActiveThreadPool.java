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
public class ActiveThreadPool {

   ActiveThreadPool(){
      queue = new LinkedList<Action>();
   }
   
   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      // TODO code application logic here
   }
   
   private Queue queue;
   
}
