package hu.gde.runnersdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RunnerService {

    private final RunnerRepository runnerRepository;

    @Autowired
    public RunnerService(RunnerRepository runnerRepository) {
        this.runnerRepository = runnerRepository;
    }

    public double getAverageLaptime(Long runnerId) {
        RunnerEntity runner = runnerRepository.findById(runnerId).orElse(null);
        if (runner != null) {
            List<LapTimeEntity> laptimes = runner.getLaptimes();
            int totalTime = 0;
            for (LapTimeEntity laptime : laptimes) {
                totalTime += laptime.getTimeSeconds();
            }
            return (double) totalTime / laptimes.size();
        } else {
            return -1.0;
        }
    }
    public long getLargestFootRunnerName() {
        List<RunnerEntity> runners = runnerRepository.findAll();

        if (runners != null) {
            List<Long> shoeSizes = new ArrayList<>();

            for (RunnerEntity runner : runners) {
                Long shoeSize = runner.getShoeSize();
                shoeSizes.add(shoeSize);
            }
        if (!shoeSizes.isEmpty()) {
                Long largestShoeSize = Collections.max(shoeSizes);
           for (RunnerEntity runner : runners) {
         if (runner.getShoeSize().equals(largestShoeSize)) {
                        return runner.getRunnerName();
                    }
            }
        }
    }
        else {
            return null;
    }

}
