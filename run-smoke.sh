##!/bin/bash
#
#echo "=========================="
#echo "Running Smoke Test..."
#echo "=========================="
#
#mvn clean test -Dtest=RunSmokeTest
#
#echo
#echo "=========================="
#echo "Opening Allure Report..."
#echo "=========================="
#
#allure serve allure-results

#!/bin/bash

mvn clean compile

java -cp target/classes \
com.company.automation.launcher.ParallelLauncher