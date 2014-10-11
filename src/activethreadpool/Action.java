/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package activethreadpool;

/**
 *
 * @author Jared
 */
public class Action{

   Action(Runnable run){
      this(run, null);
   }
   
   Action(Runnable run, Runnable call){
      runnable = run;
      callback = call;
   }
   
   public void run() {
      
      runnable.run();
      if(callback != null)
         callback.run();
      
   }
   
   Runnable runnable;
   Runnable callback;
   
}
