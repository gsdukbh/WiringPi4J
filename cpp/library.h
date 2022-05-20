#ifndef PI4J_LIBRARY_H
#define PI4J_LIBRARY_H
extern "C" {
void hello();
int wiringPiSetup4j(void);
int wiringPiSetupSys4j(void);
int wiringPiSetupGpio4j(void);
int wiringPiSetupPhys4j(void);
void pinMode4j(int pin, int mode);
void pullUpDnControl4j(int pin, int pud);
int digitalRead4j(int pin);
unsigned int digitalRead84j(int pin);
void digitalWrite84j(int pin, int value);
void pwmWrite4j(int pin, int value);
void digitalWrite4j(int pin, int value);
int analogRead4j(int pin);
void analogWrite4j(int pin, int value);
int wiringPiSetupPiFace4j(void);
int wiringPiSetupPiFaceForGpioProg4j(void);    // Don't use this - for gpio program only
int piGpioLayout4j(void);
int piBoardRev4j(void);    // Deprecated
void piBoardId4j(int *model, int *rev, int *mem, int *maker, int *overVolted);
void wiringPiVersion4j(int *major, int *minor);
int wpiPinToGpio4j(int wpiPin);
int physPinToGpio4j(int physPin);
void setPadDrive4j(int group, int value);
int getAlt4j(int pin);
void pwmToneWrite4j(int pin, int freq);
void pwmSetMode4j(int mode);
void pwmSetRange4j(int range);
void pwmSetClock4j(int divisor);
void gpioClockSet4j(int pin, int freq);
unsigned int digitalReadByte4j(void);
unsigned int digitalReadByte24j(void);
void digitalWriteByte4j(int value);
void digitalWriteByte24j(int value);
int waitForInterrupt4j(int pin, int mS);
int wiringPiISR4j(int pin, int mode, void (*function)());
int piThreadCreate4j(void *(*fn)(void *));
void piLock4j(int key);
void piUnlock4j(int key);
int piHiPri4j(int pri);
void delay4j(unsigned int howLong);
void delayMicroseconds4j(unsigned int howLong);
unsigned int millis4j(void);
unsigned int micros4j(void);
}
#endif //PI4J_LIBRARY_H
