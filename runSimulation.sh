#!/usr/bin/env bash

rm -rf simulation.txt
find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
    printf "\033[1;32mCompilation successful.\n\033[0m"
    printf "\n"

java tihendri.Simulator.Simulator scenario.txt
if [ -e simulation.txt ]
then 
    printf "\033[1;42mSimulation recorded at simulation.txt.\033[0m"
    printf "\n"
fi
