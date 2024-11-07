
package figuregeomet;

public class rettangolo {
int base;
int altezza;
 

public rettangolo(int base,int altezza){
this.base=base;
this.altezza=altezza;
}

public int getBase(){
return base;
}

public int getAltezza(){
return altezza;
}

public int getPerimetro(){
return base+altezza*2;
}

public int getArea(){
return base*altezza;
}
}
