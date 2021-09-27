package parallel.processing.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import parallel.processing.example.service.SampleService;

import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
public class SampleController {

    private SampleService sampleService;

    public SampleController(
            SampleService sampleService
    ) {
        this.sampleService = sampleService;
    }

    @GetMapping(value = "")
    public String sample() throws InterruptedException {
        CompletableFuture<String> a = sampleService.parallelAct();
        CompletableFuture<String> b = sampleService.parallelAct();
        CompletableFuture<String> c = sampleService.parallelAct();
        CompletableFuture<String> d = sampleService.parallelAct();
        CompletableFuture<String> e = sampleService.parallelAct();
        CompletableFuture<String> f = sampleService.parallelAct();

        // NOTE: コピペしただけなので何が起きているか要調査
        CompletableFuture.allOf(a, b, c, d, e, f).join();

        return "success";
    }
}
