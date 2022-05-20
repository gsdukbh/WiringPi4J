package top.werls.pi4j;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jiawei Lee
 * @version TODO
 * @since on  2022/5/20
 */
class Pi4jTest {
    Pi4j pi4j = Pi4j.INSTANCE;

    @Test
    void hello() {
        pi4j.hello();
    }

    @Test
    void wiringPiSetup4j() {
        assert pi4j.wiringPiSetup4j() == 0;
    }

    @Test
    void wiringPiSetupSys4j() {
        assert pi4j.wiringPiSetupSys4j() == 0;
    }

    @Test
    void wiringPiSetupGpio4j() {
        assert pi4j.wiringPiSetupGpio4j() == 0;
    }

    @Test
    void wiringPiSetupPhys4j() {
        assert pi4j.wiringPiSetupPhys4j() == 0;
    }

    @Test
    void pinMode4j() {
        //  pin 15 is fan
        pi4j.wiringPiSetup4j();
        pi4j.pinMode4j(15, Pi4j.INPUT);
    }

    @Test
    void digitalWrite4j() {
        pi4j.wiringPiSetup4j();
        pi4j.digitalWrite4j(15, Pi4j.HIGH);
    }

    @Test
    void pullUpDnControl4j() {
        pi4j.wiringPiSetup4j();
        pi4j.pullUpDnControl4j(15, Pi4j.PUD_DOWN);
    }

    @Test
    void digitalRead4j() {
        pi4j.wiringPiSetup4j();
        assert pi4j.digitalRead4j(15) == Pi4j.HIGH || pi4j.digitalRead4j(15) == Pi4j.LOW;
    }

    @Test
    void digitalRead84j() {
        pi4j.wiringPiSetup4j();
        assert pi4j.digitalRead84j(15) == Pi4j.HIGH || pi4j.digitalRead84j(15) == Pi4j.LOW;
    }

    @Test
    void digitalWrite84j() {
        pi4j.wiringPiSetup4j();
        pi4j.digitalWrite84j(15, Pi4j.HIGH);
    }

    @Test
    void pwmWrite4j() {
        pi4j.wiringPiSetup4j();
        pi4j.pwmWrite4j(15, 20);
    }

    @Test
    void analogRead4j() {
        pi4j.wiringPiSetup4j();
        assert pi4j.analogRead4j(15) >= 0;
    }

    @Test
    void analogWrite4j() {
        pi4j.wiringPiSetup4j();
        pi4j.analogWrite4j(15, 20);
    }

    @Test
    void wiringPiSetupPiFace4j() {
        pi4j.wiringPiSetup4j();
         pi4j.wiringPiSetupPiFace4j() ;
    }

    @Test
    void wiringPiSetupPiFaceForGpioProg4j() {
        pi4j.wiringPiSetup4j();
        pi4j.wiringPiSetupPiFaceForGpioProg4j() ;
    }

    @Test
    void piGpioLayout4j() {
        pi4j.wiringPiSetup4j();
         pi4j.piGpioLayout4j() ;
    }

    @Test
    void piBoardRev4j() {
        pi4j.wiringPiSetup4j();
        pi4j.piBoardRev4j() ;
    }

    @Test
    void wpiPinToGpio4j() {
        pi4j.wiringPiSetup4j();
        System.out.println(pi4j.wpiPinToGpio4j(15));
    }

    @Test
    void physPinToGpio4j() {
        pi4j.wiringPiSetup4j();
        System.out.println(pi4j.physPinToGpio4j(15));
    }

    @Test
    void setPadDrive4j() {
        pi4j.wiringPiSetup4j();
        pi4j.setPadDrive4j(1, Pi4j.PUD_DOWN);
    }

    @Test
    void getAlt4j() {
        pi4j.wiringPiSetup4j();
        System.out.println(pi4j.getAlt4j(15));
    }

    @Test
    void pwmToneWrite4j() {
        pi4j.wiringPiSetup4j();
        pi4j.pwmToneWrite4j(15, 1000);
    }

    @Test
    void pwmSetMode4j() {
        pi4j.wiringPiSetup4j();
        pi4j.pwmSetMode4j(Pi4j.PWM_MODE_MS);
    }

    @Test
    void pwmSetRange4j() {
        pi4j.wiringPiSetup4j();
        pi4j.pwmSetRange4j(1024);
    }

    @Test
    void pwmSetClock4j() {
        pi4j.wiringPiSetup4j();
//        pi4j.pwmSetClock4j(1024);
    }

    @Test
    void gpioClockSet4j() {
        pi4j.wiringPiSetup4j();
        pi4j.gpioClockSet4j(15, 1);
    }

    @Test
    void digitalReadByte4j() {
    }

    @Test
    void digitalReadByte24j() {
    }

    @Test
    void digitalWriteByte4j() {
    }

    @Test
    void digitalWriteByte24j() {
    }

    @Test
    void waitForInterrupt4j() {
    }

    @Test
    void piLock4j() {
    }

    @Test
    void piUnlock4j() {
    }

    @Test
    void piHiPri4j() {
        pi4j.wiringPiSetup4j();
        pi4j.piHiPri4j(15);
    }

    @Test
    void delay4j() {
        pi4j.wiringPiSetup4j();
        pi4j.delay4j(1000);//1s
    }

    @Test
    void delayMicroseconds4j() {
    }

    @Test
    void millis4j() {
        pi4j.wiringPiSetup4j();
        System.out.println(pi4j.millis4j());
    }

    @Test
    void micros4j() {
        pi4j.wiringPiSetup4j();
        System.out.println(pi4j.micros4j());
    }
}