package com.company.automation.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public final class AllureResultModifier {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private AllureResultModifier() {
    }

    public static void modify(File file, String device)
            throws IOException {

        ObjectNode root =
                (ObjectNode) MAPPER.readTree(file);

        String originalName =
                root.path("name").asText();

        String newName =
                originalName + " [" + device + "]";

        root.put("name", newName);

        root.put(
                "historyId",
                root.path("historyId").asText()
                        + "_" + device
        );

        root.put(
                "testCaseId",
                root.path("testCaseId").asText()
                        + "_" + device
        );

        ArrayNode labels =
                (ArrayNode) root.path("labels");

        labels.forEach(label -> {

            ObjectNode object =
                    (ObjectNode) label;

            String name =
                    object.path("name").asText();

            if ("story".equals(name)
                    || "testClass".equals(name)) {

                object.put(
                        "value",
                        newName
                );

            }

        });

        MAPPER.writerWithDefaultPrettyPrinter()
                .writeValue(file, root);

    }

}