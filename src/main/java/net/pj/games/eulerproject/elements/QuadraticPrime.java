package net.pj.games.eulerproject.elements;

import net.pj.games.eulerproject.Prime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Quadratic Prime class with calculation tools
 * @author pjdauvert
 */
public class QuadraticPrime {

    private static final Logger log = LoggerFactory.getLogger(Prime.class);
    private final int a;
    private final int b;
    private final int count;

    public QuadraticPrime(int a, int b) {
        this.a = a;
        this.b = b;
        this.count = countPrimeSequence();
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getCount() {
        return count;
    }
    
    public int value(int n){
        return (int)Math.pow(n, 2) + a*n + b;
    }
    
    public int countPrimeSequenceVerbose(){
    
        int cnt=0;
        int n=0;
        StringBuilder sb = new StringBuilder("Prime sequence for quadratic prime: ");
        sb.append(toString()).append("\n[");
        while(Prime.isPrime(value(n))){
            sb.append(value(n));
            sb.append(", ");
            cnt +=1;
            n+=1;
        }
        sb.replace(sb.length()-2, sb.length(), "]\n");
        sb.append("Count: ");
        sb.append(cnt);
        log.debug(sb.toString());
        return cnt;
    }
    
    private int countPrimeSequence(){
    
        int cnt=0;
        int n=0;
        while(Prime.isPrime(value(n))){
            cnt +=1;
            n+=1;
        }
        return cnt;
    }
    
    @Override
    public String toString(){
    
        StringBuilder sb = new StringBuilder("n² ");
        if(a>0)sb.append("+ ").append(String.valueOf(a));
        else sb.append("- ").append(String.valueOf(-a));
        sb.append("n ");
        if(b>0)sb.append("+ ").append(String.valueOf(b));
        else sb.append("- ").append(String.valueOf(-b));
        return sb.toString();
    
    }
    
}
