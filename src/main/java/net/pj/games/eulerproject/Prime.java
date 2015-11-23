package net.pj.games.eulerproject;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import net.pj.games.eulerproject.elements.BigIntegerPrimeComponent;
import net.pj.games.eulerproject.elements.PrimeComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility Class to calculate Prime numbers with BigIntegers
 *
 * @author pjdauvert
 */
public class Prime {

    private static final Logger log = LoggerFactory.getLogger(Prime.class);

    public static List<BigIntegerPrimeComponent> getPrimeNumbersCompositionOf(BigInteger number) {

        log.debug("Prime composition : ");
        BigIntegerPrimeComponent candidate = new BigIntegerPrimeComponent(BigInteger.ONE, 1);
        List<BigIntegerPrimeComponent> primesComposition = new ArrayList<>();
        primesComposition.add(candidate);

        if (number.isProbablePrime(10)) {
            candidate = new BigIntegerPrimeComponent(number, 1);
            primesComposition.add(candidate);
            log.debug("{} est premier", number.toString());
        } else {
            BigInteger nextPrime = getNextPrimeAfter(BigInteger.ONE);
            BigInteger rest = number;
            while (!rest.equals(BigInteger.ONE)) {
                if (rest.mod(nextPrime).equals(BigInteger.ZERO)) {
                    log.trace("{} is a divider of {}", nextPrime, rest);
                    if (!(candidate.getPrime().compareTo(nextPrime) == 0)) {
                        candidate = new BigIntegerPrimeComponent(nextPrime, 0);
                        primesComposition.add(candidate);
                    }
                    int power = candidate.getPower() + 1;
                    candidate.setPower(power);
                    rest = rest.divide(candidate.getPrime());
                } else {
                    nextPrime = getNextPrimeAfter(nextPrime);
                }
            }
        }
        // log du résultat
        if (log.isDebugEnabled()) {
            final StringBuffer stringResult = new StringBuffer();
            final Iterator<BigIntegerPrimeComponent> primeComposantIterator = primesComposition.iterator();
            BigIntegerPrimeComponent primeComposant;
            while (primeComposantIterator.hasNext()) {
                primeComposant = primeComposantIterator.next();
                stringResult.append(primeComposant.getPrime().toString());
                stringResult.append('^');
                stringResult.append(primeComposant.getPower());
                if (primeComposantIterator.hasNext()) {
                    stringResult.append(" | ");
                }
            }
            log.debug("Result is : [{}]", stringResult.toString());
        }
        return primesComposition;

    }

    public static int countDividersOf(BigInteger number) {

        List<BigIntegerPrimeComponent> primeComposition = getPrimeNumbersCompositionOf(number);
        int power;
        int diviserNumber = 1;
        Iterator<BigIntegerPrimeComponent> primeComposantsIterator = primeComposition.iterator();
        // skip first
        primeComposantsIterator.next();
        BigIntegerPrimeComponent primeComposant;
        while (primeComposantsIterator.hasNext()) {
            primeComposant = primeComposantsIterator.next();
            power = primeComposant.getPower();
            diviserNumber += power * diviserNumber;
        }
        return diviserNumber;
    }

    public static List<BigInteger> getDividersOf(BigInteger number) {

        List<BigIntegerPrimeComponent> primeComposition = getPrimeNumbersCompositionOf(number);
        List<BigInteger> dividers = new ArrayList<BigInteger>();

        BigInteger prime;
        int power;
        for (BigIntegerPrimeComponent primeComposant : primeComposition) {
            prime = primeComposant.getPrime();
            power = primeComposant.getPower();
            if (prime.equals(BigInteger.ONE)) {
                dividers.add(prime);
            } else {
                // Calcul de l'ensemble des diviseurs de ce nombre premier
                List<BigInteger> primaryDividersSublist = new ArrayList<>();
                BigInteger dividerPrime = prime;
                for (int p = 0; p < power; p++) {
                    primaryDividersSublist.add(dividerPrime);
                    dividerPrime = dividerPrime.multiply(prime);
                }
                List<BigInteger> secondaryDividersSublist = new ArrayList<>();
                for (BigInteger divider : dividers) {
                    for (BigInteger primaryDivider : primaryDividersSublist) {
                        secondaryDividersSublist.add(divider.multiply(primaryDivider));
                    }
                }
                log.trace("Adding dividers : {}", secondaryDividersSublist);
                dividers.addAll(secondaryDividersSublist);
            }
        }
        // log du résultat
        if (log.isTraceEnabled()) {
            final StringBuffer stringResult = new StringBuffer();
            final Iterator<BigInteger> dividersIterator = dividers.iterator();
            BigInteger divider;
            while (dividersIterator.hasNext()) {
                divider = dividersIterator.next();
                stringResult.append(divider.toString());
                if (dividersIterator.hasNext()) {
                    stringResult.append(" | ");
                }
            }
            log.trace("Dividers of {} are [{}]", number.toString(), stringResult.toString());
        }
        return dividers;
    }
    
    public static List<Integer> getDividersOf(int number) {
    
        final List<PrimeComponent> factors = listCompositeFactors(number);
        final List<Integer> dividers = new ArrayList<>();
        dividers.add(1);
        int prime;
        int power;
        for (PrimeComponent primeComposant : factors) {
            prime = primeComposant.getPrime();
            power = primeComposant.getPower();
            // Calcul de l'ensemble des diviseurs avec ce nombre premier
            List<Integer> primaryDividersSublist = new ArrayList<>();
                int dividerPrime = prime;
                for (int p = 0; p < power; p++) {
                    primaryDividersSublist.add(dividerPrime);
                    dividerPrime *= prime;
                }
                List<Integer> secondaryDividersSublist = new ArrayList<>();
                for (int divider : dividers) {
                    for (int primaryDivider : primaryDividersSublist) {
                        secondaryDividersSublist.add(divider *primaryDivider);
                    }
                }
                log.trace("Adding dividers : {}", secondaryDividersSublist);
                dividers.addAll(secondaryDividersSublist);
        }
        // log du résultat
        if (log.isTraceEnabled()) {
            final StringBuffer stringResult = new StringBuffer("Dividers of ");
            stringResult.append(String.valueOf(number));
            stringResult.append(" are ");
            stringResult.append( 
                    dividers.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(", "))
            );
            log.trace(stringResult.toString());
        }
        return dividers;
    }

    public static boolean isPrime(BigInteger number) {
        BigInteger init = new BigInteger("2");
        if (number.equals(init)) {
            return true;
        }
        BigInteger max = sqrt(number).add(BigInteger.ONE);
        for (BigInteger i = init; i.compareTo(max) <= 0; i = i.add(BigInteger.ONE)) {
            if (number.mod(i).equals(BigInteger.ZERO)) {
                return false;
            }
        }
        return true;
    }

    private static BigInteger sqrt(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
        while (b.compareTo(a) >= 0) {
            BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
            if (mid.multiply(mid).compareTo(n) > 0) {
                b = mid.subtract(BigInteger.ONE);
            } else {
                a = mid.add(BigInteger.ONE);
            }
        }
        return a.subtract(BigInteger.ONE);
    }

    public static BigInteger calculateFromComposition(List<BigIntegerPrimeComponent> composition) {

        BigInteger result = BigInteger.ONE;
        for (BigIntegerPrimeComponent primeComposite : composition) {
            BigInteger primePowered = primeComposite.getPrime().pow(primeComposite.getPower());
            result = result.multiply(primePowered);
        }
        return result;
    }

    public static BigInteger getSmallestCommonMultipleOf(List<Integer> numbers) {

        List<BigIntegerPrimeComponent> composition = new LinkedList<>();
        for (Integer candidate : numbers) {
            List<BigIntegerPrimeComponent> primeNumbersComposition = getPrimeNumbersCompositionOf(new BigInteger(candidate.toString()));

            for (BigIntegerPrimeComponent candidatePrime : primeNumbersComposition) {
                boolean found = false;
                for (BigIntegerPrimeComponent registeredPrime : composition) {
                    if (registeredPrime.getPrime().compareTo(candidatePrime.getPrime()) == 0) {
                        found = true;
                        if (candidatePrime.getPower() > registeredPrime.getPower()) {
                            registeredPrime.setPower(candidatePrime.getPower());
                        }
                    }
                }
                if (!found) {
                    composition.add(candidatePrime);
                }
            }
        }
        return calculateFromComposition(composition);

    }

    public static List<BigInteger> getPrimesLowerThan(BigInteger number) {

        List<BigInteger> primes = new ArrayList<>();
        primes.add(BigInteger.ONE);
        for (BigInteger i = new BigInteger("2"); i.compareTo(number) <= 0; i = i.add(BigInteger.ONE)) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        log.trace("Primes lower than {} : {}", number.toString(), primes.toString());
        return primes;
    }
    
    	public static BigInteger getNextPrimeAfter(BigInteger number) {

		BigInteger result = number;
		boolean prime = false;
		while (!prime) {
			result = result.add(BigInteger.ONE);
			prime = isPrime(result);
		}
		log.trace("Next prime after {} is {}", number.toString(), result.toString());
		return result;

	}
        
    /**
     * This method provides the list of prime factors in the decomposition of a given number
     * @param number
     * @return the List of prime factors
     */
    public static List listFactors(int number) {

        List factors = new ArrayList();

        int factor = 2;
        int quotien = number;

        while (quotien != 1 && factor != 0) {

            if (quotien % factor == 0) {
                quotien /= factor;
                factors.add(factor);
            } else {
                factor = getNextPrimeAfter(factor, quotien);
            }

        }
        log.trace(factors.toString());
        return factors;

    }
    
    public static List<PrimeComponent> listCompositeFactors(int number){
    
        final List factors = listFactors(number);
        final List componentFactors = new ArrayList(factors.size());
        factors.stream().distinct().forEach(
                c -> {
                    componentFactors.add( 
                            new PrimeComponent(
                                (int) c, 
                                (int)factors.stream().filter(x -> x == c).count())
                    );     
        });
        return componentFactors;
    }

    /**
     * private method to retrieve the next prime number within a given range
     * @param from
     * @param upperbound
     * @return the next prime number or 0 if none found
     */
    public static int getNextPrimeAfter(int from, int upperbound) {

        return IntStream                      //iterate sequentially over int values
                .iterate(from+1, n -> n + 1)    //from lower bound, incremented by 1
                .limit(upperbound)            //to given upperbound
                .filter(x -> isPrime(x))      //filtering primes
                .findFirst()                  //returning the first found
                .orElse(0);                   //or return 0 if none were in the range

    }

    /**
     * private method to check if the given number is prime
     * @param number
     * @return true if number is prime, false otherwise
     */
     public static boolean isPrime(int number) {

        if (number < 1) {
            return false;
        }
        // 1 is prime
        if (number == 1) {
            return true;
        }
        // The limit of iterations is the square root of the checked number.
        // Over that limit, a smaller divider would be found already.
        double sqrt = Math.sqrt(number);
        // if square root is an integer, the number is not prime
        if (sqrt % 1 == 0) {
            return false;
        } //else we start iterations
        else {
            return !IntStream //return opposite of match (divider found means not prime)
                    .iterate(2, n -> n + 1) //iterate incrementing by 1
                    .limit((int)sqrt) //up to integer part of upperbound sqrt 
                    .anyMatch(x -> number % x == 0); //stop when a divider is found
        }
    }
}
