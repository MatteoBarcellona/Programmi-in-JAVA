package progfigurageometrica;

public class FiguraGeometrica {
    
    char tipo;
    double altezza,base;
    double raggio;
    
    FiguraGeometrica() {
        
    } 
    
    // costruttore vero
    FiguraGeometrica(char t, double a, double b, double r) {
        this.tipo=t;
        this.altezza=a;
        this.base=b;
        this.raggio=r;
    } 
    
    // getter
    public double getAltezza() {
        return(this.altezza);
    }
    public double getBase() {
        return(this.base);
    }
    public double getRaggio() {
        return(this.raggio);
    }
    public char getTipo() {
        return(this.tipo);
    }
    
    // setter
    public void setTipo(char t) {
        this.tipo=t;
    }
    public void setAltezza(double a) {
        this.altezza=a;
    }
    public void setBase(double b) {
        this.base=b;
    }
    public void setRaggio(double r) {
        this.raggio=r;
    }
    
    public String Stato() {
        String s="";
        s=s+("Oggetto "+this.tipo+" - ");
        if(this.tipo=='R' || this.tipo=='T') {
           s=s+(" altezza:"+this.altezza+" - ");
           s=s+(" base:"+this.base+" - ");
        }
        if(this.tipo=='C') {
           s=s+(" raggio:"+this.raggio);
        }
        return(s);
    }
    
    public double getPerCirc() {
        double p=0;
        if(this.tipo=='R'){
          p=(this.altezza+this.base)*2;
        }        
        if(this.tipo=='C'){
          p=2*Math.PI*this.raggio;
        }        
        return(p);        
    }    
    public double getArea() {
        double a=0;
        if(this.tipo=='R'){
            a=this.altezza*this.base;
        }    
        if(this.tipo=='T'){
            a=(this.altezza*this.base)/2;
        }    
        if(this.tipo=='C'){
            a=this.raggio*this.raggio*Math.PI;
        }    
        return(a);        
    }    
       
}


