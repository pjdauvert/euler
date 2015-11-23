package net.pj.games.eulerproject.elements;

import java.math.BigInteger;

/**
 *
 * @author pjdauvert
 */
public class BigIntegerPrimeComponent {

    BigInteger prime;
    int power;

    public BigIntegerPrimeComponent(BigInteger prime, int power) {
        this.prime = prime;
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public BigInteger getPrime() {
        return prime;
    }

    public void setPrime(BigInteger prime) {
        this.prime = prime;
    }



}
