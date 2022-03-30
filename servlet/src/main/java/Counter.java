import com.sun.jdi.Value;

public class Counter {
    
    private Integer valueOfCounter = 0;
    
    public void setCounter(Integer value){
        valueOfCounter = value;
    }
    
    public Integer getCounter(){
        return valueOfCounter;
    }
    
    public void postCounter(){
        valueOfCounter += 1;
    }
    
    public void deleteCounter(Integer subtractionValue){
        valueOfCounter -= subtractionValue;
    }

    public void clearCounter(){
        valueOfCounter = 0;
    }
    
}
