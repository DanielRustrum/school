#!/bin/bash

CWD=$PWD
cd $1/$2
sudo make -f make.m
./$2
cd "$CWD"