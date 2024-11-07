
package progarrayvet;

public class studente {
    
    private String nome;
    int i;
    float somma=0,media;
    //3 voti
    private float votos;
    private float votoo;
    private float votop;
    //metodo costruttore.
    public studente(String nome,float votos,float votoo,float votop){
        this.nome=nome;
        this.votoo=votoo;
        this.votop=votop;
        this.votos=votos;
    }
    
    public String getNome(){
        return nome;
    }
    
    public float getvotoScritto(){
        return votos;
    }
    
    public float getvotoOrale(){
        return votoo;
    }
    
    public float getvotoPratica(){
        return votop;
    }
    
    
    public void setNome(String nome){
        this.nome=nome;
    }
    
    
    
    public float Media(){
        
       somma=somma+votoo+votos+votos;     
         return  media=somma/3;
        
    }
    
    public float Azzeravoti(){
        return (votoo+votos+votos)*0;   
    }
    
    
}
