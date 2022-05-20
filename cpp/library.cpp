#include "library.h"

#include <iostream>
#include <math.h>
#include <wiringPi.h>
using namespace std;
void hello() {
  cout << "Hello, World this c" << endl;
}
int wiringPiSetup4j(void) {
  return wiringPiSetup();
}
int wiringPiSetupSys4j(void) {
  return wiringPiSetupSys();
}
int wiringPiSetupGpio4j(void) {
  return wiringPiSetupGpio();
}
int wiringPiSetupPhys4j(void) {
  return wiringPiSetupPhys();
}
void pinMode4j(int pin, int mode) {
  pinMode(pin, mode);
}
void pullUpDnControl4j(int pin, int pud) {
  pullUpDnControl(pin, pud);
}
int digitalRead4j(int pin) {
  return digitalRead(pin);
}
unsigned int digitalRead84j(int pin) {
  return digitalRead(pin);
}
void digitalWrite84j(int pin, int value) {
  digitalWrite(pin, value);
}

void digitalWrite4j(int pin, int value) {
  digitalWrite(pin, value);
}
void pwmWrite4j(int pin, int value) {
  pwmWrite(pin, value);
}
int analogRead4j(int pin) {
  return analogRead(pin);
}
void analogWrite4j(int pin, int value) {
  analogWrite(pin, value);
}
int wiringPiSetupPiFace4j(void) {
  return wiringPiSetupPiFace();
}
int wiringPiSetupPiFaceForGpioProg4j(void) {
  return wiringPiSetupPiFaceForGpioProg();
}
int piGpioLayout4j(void) {
  return piGpioLayout();
}
int piBoardRev4j(void) {
  return piBoardRev();
}
void piBoardId4j(int *model, int *rev, int *mem, int *maker, int *overVolted) {
  piBoardId(model, rev, mem, maker, overVolted);
}
void wiringPiVersion4j(int *major, int *minor) {
  wiringPiVersion(major, minor);
}
int wpiPinToGpio4j(int wpiPin) {
  return wpiPinToGpio(wpiPin);
}
int physPinToGpio4j(int physPin) {
  return physPinToGpio(physPin);
}
void setPadDrive4j(int group, int value) {
  setPadDrive(group, value);
}
int getAlt4j(int pin) {
  return getAlt(pin);
}
void pwmToneWrite4j(int pin, int freq) {
  pwmToneWrite(pin, freq);
}
void pwmSetMode4j(int mode) {
  pwmSetMode(mode);
}
void pwmSetRange4j(int range) {
  pwmSetRange(range);
}
void pwmSetClock4j(int divisor) {
  pwmSetClock(divisor);
}
void gpioClockSet4j(int pin, int freq) {
  gpioClockSet(pin, freq);
}
unsigned int digitalReadByte4j(void) {
  return digitalReadByte();
}
unsigned int digitalReadByte24j(void) {
  return digitalReadByte();
}
void digitalWriteByte4j(int value) {
  digitalWriteByte(value);
}
void digitalWriteByte24j(int value) {
  digitalWriteByte(value);
}
int waitForInterrupt4j(int pin, int mS) {
  return waitForInterrupt(pin, mS);
}
int wiringPiISR4j(int pin, int mode, void (*function)()) {
  return wiringPiISR(pin, mode, function);
}
int piThreadCreate4j(void *(*fn)(void *)) {
  return piThreadCreate(fn);
}
void piLock4j(int key) {
  piLock(key);
}
void piUnlock4j(int key) {
  piUnlock(key);
}
int piHiPri4j(int pri) {
  return piHiPri(pri);
}

void delay4j(unsigned int howLong) {
  delay(howLong);
}
void delayMicroseconds4j(unsigned int howLong) {
  delayMicroseconds(howLong);
}
unsigned int millis4j(void) {
  return millis();
}
unsigned int micros4j(void) {
  return micros();
}