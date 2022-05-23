# What's this

wiringPi for Java by JNA

## Installation

[See Gitlab](https://git.werls.top/root/pi4j/-/packages)
[GitHub use]()
## Usage

```java

class Main {
    public static void main(String[] args) {
        Pi4J pi4J = Pi4j.INSTANCE;
        pi4J.wiringPiSetup4j();
        pi4J.pinMode(15, Pi4j.INPUT);
        // ...
    }
}

```