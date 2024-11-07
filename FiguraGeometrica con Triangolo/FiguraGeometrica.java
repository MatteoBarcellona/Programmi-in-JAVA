package progfigurageometrica;

public class FiguraGeometrica {
    
    char tipo;
    double altezza,base;
    double raggio;
    double lato1,lato2,lato3;
    FiguraGeometrica() {
        
    } 
    
    // costruttore vero
    FiguraGeometrica(char tipo, double altezza, double base, double raggio,double lato1,double lato2,double lato3) {
        this.tipo=tipo;
        this.altezza=altezza;
        this.base=base;
        this.raggio=raggio;
        this.lato1=lato1;
        this.lato2=lato2;
        this.lato3=lato3;
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
    //lati
      public double getLato1() {
        return(this.lato1);
    }
     public double getLato2() {
        return(this.lato2);
    }
        public double getLato3() {
        return(this.lato3);
    }
    
    // setter
    public void setTipo(char tipo) {
        this.tipo=tipo;
    }
    public void setAltezza(double altezza) {
        this.altezza=altezza;
    }
    public void setBase(double base) {
        this.base=base;
    }
    public void setRaggio(double raggio) {
        this.raggio=raggio;
    }
     public void setLati(double lato1,double lato2,double lato3) {
        this.lato1=lato1;
        this.lato2=lato2;
        this.lato3=lato3;
    }
    
    public String Stato() {
        String s="";
        s=s+("Oggetto "+this.tipo+"  ");
        if(this.tipo=='R'){
        s=s+(" altezza:"+this.altezza+"  ");
        s=s+(" base:"+this.base+"  ");
        }
        if(this.tipo=='T'){
        s=s+(" altezza:"+this.altezza+"  ");
        s=s+(" base:"+this.base+"  ");
        s=s+(" lato1:"+this.lato1+"  ");
        s=s+(" lato2:"+this.lato2+"  ");
        s=s+(" lato3:"+this.lato3+"  ");
        
        if(this.lato1 > this.lato2){
        s=s+(" lato1 "+this.lato1+" e maggiore di lato 2:"+this.lato2);   
        }else{
        s=s+(" lato2 "+this.lato2+" e maggiore di lato 1:"+this.lato1);    
        }
        
        if(this.lato3 > this.lato2){
        s=s+(" lato3 "+this.lato3+" e maggiore di lato 2:"+this.lato2);   
        }else{
        s=s+(" lato2 "+this.lato2+" e maggiore di lato 3:"+this.lato3);    
        }
        }
        
        if(this.tipo=='C') {
        s=s+(" raggio:"+this.raggio);
        }
        return(s);
    }
    
    public double getPerCirc() {
        double perimetro=0;
        if(this.tipo=='R'){
          perimetro=(this.altezza+this.base)*2;
        }        
        if(this.tipo=='C'){
          perimetro=2*Math.PI*this.raggio;
        }        
        if(this.tipo=='T'){
          perimetro=(this.lato1 + this.lato2 + this.lato3);
        }   
        return(perimetro);        
    }    
    
    public double getArea() {
        double area=0;
        if(this.tipo=='R'){
            area=this.altezza*this.base;
        }    
        if(this.tipo=='T'){
            area=(this.altezza*this.base)/2;
        }    
        if(this.tipo=='C'){
            area=this.raggio*this.raggio*Math.PI;
        }    
        return(area);        
    }    
       
}


