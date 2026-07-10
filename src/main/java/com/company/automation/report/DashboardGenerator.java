package com.company.automation.report;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class DashboardGenerator {

    private DashboardGenerator() {
    }

    public static void generate(List<DeviceSummary> summaries)
            throws IOException {

        StringBuilder html = new StringBuilder();

        html.append("""
                <!DOCTYPE html>
                <html>
                <head>
                    <meta charset="UTF-8">
                    <title>Mobile Automation Dashboard</title>
                
                    <style>
                
                        body{
                
                            font-family:Arial;
                            background:#f5f5f5;
                            padding:40px;
                
                        }
                
                        h1{
                
                            text-align:center;
                
                        }
                
                        .card{
                
                            background:white;
                            border-radius:10px;
                            padding:20px;
                            margin-bottom:20px;
                            box-shadow:0 2px 10px rgba(0,0,0,.15);
                
                        }
                
                        .device{
                
                            font-size:22px;
                            font-weight:bold;
                
                        }
                
                        .summary{
                
                            margin-top:10px;
                            display:flex;
                            gap:30px;
                
                        }
                
                        .button{
                
                            display:inline-block;
                            margin-top:15px;
                            padding:10px 18px;
                            background:#1976d2;
                            color:white;
                            text-decoration:none;
                            border-radius:5px;
                
                        }
                
                        .footer{
                
                            margin-top:40px;
                            font-size:18px;
                            font-weight:bold;
                
                        }
                
                    </style>
                
                </head>
                
                <body>
                
                <h1>📱 Mobile Automation Dashboard</h1>
                
                """);

        int totalPassed = 0;
        int totalFailed = 0;
        int totalBroken = 0;
        int totalSkipped = 0;

        for (DeviceSummary summary : summaries) {

            totalPassed += summary.passed();
            totalFailed += summary.failed();
            totalBroken += summary.broken();
            totalSkipped += summary.skipped();

            html.append("""
                    <div class="card">
                    
                        <div class="device">
                    """);

            html.append(summary.device());

            html.append("""
                    </div>
                    
                    <div class="summary">
                    """);

            html.append("<div>✅ Passed : " + summary.passed() + "</div>");
            html.append("<div>❌ Failed : " + summary.failed() + "</div>");
            html.append("<div>⚠ Broken : " + summary.broken() + "</div>");
            html.append("<div>⏱ Duration : "
                    + format(summary.duration())
                    + "</div>");

            html.append("</div>");

            html.append("""
                    
                    <a class="button"
                       href="./
                    """);

            html.append(summary.device());

            html.append("""
                    /index.html">
                    
                    Open Allure Report
                    
                    </a>
                    
                    </div>
                    """);

        }

        html.append("""
                
                <div class="footer">
                
                Total Passed : 
                """);

        html.append(totalPassed);

        html.append("""
                 |
                Total Failed :
                """);

        html.append(totalFailed);

        html.append("""
                 |
                Broken :
                """);

        html.append(totalBroken);

        html.append("""
                 |
                Skipped :
                """);

        html.append(totalSkipped);

        html.append("""
                
                </div>
                
                </body>
                
                </html>
                
                """);

        Files.writeString(
                Path.of(
                        "reports/index.html"
                ),
                html.toString()
        );

    }

    private static String format(long millis) {

        long seconds =
                millis / 1000;

        long minutes =
                seconds / 60;

        seconds %= 60;

        return String.format(
                "%02d:%02d",
                minutes,
                seconds
        );

    }

}