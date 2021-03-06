package eu.noelvaes.housekeeping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class CleaningServiceImpl implements CleaningService{
    @Autowired
    private CleaningTool cleaningTool;
    private double rate;

//    public void setCleaningTool(CleaningTool cleaningTool) {
//        this.cleaningTool = cleaningTool;
//    }
//

    @Value("9")
    public void setRate(double rate) {
        this.rate = rate;
    }

    @PostConstruct
    public void init(){
        System.out.println("Initialising bean CleaningServiceImpl...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("cleaning up bean CleaningServiceImpl..");
    }

    @Override
    public void clean() {
        System.out.println("Cleaning the house");
        cleaningTool.doCleanJob();
    }
}
