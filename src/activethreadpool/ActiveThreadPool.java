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
      absorbSize = 10;
      queue = new LinkedList<Action>();
      numThreads = Runtime.getRuntime().availableProcessors();
   }
   
   ActiveThreadPool(int pAbsorbSize){
      absorbSize = pAbsorbSize;
      queue = new LinkedList<Action>();
      numThreads = Runtime.getRuntime().availableProcessors();
   }

   private static synchronized Queue getQueue(int size) {
      Queue newQueue = new LinkedList<Action>();
      for(int i = 0; i < size; ++i){
         newQueue.add(queue.poll());
      }
      return newQueue;
   }

   public static synchronized Queue retreiveFromQueue() {
      if(queue.size() <= absorbSize)
         return getQueue(queue.size());
      
      else
         return getQueue(queue.size() / numThreads);
   }
   
   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      // TODO code application logic here
   }
   
   private static int absorbSize;
   private static int numThreads;
   private static Queue queue;
   
}
