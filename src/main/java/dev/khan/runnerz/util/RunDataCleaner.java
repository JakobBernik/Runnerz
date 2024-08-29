package dev.khan.runnerz.util;

import dev.khan.runnerz.run.JdbcClientRunRepository;
import dev.khan.runnerz.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RunDataCleaner {

    private static final Logger log = LoggerFactory.getLogger(RunDataCleaner.class);
    private final JdbcClientRunRepository runRepository;

    public RunDataCleaner(JdbcClientRunRepository runRepository){
        this.runRepository = runRepository;
    }

    public void run(String... args) throws Exception {
        if(runRepository.count() != 0) {
            List<Run> allRuns = runRepository.findAll();
            for (Run run : allRuns) runRepository.delete(run.id());
            System.out.println("cleaned database.");
        }
    }
}
