package com;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.PrintWriter;

public class TestLauncher {
    public static void main(String[] args) {
        SummaryGeneratingListener statisticsForTests = new SummaryGeneratingListener();
        Launcher launcher = LauncherFactory.create();
//        launcher.registerTestExecutionListeners(statisticsForTests);

        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
//                .listeners()
                .selectors(DiscoverySelectors.selectPackage("com.package1"))
                .selectors(DiscoverySelectors.selectClass(StringUtilsTest.class))
                .build();

//        launcher.execute(request);
        launcher.execute(request, statisticsForTests);

        // For Printed Statistics to console
        statisticsForTests.getSummary().printTo(new PrintWriter(System.out));
    }
}
