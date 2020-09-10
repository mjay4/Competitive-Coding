/*Logic is pretty simple, just lock the mutex before starting any operation, check the condition, if true do the desired task, if not unlock the mutex so it can be used by some other thread. For every mutex repeat the same operation.
One thing to note, if our count is more than n we need to unlock the mutex before it return else it will keep shifting control from one thread to another and won't do anything ie, We will get TLE.
Hope this helps. Let me know if u don't understand something and do upvote if it helps. Thank u .
*/

class FizzBuzz {
    private int n;
    private int count;
    private final Lock mutex = new ReentrantLock(true);
    public FizzBuzz(int n) {
        this.n = n;
        count = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(1>0){
        mutex.lock();
            if(count>n){
                mutex.unlock();
                return;
            }
            if(count%3==0 && count%5!=0){ 
                printFizz.run();
                count++;
            }
        mutex.unlock();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(1>0){
        mutex.lock();
            if(count>n){
                mutex.unlock();
                return;
            }
            if(count%3!=0 && count%5==0){ 
                printBuzz.run();
                count++;
            }
        mutex.unlock();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(1>0){
        mutex.lock();
            if(count>n){
                mutex.unlock();
                return;
            }
            if(count%3==0 && count%5==0){ 
                printFizzBuzz.run();
                count++;
            }
        mutex.unlock();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
       while(1>0){
        mutex.lock();
            if(count>n){
                mutex.unlock();
                return;
            }
            if(count%3!=0 && count%5!=0){ 
                printNumber.accept(count);
                count++;
            }
        mutex.unlock();
       }
    }
}