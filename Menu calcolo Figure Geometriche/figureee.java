
package menufigure;


public class figureee {
    int base,altezza,lato1,lato2,lato3;
    double raggio;
    
    public figureee(int base,int altezza,int lato1,int lato2,int lato3,double raggio){
        this.base=base;
        this.altezza=altezza;
        this.lato1=lato1;
        this.lato2=lato2;
        this.lato3=lato3;
        this.raggio=raggio;
    }
    
    public int getBase(){
        return base;
    }
     public int getAltezza(){
        return altezza;
    }
     
      public int getLato1(){
        return lato1;
    }
       public int getLato2(){
        return lato2;
    }
        public int getLato3(){
        return lato3;
    }
        
     public double getRaggio(){
     return raggio;
     }
     //parte set
      public void setBase(int base){
      this.base=base;    
      }
      
      public void setAltezza(int altezza){
      this.altezza=altezza;    
      }
      
      public void setRaggio(double raggio){
      this.raggio=raggio;    
      }
      
      public void setLati(int lato1,int lato2 ,int lato3){
          this.lato1=lato1;
          this.lato2=lato2;
          this.lato3=lato3;
      }
      //perimetro
      public int PerimetroR(){
      return base+altezza*2;    
      }
      public int PerimetroT(){
      return lato1+lato2+lato3;    
      }
       public int PerimetroT2(){
      return base+altezza*2;    
      }
      public double PerimetroC(){
      return Math.PI*raggio*2;    
      }
      //area
      public int AreaR(){
      return base*altezza;    
      }
      
      public double AreaT(){
      return Math.sqrt((lato1+lato2+lato3/2)*((lato1+lato2+lato3/2)-lato1)*((lato1+lato2+lato3/2)-lato2)*((lato1+lato2+lato3/2)-lato3));
      }
      
      public int AreaT2(){
      return base*altezza/2;
      }
      
      public double AreaC(){
      return raggio*raggio*Math.PI;
      }
      
}
