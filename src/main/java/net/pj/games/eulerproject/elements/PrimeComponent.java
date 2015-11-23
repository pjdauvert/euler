package net.pj.games.eulerproject.elements;


/**
 * 
 * @author pjdauvert
 */
public class PrimeComponent {

    int prime;
    int power;

    public PrimeComponent(int prime, int power) {
        this.prime = prime;
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPrime() {
        return prime;
    }

    public void setPrime(int prime) {
        this.prime = prime;
    }



}
