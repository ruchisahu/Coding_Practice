/*
 * https://leetcode.com/problems/valid-number/
 * Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false
 */
public class ValidNumber65 {
	//sol1
	public boolean isNumber1(String s) {
        int i = 0, n = s.length();
        //trim whitespace
        while(i < n && s.charAt(i) == ' ') { i++; }
        //sign
        if(i<n&&(s.charAt(i)== '+' || s.charAt(i) == '-')) i++;
        
        boolean isNumeric = false;
        while(i < n && Character.isDigit(s.charAt(i))) {
            ++i;
            isNumeric = true;
        }
        
        if(i < n && s.charAt(i) == '.') {
            i++;
            while(i < n && Character.isDigit(s.charAt(i))) {
                ++i;
                isNumeric = true;
            }
        }
        
        if(i < n && isNumeric && (s.charAt(i) == 'E' ||s.charAt(i) == 'e')) {
            ++i;
            isNumeric = false;
            if(i<n&&(s.charAt(i)== '+' || s.charAt(i) == '-')) i++;
            while(i < n &&  Character.isDigit(s.charAt(i))) {
                ++i;
                isNumeric = true;
            }
            
        }
        
        while(i < n && s.charAt(i) == ' ') { i++; } 
        return isNumeric && i == n;
    }
	//sol2 state machine
	 public enum States {
         EMPTY,
         INVALID,
         VALID,
         EXPONENT
 }
 
 public class StateMachine {
     private State state;
     public StateMachine() {
         this.state = new EmptyState(true, true);
     }
     
     private abstract class State {
         public States state;
         public abstract State process(char c);
         public States getState() {
             return this.state;
         }
     }
     
     private class InvalidState extends State {
         public InvalidState () {
             super.state = States.INVALID;
         }
         public State process(char c) {
             return this;
         }
     }
     
     private class ExponentState extends State {
         public ExponentState() {
             super.state = States.EXPONENT;
         }
         
         public State process(char c) {
             if(Character.isDigit(c)) {
                 return new ValidState(false, false);
             }
             
             // still in the exponent phase, not quite valid, e.g. e-5 or e+9
             if(c == '-' || c == '+') {
                 return this;
             }
             
             return new InvalidState();
         }
     }
     
     private class ValidState extends State {
         private boolean allowPeriod, allowExponent;
         public ValidState(boolean allowPeriod, boolean allowExponent) {
             super.state = States.VALID;
             this.allowPeriod = allowPeriod;
             this.allowExponent = allowExponent;
         }
         public State process(char c) {
             if(Character.isDigit(c)) {
                 return this;
             }
             
             if((c == 'e' || c == 'E') && this.allowExponent) {
                 return new ExponentState();
             }
             
             if(c == '.' && allowPeriod) {
                 return new ValidState(false, this.allowExponent);
             }
             
             return new InvalidState();
         }
     }
     
     private class EmptyState extends State {
         private boolean allowPeriod, allowSign;
         public EmptyState(boolean allowPeriod, boolean allowSign) {
             super.state = States.EMPTY;
             this.allowPeriod = allowPeriod;
             this.allowSign = allowSign;
         }
         
         public State process(char c) {
             // We haven't seen a period or negative yet and still haven't seen a digit.
             if(c == ' ' && allowPeriod && allowSign) {
                 return this;
             }
             
             if(Character.isDigit(c)) {
                 return new ValidState(this.allowPeriod, true);
             }
             
             if(c == '.' && allowPeriod) {
                 return new EmptyState(false, false);
             }
             
             // If we get the first sign, continue. If we've seen a period this isn't valid.
             if((c == '-' || c == '+' ) && allowSign && allowPeriod) {
                 return new EmptyState(true, false);
             }
             
             return new InvalidState();
         }
     }
     
     public void process(char c) {
         States current = state.getState();
         state = state.process(c);
     }
     
     public States getState() {
         return this.state.getState();
     }
 }
 
 
 public boolean isNumber(String s) {
     StateMachine fsm = new StateMachine();
     String trimmedS = s.trim();
     int index = 0;
     while(fsm.getState() != States.INVALID && index < trimmedS.length()) {
         fsm.process(trimmedS.charAt(index));
         index++;
     }
     
     return fsm.getState() == States.VALID;
 }

	public static void main(String[] args) {
		ValidNumber65  v=new ValidNumber65();
		String s="2e10";
		System.out.println(v.isNumber(s));

	}

}
