
package classelibri;
public class libri {   
    
private int libroprezzo;    
private String nome;
//faccio il metodo costruttore
public libri(int libroprezzo,String nome){
this.libroprezzo=libroprezzo;    
this.nome=nome;
}

//metto metodi get
public String getnome(){
return nome;    
}

public int getLibrop(){
return libroprezzo;    
}


//metto metodi set
public void setnome(String nome){
this.nome=nome;
}

public void setLibrop(int libroprezzo){
this.libroprezzo=libroprezzo;    
}

public float setAplicasconto(){
return libroprezzo*2/100;    
}
//metto il metodo che mi permette di aplicare lo sconto.

}
