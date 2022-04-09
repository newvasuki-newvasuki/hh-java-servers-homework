package Resource;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    private volatile LocalDateTime date = LocalDateTime.now();
    private AtomicInteger value = new AtomicInteger();

    public String getDate(){
        return date.toString();
    }

    public Integer getValue(){
        return value.get();
    }

    public void setCounter(Integer nextValue){
        synchronized (date) {
            value.set(nextValue);
            date = LocalDateTime.now();
        }
    }

    public void postCounter(){
        synchronized (date) {
            value.incrementAndGet();
            date = LocalDateTime.now();
        }
    }
    
    public void deleteCounter(Integer subtractionValue){
        synchronized (date) {
            value.addAndGet(-subtractionValue);
            date = LocalDateTime.now();
        }
    }

    public void clearCounter(){
        synchronized (date) {
            value.set(0);
            date = LocalDateTime.now();
        }
    }

}
