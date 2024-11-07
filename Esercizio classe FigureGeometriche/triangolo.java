
package figuregeomet;

public class triangolo {
int lato1; 
int lato2;
int lato3;
int base;
int altezza;
public triangolo(int lato1,int lato2,int lato3,int base,int altezza){
this.lato1=lato1;
this.lato2=lato2;
this.lato3=lato3;
this.base=base;
this.altezza=altezza;
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
public int getPerimetrot(){
return lato1+lato2+lato3;    
}
public int getAreat(){
return base*altezza/2;    
}

}
