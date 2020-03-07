import java.math.BigInteger;

class Ulamek implements Comparable<Ulamek>{
    private int up;
    private int down;
    public Ulamek(int a) {
        this.up=a;
        this.down=1;
    }
    public Ulamek(int a, int b) {
        int gcd=gcdThing(a,b);
        this.up=a/gcd;
        this.down=b/gcd;
        if(this.down<0) {
            this.up*=-1;
            this.down*=-1;
        }
    }
    private static int gcdThing(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }
    private static int lcm(int a, int b)
    {
        return (a*b)/gcdThing(a, b);
    }
    public Ulamek dodaj(Ulamek b) {
        int d=this.down*b.down;
        int u=this.up*b.down+this.down*b.up;
        return new Ulamek(u,d);
    }
    public Ulamek dodaj(int b) {
        return dodaj(new Ulamek(b,1));
    }
    public Ulamek odejmij(Ulamek b) {
        if(this.down==b.down) {
            int u=this.up-b.up;
            return new Ulamek(u,this.down);
        }
        int d=this.down*b.down;
        int u=this.up*b.down-this.down*b.up;
        return new Ulamek(u,d);
    }
    public Ulamek odejmij(int b) {
        return odejmij(new Ulamek(b,1));
    }
    public Ulamek pomnoz(Ulamek b) {
        return new Ulamek(this.up*b.up,this.down*b.down);
    }
    public Ulamek pomnoz(int b) {
        return pomnoz(new Ulamek(b,1));
    }
    public Ulamek podziel(Ulamek b) {
        return new Ulamek(this.up*b.down, this.down);
    }
    public Ulamek podziel(int b) {
        return pomnoz(new Ulamek(1,b));
    }
    @Override
    public int compareTo(Ulamek o) {
        Ulamek p=this.odejmij(o);
        return p.up;
    }
    public String toString() {
        if(this.up==0) {return "0";}
        if(this.down==1) {return Integer.toString(this.up);}
        return Integer.toString(this.up) + '/' + Integer.toString(this.down);
    }
}

