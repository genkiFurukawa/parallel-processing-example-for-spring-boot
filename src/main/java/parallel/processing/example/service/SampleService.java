package parallel.processing.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class SampleService {

    @Async
    public CompletableFuture<String> parallelAct() throws InterruptedException {
        log.info(">> Async start");
        Thread.sleep(1 * 1000);
        log.info("<< Async start");
        return CompletableFuture.completedFuture("CompletableFuture");
    }
}
