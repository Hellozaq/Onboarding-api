package suai.vladislav.onboardingapi.utils;

import org.slf4j.MDC;

import java.util.UUID;

public class MdcGenerator {

    public static void addSessionUUID() {
        MDC.put("session", UUID.randomUUID().toString());
    }
}
