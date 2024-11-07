
package test;


public class rettangolo {
//dichiaro le mie variabili in private    
 int base;
 int altezza;
 int calcolap;
 int calcolaa;
//faccio la funzione rettangolo    
rettangolo(int base,int altezza){
this.base=7;
this.altezza=8;
this.calcolap=0;
this.calcolaa=0;
}
//parte get
public int getBase(){
return base;
}
public int getAltezza(){
return altezza;
}
public int getcalcolaperimetro(){
return calcolap;
}
public int getcalcolarea(){
return calcolaa;
}
//parte void

public void calcolaperimetro(int base,int altezza){
this.calcolap=base+altezza;    
}
public void calcolarea(int base,int altezza){
this.calcolaa=base*altezza;    
}
  

}
