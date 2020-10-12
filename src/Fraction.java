public class Fraction {
    private int numerator;
    private int denominator;

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) denominator = 1;
        this.denominator = denominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            this.numerator = numerator;
            this.denominator = 1;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public Fraction() {
        this.denominator = 1;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public Fraction reduce() {
        int common = gcd(numerator, denominator);
        numerator /= common;
        denominator /= common;
        return this;
    }

    public Fraction add(Fraction other) {
        numerator = numerator * other.denominator + denominator * other.numerator;
        denominator = denominator * other.denominator;
        return this;
    }

    public Fraction subtract(Fraction other) {
        numerator = numerator * other.denominator - denominator * other.numerator;
        denominator = denominator * other.denominator;
        return this;
    }

   public Fraction multiply(Fraction other) {
        numerator = numerator * other.numerator;
        denominator = denominator * other.denominator;
        return this;
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            return this;
        } else {
            numerator = numerator * other.denominator;
            denominator = denominator * other.numerator;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Fraction) {
            Fraction other = (Fraction) obj;
            return (numerator * other.denominator == other.numerator * denominator);
        }
        return false;
    }

    public String toString() {
        if (numerator % denominator == 0) {
            return numerator + "";
        } else if (denominator < 0) {
            return "-" + numerator + "/" + -denominator;
        } else {
            return numerator + "/" + denominator;
        }
    }

    public static void main(String[] args) {
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(-5, 2);
        Fraction c = new Fraction(0, 2);
        Fraction d = new Fraction(-5, 4);
        Fraction e = new Fraction();
        Fraction f = new Fraction(15, 5);
        f.setDenominator(0);

        System.out.println(a.add(b).reduce().toString());
        System.out.println(a.subtract(b).reduce().toString());
        System.out.println(a.multiply(b).reduce().toString());
        System.out.println(a.divide(c).reduce().toString());
        System.out.println(a.equals(d));
        System.out.println(e);
        System.out.println(f);
    }
}