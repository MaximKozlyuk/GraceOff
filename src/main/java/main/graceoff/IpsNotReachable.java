package main.graceoff;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class IpsNotReachable implements ShutDownCondition {

    private final List<URL> addresses = new ArrayList<>();

    public IpsNotReachable(List<URL> urlsToCheck) {
        this.addresses.addAll(urlsToCheck);
    }

    @Override
    public Boolean get() {
        return null;
    }

}
