package progfigurageometrica;

public class FiguraGeometrica {
    
    char tipo;
    double a,b,c;
    
    FiguraGeometrica() {
        
    } 
    
    // costruttore vero
    FiguraGeometrica(char t, double a, double b, double c) {
        this.tipo=t;
        this.a=a;
        this.b=b;
        this.c=c;
    } 
    
    // getter
    public double getA() {
        return(this.a);
    }
    public double getB() {
        return(this.b);
    }
    public double getC() {
        return(this.c);
    }
    public char getTipo() {
        return(this.tipo);
    }
    
    // setter
    public void setTipo(char t) {
        this.tipo=t;
    }
    public void setA(double a) {
        this.a=a;
    }
    public void setB(double b) {
        this.b=b;
    }
    public void setC(double c) {
        this.c=c;
    }
    
    public String Stato() {
        String s="";
        s=s+("Oggetto "+this.tipo+" - ");
        if(this.tipo=='R' || this.tipo=='T') {
           s=s+(" altezza:"+this.a+" - ");
           s=s+(" base:"+this.b);
        }
        if(this.tipo=='C') {
           s=s+(" raggio:"+this.c);
        }
        if(this.tipo=='K') {
           s=s+(" lato 1:"+this.a+" - ");
           s=s+(" lato 2:"+this.b+" - ");
           s=s+(" lato 3:"+this.c);
        }
        return(s);
    }
    
    public double getPerCirc() {
        double p=0;
        if(this.tipo=='R'){
          p=(this.a+this.b)*2;
        }        
        if(this.tipo=='C'){
          p=2*Math.PI*this.c;
        }        
        if(this.tipo=='K'){
          p=this.a+this.b+this.c;
        }        
        return(p);        
    }    
    public double getArea() {
        double a=0;
        double p=0;
        if(this.tipo=='R'){
            a=this.a*this.b;
        }    
        if(this.tipo=='T'){
            a=(this.a*this.b)/2;
        }    
        if(this.tipo=='C'){
            a=this.c*this.c*Math.PI;
        }    
        if(this.tipo=='K'){
            p=this.a+this.b+this.c;
            a=Math.sqrt( (p/2) * ((p/2)-this.a) * ((p/2)-this.b) * ((p/2)-this.c) );
        }    
        return(a);        
    }    
       
}


