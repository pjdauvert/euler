/**
 * 
 */
package net.pj.games.eulerproject.elements;


/**
 * <p>
 */
public class StringNumbers {
	
	private static String UNKNOWN = "unknown";
	private static String[] baseNumbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};
	private static String[] baseTeenPrefixes = {"thir", "four", "fif", "six", "seven", "eigh", "nine"};
	private static String[] baseTenPrefixes = {"thir", "for", "fif", "six", "seven", "eigh", "nine"};
	private static String  AND = " and ";
	private static String  TY = "ty";
	private static String  TEEN = "teen";
	private static String  TWENTY = "twenty";
	private static String  HUNDRED = " hundred";
	private static String  THOUSAND = " thousand ";
	private static String  MILLION = " million ";
	private static String  HYPHEN = "-";
	
	private static int HUNDRED_ = 100;
	private static int THOUSAND_ = 1000;
	private static int MILLION_ = 1000000;
		
	public static String getAsString(int number){
		
		//0 to 12
		if(number>=0 && number <= 12){
			return baseNumbers[number];
		}
		//20
		else if(number == 20){
			return TWENTY;
		}
		//decades from 30 to 90
		else if( number > 20 && number < HUNDRED_ && number%10 == 0){
			int decadeindex = (number/10);
			return baseTenPrefixes[decadeindex-3]+TY;
		}
		//13 to 20
		else if(number>=13 && number <20){
			return baseTeenPrefixes[number-13]+TEEN;
		}
		//21 to 99
		else if( number > 20 && number < HUNDRED_ && number%10 != 0){
			int decade = (number/10)*10;
			int unit = number - decade;
			return getAsString(decade)+HYPHEN+getAsString(unit);
		}
		else if( number >=HUNDRED_ && number<THOUSAND_ ){
			int hundred = (number/HUNDRED_)*HUNDRED_;
			int rest = number - hundred;
			return getAsString(hundred/HUNDRED_)+HUNDRED+(rest==0?"":AND+getAsString(rest));
			
		}
		else if( number >=THOUSAND_ && number<MILLION_ ){
			int thousand = (number/THOUSAND_)*THOUSAND_;
			int rest = number - thousand;
			return getAsString(thousand/THOUSAND_)+THOUSAND+(rest==0?"":getAsString(rest));
			
		}else if( number >=MILLION_ && number<Integer.MAX_VALUE ){
			int million = (number/MILLION_)*MILLION_;
			int rest = number - million;
			return getAsString(million/MILLION_)+MILLION+(rest==0?"":getAsString(rest));
		}
		else{
			return UNKNOWN;
		}
	}
	
	public static int countLettersOfNumber(int number){
		
		if(number<0)return -1;
		String numberAsString = getAsString(number);
		return numberAsString.replaceAll("\\s", "").replaceAll(HYPHEN, "").length();

	}

}
