package com.rickenbazolo.springmcpserver;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.transport.ServerParameters;
import io.modelcontextprotocol.client.transport.StdioClientTransport;
import io.modelcontextprotocol.spec.McpSchema;

import java.util.Map;

public class MainClientStdio {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        var stdioParams = ServerParameters.builder("java")
                .args("-jar", "target/spring-mcp-server-0.0.1-SNAPSHOT.jar")
                .build();
        stdioParams.getArgs().forEach(System.out::println);

        var transport = new StdioClientTransport(stdioParams);
        var client = McpClient.sync(transport).build();

        client.initialize();

        var toolsList = client.listTools();
        System.out.printf("toolsList = %s%n", toolsList);

        var systemInfo = client.callTool(new McpSchema.CallToolRequest("system_info", Map.of("name", "Ricken Bazolo")));
        System.out.printf("systemInfo = %s%n", systemInfo);

        client.closeGracefully();
    }
}
