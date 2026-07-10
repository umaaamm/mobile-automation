package com.company.automation.report;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


public final class SummaryReader {

    private static final ObjectMapper mapper =
            new ObjectMapper();


    private SummaryReader() {
    }


    public static DeviceSummary read(
            String device
    ) throws IOException {

        File file =
                new File(
                        "reports/"
                                + device
                                + "/widgets/summary.json"
                );

        JsonNode root =
                mapper.readTree(file);

        JsonNode statistic =
                root.get("statistic");

        JsonNode time =
                root.get("time");

        return new DeviceSummary(
                device,
                statistic.get("passed")
                        .asInt(),
                statistic.get("failed")
                        .asInt(),
                statistic.get("broken")
                        .asInt(),
                statistic.get("skipped")
                        .asInt(),
                time.get("duration")
                        .asLong()
        );

    }

}