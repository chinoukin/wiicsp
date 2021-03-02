package com.wisea.cultivar.common.mss;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class RemoteCommMageMssConditional implements Condition {
    public RemoteCommMageMssConditional() {
    }

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        return env.containsProperty("wbfc.mss.standards") || env.containsProperty("wbfc.mssurl.standards");
    }
}
