import com.sun.jdi.Value;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    
    private AtomicInteger valueOfCounter = new AtomicInteger();
    
    public void setCounter(Integer value){
        valueOfCounter.set(value);
    }
    
    public Integer getCounter(){
        return valueOfCounter.get();
    }
    
    public void postCounter(){
        valueOfCounter.incrementAndGet();
    }
    
    public void deleteCounter(Integer subtractionValue){
        valueOfCounter.addAndGet(-subtractionValue);
    }

    public void clearCounter(){
        valueOfCounter.set(0);
    }
    
}
