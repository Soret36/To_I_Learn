public class Rational {
    private int numerator, denominator;

    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Rational(int numerator, int denominator) {
        if (denominator == 0)  {
            denominator = 1;
        }

        if (denominator < 0) {       
            numerator = numerator * -1;
            denominator = denominator * -1;
        }

        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    public int getNumerator() {
        return this.numerator;
    }
    
    public int getDenominator() {
        return this.denominator;
    }


    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenomiator(int denominator) {
        this.denominator = denominator;
    }

    public void set(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void reduce () {  
        if (numerator != 0) {
            int common = gcd (Math.abs(numerator), denominator); 
            numerator = numerator / common;
            denominator = denominator / common;
        }
    }

    public int gcd (int num1, int num2) {  
            while (num1 != num2)
                if (num1 > num2)
                    num1 = num1 - num2;
                else
                    num2 = num2 - num1;
            return num1;
    }

    public Rational reciprocal (){
      return new Rational(denominator, numerator);
   }
   public String toString () {   
        String result;
        if (numerator == 0)
            result = "0";
        else if (denominator == 1)
            result = numerator + "";
        else
            result = numerator + "/" + denominator;
        return result;
    }
}
