
package vdata;
//metto le 2 librerire.
import java.util.Calendar;
import java.util.GregorianCalendar;

public class persone {
    //dichiaro 2 variabili.
    
    private String nome;
    private GregorianCalendar datatempo;
    
    public persone(String nome,GregorianCalendar datatempo){
        
        this.nome=nome;
        this.datatempo=datatempo;
        
    }
    
    public String getNome(){
        return nome;
    }
    
     public GregorianCalendar getDatatempo(){
        return datatempo;
    }
    
    public String tdata(){
        
   String data="-";
   int giorno,mese,anno;
             //faccio un if per confrontare il tempo delle dati 
		if(this.datatempo!=null) {
                    
			giorno=this.datatempo.get(Calendar.DAY_OF_MONTH);
			mese=this.datatempo.get(Calendar.MONTH)+1;
			anno=this.datatempo.get(Calendar.YEAR);
			data=String.valueOf(giorno)+"-"+String.valueOf(mese)+"-"+String.valueOf(anno);
                        
		}
		return(data);            
    } 
    
    public int diff(GregorianCalendar est) {
          int diff = (int) this.datatempo.compareTo(est);
          return(diff);
    }
     
    public long anni(GregorianCalendar est) {
           long diff = -(this.datatempo.getTimeInMillis() - est.getTimeInMillis()) / 1000;
           diff = diff/(60*60*24*365);
           return(diff);
    }
    
    public void add(){//passaggio giorno del ora
        int giorno = this.datatempo.get(Calendar.DAY_OF_MONTH+1);
    }
}
