package com.rickenbazolo.springmcpserver;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

/**
 * @author rickenbazolo
 */
@Component
class SystemTools {

    @Tool(name = "system_info", description = "Get system information.")
    SystemInfo getSystemInfo(String name) {
        return new SystemInfo(
                System.getProperty("os.name"),
                System.getProperty("os.version"),
                System.getProperty("os.arch"),
                System.getProperty("java.version"),
                System.getProperty("java.vendor")
        );
    }
}

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonClassDescription("A structure holding system information")
record SystemInfo(
        @JsonPropertyDescription("Operating system name")
        String osName,
        @JsonPropertyDescription("Operating system version")
        String osVersion,
        @JsonPropertyDescription("Operating system architecture")
        String osArch,
        @JsonPropertyDescription("Java Virtual Machine name")
        String javaVersion,
        @JsonPropertyDescription("Java Virtual Machine vendor")
        String javaVendor
) {}
