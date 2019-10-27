#!/bin/bash

nohup java -jar /{InstallationDirectory}/reportservice-0.0.1-SNAPSHOT.war /{InstallationDirectory}/logs/nohup.out 2>&1 &
