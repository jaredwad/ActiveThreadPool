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
public class ActiveThread extends Thread {

   ActiveThread(ActiveThreadPool pPool) {
      pool = pPool;
      queue = new LinkedList<Action>();
      stop = false;
   }

   private Action getNext() {
      if (queue.size() > 0)
         return (Action) queue.poll();

      while (queue.size() == 0) {
         queue = ActiveThreadPool.retreiveFromQueue();
         if (queue.size() > 0)
            return getNext();
         try {
            sleep(500);
         } catch (InterruptedException ex) {
            ex.printStackTrace();
         }
      }
      return null;
   }
   
   public void end(){
      stop = true;
   }

   @Override
   public void run() {
      while (!stop) {
         Action act = getNext();
         act.run();
      }

   }

   private boolean stop;
   private final ActiveThreadPool pool;
   private Queue queue;

}
