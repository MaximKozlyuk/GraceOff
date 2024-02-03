package main;

import main.graceoff.HostPingShellTest;

public class Main {

    public static void main(String[] args) {
        var pingTest = new HostPingShellTest("ya.ru");
        pingTest.perform();
    }

}
