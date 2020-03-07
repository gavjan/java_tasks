public class Wielomian{
    private int[] coef;
    private int deg;
    public Wielomian(int ... p){
        coef=new int[p.length];
        for(int i=0; i<p.length; i++){
            coef[i]=p[i];
        }
        deg=degree();
    }
    public int degree(){
        int d=0;
        for(int i=0; i<coef.length; i++)
            if(coef[i] != 0) d=i;
        return d;
    }
    public Wielomian dodaj(Wielomian b){
        Wielomian a=this;
        int n=Math.max(a.deg, b.deg);
        int[] arr;
        arr=new int[n+1];
        Wielomian c=new Wielomian(arr);
        for(int i=0; i <= a.deg; i++) c.coef[i] += a.coef[i];
        for(int i=0; i <= b.deg; i++) c.coef[i] += b.coef[i];
        c.deg=c.degree();
        return c;
    }
    public Wielomian pomnoz(Wielomian b){
        Wielomian a=this;
        int n=a.deg+b.deg;
        int[] arr;
        arr=new int[n+1];
        Wielomian c=new Wielomian(arr);
        for(int i=0; i <= a.deg; i++)
            for(int j=0; j <= b.deg; j++)
                c.coef[i + j] += (a.coef[i] * b.coef[j]);
        c.deg=c.degree();
        return c;
    }
    public int coeff(){return coeff(degree()); }
    public int coeff(int degree){
        return coef[degree];
    }
    // Metoda Hornera
    public int wartosc(double x){
        int p=0;
        for(int i=deg; i >= 0; i--)
            p=(int) (coef[i] + (x * p));
        return p;
    }
    public Wielomian pochodna(){
        if(deg==0) return new Wielomian(0, 0);
        Wielomian deriv=new Wielomian(0, deg - 1);
        deriv.deg=deg - 1;
        for(int i=0; i<deg; i++)
            deriv.coef[i]=(i + 1) * coef[i + 1];
        return deriv;
    }
    public String toString(){
        if(deg==0) {return "" + coef[0];}
        if(deg==1) return coef[1] + "x+" + coef[0];
        String s=(coef[deg]==-1 ? ("-") : (coef[deg]==1 ? "" : coef[deg])) + "x^" + deg;
        for(int i=deg - 1; i >= 0; i--){
            if(i==0) {
                if(coef[i]>0){
                    s=s+ "+" + coef[i];
                }
                else if(coef[i]<0){
                    s=s + "-" + -coef[i];
                }
            }
            else if(coef[i]==0){
                continue;
            }else if(coef[i]>0){
                s=s + "+" + (coef[i]!=1 ? coef[i] : "");
            }else if(coef[i]<0) s=s + "-" + ((coef[i]!=1 ? -coef[i] : ""));
            if(i==1){
                s=s + "x";
            }else if(i>1) s=s + "x^" + i;
        }
        return s;
    }
    public double[] miejscaZerowe() {
        // :(
        double[] a=new double[0];
        return a;
    }
}
