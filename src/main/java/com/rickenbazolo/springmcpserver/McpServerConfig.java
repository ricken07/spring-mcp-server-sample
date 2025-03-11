package com.rickenbazolo.springmcpserver;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.annotation.RegisterReflection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author rickenbazolo
 */
@Configuration(proxyBeanMethods = false)
@RegisterReflection(memberCategories = MemberCategory.INVOKE_DECLARED_METHODS)
public class McpServerConfig {

    @Bean
    ToolCallbackProvider systemToolsProvider(SystemTools systemTools) {
        return MethodToolCallbackProvider.builder().toolObjects(systemTools).build();
    }

}
