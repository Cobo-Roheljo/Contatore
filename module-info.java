package ThreadContatore;


public class TestContatore {
	
	 
	
	
	public static void main(String args[]) throws InterruptedException {

    // create object of unsafe counter
	TestContatore badCounter = new TestContatore();

    
    Thread thread1 = new Thread(new Runnable() {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                badCounter.increment();
                try {
                	Thread.sleep(100);
            } catch(InterruptedException ie) {
            	
            }
        }
        }
    }
        
    );

    // setup thread2 to decrement the badCounter 200 times
    Thread thread2 = new Thread(new Runnable() {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                badCounter.decrement();
                try {
                	Thread.sleep(100);
            } catch(InterruptedException ie) {
            	
            }
            }
        }
    });

    // run both threads
    thread1.start();
    thread2.start();

    // wait for t1 and t2 to complete.
    thread1.join();
    thread2.join();

    // print final value of counter
    badCounter.printFinalCounterValue();
}
    


}
