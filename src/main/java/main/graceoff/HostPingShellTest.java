package main.graceoff;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.*;

/**
 * Wrapper for ping test performing with provided ip.
 * For unix systems only.
 */
@Slf4j
public final class HostPingShellTest {

    private final String hostToCheck;

    public HostPingShellTest(String hostToCheck) {
        this.hostToCheck = hostToCheck;
    }

    /**
     * ping host -c 5 -i 0.5
     * Destination Host Unreachable 0 received 100% packet loss
    **/
    public void perform() {

    }

    private String pingHost() {
        try (var executorService = Executors.newSingleThreadExecutor()) {
            var processBuilder = new ProcessBuilder();
            processBuilder.directory(new File("/"))
                .command(String.format("ping %s -c 5 -i 0.5", hostToCheck));
            var process = processBuilder.start();
            var result = process.waitFor(60, TimeUnit.SECONDS);
            log.info("Ping result of " + hostToCheck +" is " + result);
            return new String(process.getInputStream().readAllBytes());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
