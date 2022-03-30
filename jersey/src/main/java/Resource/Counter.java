package Resource;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Counter {

    private LocalDateTime date = LocalDateTime.now();
    private Integer value = 0;

    public String getDate(){
        return date.toString();
    }

    public Integer getValue(){
        return value;
    }

    public void setCounter(Integer nextValue){
        value = nextValue;
        date = LocalDateTime.now();
    }

    public void postCounter(){
        value += 1;
        date = LocalDateTime.now();
    }
    
    public void deleteCounter(Integer subtractionValue){
        value -= subtractionValue;
        date = LocalDateTime.now();
    }

    public void clearCounter(){
        value = 0;
        date = LocalDateTime.now();
    }

}
