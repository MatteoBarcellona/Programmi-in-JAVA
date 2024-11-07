
package figuregeomet;

public class cerchio {
   
int raggio;
int pigreto;
public cerchio(int raggio,int pigreto){
this.raggio=raggio;
this.pigreto=pigreto;
}

public int getRaggio(){
return raggio;    
}

public int getPigreto(){
return pigreto;
}

public int getPerimetroc(){
return 2*pigreto*(raggio+raggio);    
}
public int getAreac(){
return raggio+(pigreto*pigreto);    
}
}

