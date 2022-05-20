package top.werls.pi4j;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * @author leejiawei
 * @version TODO
 * @since on  2022/5/11
 */
public interface Pi4j extends Library {
    //
    // Mask for the bottom 64 pins which belong to the Raspberry Pi
    //	The others are available for the other devices
    int PI_GPIO_MASK = 0xFFFFFFC0;
    // Pin modes
    int INPUT = 0;
    int OUTPUT = 1;
    int PWM_OUTPUT = 2;
    int GPIO_CLOCK = 3;
    int SOFT_PWM_OUTPUT = 4;
    int SOFT_TONE_OUTPUT = 5;
    int PWM_TONE_OUTPUT = 6;

    int LOW = 0;
    int HIGH = 1;

    // Pull up/down/none
    int PUD_OFF = 0;
    int PUD_DOWN = 1;
    int PUD_UP = 2;

    //PWM
    int PWM_MODE_MS = 0;
    int PWM_MODE_BAL = 1;

    // Interrupt levels
    int INT_EDGE_SETUP = 0;
    int INT_EDGE_FALLING = 1;
    int INT_EDGE_RISING = 2;
    int INT_EDGE_BOTH = 3;

    /*
      Pi model types and version numbers
      Intended for the GPIO program Use at your own risk.
      https://www.raspberrypi.com/documentation/computers/raspberry-pi.html#new-style-revision-codes
     */
    int PI_MODEL_A = 0;
    int PI_MODEL_B = 1;
    int PI_MODEL_AP = 2;
    int PI_MODEL_BP = 3;
    int PI_MODEL_2 = 4;
    int PI_ALPHA = 5;
    int PI_MODEL_CM = 6;
    int PI_MODEL_07 = 7;
    int PI_MODEL_3B = 8;
    int PI_MODEL_ZERO = 9;
    int PI_MODEL_CM3 = 10;
    int PI_MODEL_ZERO_W = 12;
    int PI_MODEL_3BP = 13;
    int PI_MODEL_3AP = 14;
    int PI_MODEL_CM3P = 16;
    int PI_MODEL_4B = 17;
    int PI_MODEL_ZERO_2W = 18;
    int PI_MODEL_400 = 19;
    int PI_MODEL_CM4 = 20;

    int PI_VERSION_1 = 0;
    int PI_VERSION_1_1 = 1;
    int PI_VERSION_1_2 = 2;
    int PI_VERSION_2 = 3;

    int PI_MAKER_SONY = 0;
    int PI_MAKER_EGOMAN = 1;
    int PI_MAKER_EMBEST = 2;
    int PI_MAKER_UNKNOWN = 3;


    /**
     * 初始化，
     */
    Pi4j INSTANCE = (Pi4j) Native.load("pi4j", Pi4j.class);

    /**
     * 测试函数
     */
    void hello();

    /**
     * 初始化 wiringPi
     * 始终返回0 ，当出现错误时会终止程序
     * <p>
     * This initialises wiringPi and assumes that the calling program is going to be using the wiringPi pin numbering scheme.
     * This is a simplified numbering scheme which provides a mapping from virtual pin numbers 0 through 16 to the real underlying Broadcom GPIO pin numbers.
     * See the pins page for a table which maps the wiringPi pin number to the Broadcom GPIO pin number to the physical location on the edge connector.
     * This function needs to be called with root privileges.
     *
     * @return 0 on success
     */
    int wiringPiSetup4j();

    /**
     * Identical to above,{@link Pi4j#wiringPiSetup4j()}
     * however it allows the calling programs to use the physical pin numbers on the P1 connector only.
     * As above, this function needs to be called with root privileges, and note that some pins are different from revision 1 to revision 2 boards.
     *
     * @return 0
     */
    int wiringPiSetupSys4j();

    /**
     * 初始化 wiringPi
     * 始终返回0 ，当出现错误时会终止程序
     * 这与上面的相同，但是它允许调用程序直接使用Broadcom GPIO PIN号，而不需要重新映射。
     * This is identical to above, however it allows the calling programs to use the Broadcom GPIO pin numbers directly with no re-mapping.{@link Pi4j#wiringPiSetup4j()}
     * As above, this function needs to be called with root privileges, and note that some pins are different from revision 1 to revision 2 boards.
     *
     * @return 0
     */
    int wiringPiSetupGpio4j();

    /**
     * This initialises wiringPi but uses the /sys/class/gpio interface rather than accessing the hardware directly.
     * This can be called as a non-root user provided the GPIO pins have been exported before-hand using the gpio program.
     * Pin numbering in this mode is the native Broadcom GPIO numbers – the same as wiringPiSetupGpio() above, so be aware of the differences between Rev 1 and Rev 2 boards.
     * <p>
     * Note: In this mode you can only use the pins which have been exported via the /sys/class/gpio interface before you run your program.
     * You can do this in a separate shell-script, or by using the system() function from inside your program to call the gpio program.
     * <p>
     * Also note that some functions have no effect when using this mode as they’re not currently possible to action unless called with root privileges.
     * (although you can use system() to call gpio to set/change modes if needed)
     *
     * @return 0
     */
    int wiringPiSetupPhys4j();

    /**
     * This sets the mode of a pin to either INPUT, OUTPUT, PWM_OUTPUT or GPIO_CLOCK.
     * Note that only wiringPi pin 1 (BCM_GPIO 18) supports PWM output and only wiringPi pin 7 (BCM_GPIO 4) supports CLOCK output modes.
     * <p>
     * This function has no effect when in Sys mode.
     * If you need to change the pin mode, then you can do it with the gpio program in a script before you start your program.
     *
     * @param pin  the pin to set mode for
     * @param mode the mode to set INPUT, OUTPUT, PWM_OUTPUT or GPIO_CLOCK.
     */
    void pinMode4j(int pin, int mode);

    /**
     * Writes the value HIGH or LOW (1 or 0) to the given pin which must have been previously set as an output.
     * <p>
     * WiringPi treats any non-zero number as HIGH, however 0 is the only representation of LOW.
     *
     * @param pin   GPIO
     * @param value (0 is LOW) or HIGH (1 is HIGH)
     */
    void digitalWrite4j(int pin, int value);

    /**
     * This sets the pull-up or pull-down resistor mode on the given pin, which should be set as an input.
     * Unlike the Arduino, the BCM2835 has both pull-up an down internal resistors.
     * The parameter pud should be;
     * PUD_OFF, (no pull up/down), PUD_DOWN (pull to ground) or PUD_UP (pull to 3.3v)
     * The internal pull up/down resistors have a value of approximately 50KΩ on the Raspberry Pi.
     * This function has no effect on the Raspberry Pi’s GPIO pins when in Sys mode.
     * If you need to activate a pull-up/pull-down, then you can do it with the gpio program in a script before you start your program.
     *
     * @param pin GPIO
     * @param pud PUD_OFF, PUD_DOWN, PUD_UP
     */

    void pullUpDnControl4j(int pin, int pud);

    /**
     * This function returns the value read at the given pin.
     * It will be HIGH or LOW (1 or 0) depending on the logic level at the pin.
     * @param pin GPIO
     * @return (0 is LOW) or HIGH (1 is HIGH)
     */
    int digitalRead4j(int pin);

    int digitalRead84j(int pin);

    void digitalWrite84j(int pin, int value);

    /**
     * Writes the value to the PWM register for the given pin.
     * The Raspberry Pi has one on-board PWM pin,
     * pin 1 (BMC_GPIO 18, Phys 12) and the range is 0-1024. Other PWM devices may have other PWM ranges.
     * This function is not able to control the Pi’s on-board PWM when in Sys mode.
     * @param pin GPIO
     * @param value 0-1024
     */
    void pwmWrite4j(int pin, int value);

    /**
     * This returns the value read on the supplied analog input pin.
     * You will need to register additional analog modules to enable this function for devices such as the Gertboard, quick2Wire analog board, etc.
     * @param pin GPIO
     * @return 0-1024
     */
    int analogRead4j(int pin);

    /**
     * This writes the given value to the supplied analog pin.
     * You will need to register additional analog modules to enable this function for devices such as the Gertboard.
     * @param pin GPIO
     * @param value 0-1024
     */
    void analogWrite4j(int pin, int value);

    int wiringPiSetupPiFace4j();

    /**
     *  Don't use this - for gpio program only
     * @return 0
     */
    int wiringPiSetupPiFaceForGpioProg4j();

    int piGpioLayout4j();

    /**
     * This returns the board revision of the Raspberry Pi.
     * It will be either 1 or 2.
     * Some of the BCM_GPIO pins changed number and function when moving from board revision 1 to 2,
     * so if you are using BCM_GPIO pin numbers, then you need to be aware of the differences.
     * @return 1 or 2
     */
    int piBoardRev4j();    // Deprecated

//    void piBoardId4j(int *model, int *rev, int *mem, int *maker, int *overVolted);

//    void wiringPiVersion4j(int *major, int *minor);

    /**
     * This returns the BCM_GPIO pin number of the supplied wiringPi pin.
     * It takes the board revision into account.
     * @param wpiPin wiringPi pin
     * @return BCM_GPIO pin number
     */
    int wpiPinToGpio4j(int wpiPin);

    /**
     * This returns the BCM_GPIO pin number of the supplied physical pin on the P1 connector.
     * @param physPin physical pin
     * @return BCM_GPIO pin number
     */
    int physPinToGpio4j(int physPin);

    /**
     * This sets the “strength” of the pad drivers for a particular group of pins.
     * There are 3 groups of pins and the drive strength is from 0 to 7.
     * Do not use this unless you know what you are doing.
     * @param group group of pins
     * @param value 0-7
     */
    void setPadDrive4j(int group, int value);

    int getAlt4j(int pin);

    void pwmToneWrite4j(int pin, int freq);

    /**
     * The PWM generator can run in 2 modes – “balanced” and “mark:space”.
     * The mark:space mode is traditional, however the default mode in the Pi is “balanced”.
     * You can switch modes by supplying the parameter: PWM_MODE_BAL or PWM_MODE_MS.
     * @param mode PWM_MODE_BAL or PWM_MODE_MS
     */
    void pwmSetMode4j(int mode);

    /**
     * This sets the range register in the PWM generator. The default is 1024.
     * @param range 0-1024
     */
    void pwmSetRange4j(int range);

    /**
     * This sets the divisor for the PWM clock.
     * Note: The PWM control functions can not be used when in Sys mode.
     * To understand more about the PWM system, you’ll need to read the Broadcom ARM peripherals manual.
     * @param divisor
     */
    void pwmSetClock4j(int divisor);

    void gpioClockSet4j(int pin, int freq);

    int digitalReadByte4j();

    int digitalReadByte24j();

    /**
     * This writes the 8-bit byte supplied to the first 8 GPIO pins.
     * It’s the fastest way to set all 8 bits at once to a particular value,
     * although it still takes two write operations to the Pi’s GPIO hardware.
     * @param value 0-255
     */
    void digitalWriteByte4j(int value);

    void digitalWriteByte24j(int value);

    int waitForInterrupt4j(int pin, int mS);

//    int wiringPiISR4j(int pin, int mode, void (*function)());

//    int piThreadCreate4j(void *(*fn)(void *));

    void piLock4j(int key);

    void piUnlock4j(int key);

    /**
     * This attempts to shift your program (or thread in a multi-threaded program)
     * to a higher priority and enables a real-time scheduling.
     * The priority parameter should be from 0 (the default) to 99 (the maximum).
     * This won’t make your program go any faster,
     * but it will give it a bigger slice of time when other programs are running.
     * The priority parameter works relative to others –
     * so you can make one program priority 1 and another priority 2 and it will have the same effect as setting one to 10 and the other to 90
     * (as long as no other programs are running with elevated priorities)
     *
     * The return value is 0 for success and -1 for error.
     * If an error is returned, the program should then consult the errno global variable, as per the usual conventions.
     *
     * Note: Only programs running as root can change their priority. If called from a non-root program then nothing happens.
     *
     * @param pri 0-99
     * @return 0 if OK, -1 if error
     */
    int piHiPri4j(int pri);

    /**
     * This causes program execution to pause for at least howLong milliseconds.
     * Due to the multi-tasking nature of Linux it could be longer.
     * Note that the maximum delay is an unsigned 32-bit integer or approximately 49 days.
     * @param howLong milliseconds
     */
    void delay4j(int howLong);

    /**
     * This causes program execution to pause for at least howLong microseconds.
     * Due to the multi-tasking nature of Linux it could be longer.
     * Note that the maximum delay is an unsigned 32-bit integer microseconds or approximately 71 minutes.
     *
     * Delays under 100 microseconds are timed using a hard-coded loop continually polling the system time,
     * Delays over 100 microseconds are done using the system nanosleep() function
     * – You may need to consider the implications of very short delays on the overall performance of the system,
     * especially if using threads.
     *
     * @param howLong microseconds
     */
    void delayMicroseconds4j(int howLong);

    /**
     * This returns a number representing the number of milliseconds
     * since your program called one of the wiringPiSetup functions.
     * It returns an unsigned 32-bit number which wraps after 49 days.
     *
     * @return bit 32-bits
     */
    int millis4j();

    /**
     * This returns a number representing the number of microseconds since your
     * program called one of the wiringPiSetup functions.
     * It returns an unsigned 32-bit number which wraps after approximately 71 minutes.
     *
     * @return bit 32-bits
     */
    int micros4j();
}
