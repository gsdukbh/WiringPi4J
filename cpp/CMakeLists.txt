cmake_minimum_required(VERSION 3.18)
project(pi4j)

set(CMAKE_CXX_STANDARD 14)

add_library(pi4j SHARED library.cpp)
include_directories(include)
#find_library(WIRINGPI_LIBRARIES wiringpi lib)
#target_link_libraries(pi4j ${WIRINGPI_LIBRARIES})
