package java_testpunti;

public class Punti {

    String nome;
    private int x,y;
    private int limx1,limy1,limx2,limy2;

    public Punti(String Pnome)
    {
        this.nome = Pnome;
	this.x=0;
	this.y=0;
	this.limx1=-5;
	this.limy1=-5;
	this.limx2=5;
	this.limy2=5;
    }

    public void Muovi(int dove)
    {
	switch (dove)
	{

            case 1:{
               	this.x--;
		if (this.x<this.limx1) 
                    this.x=this.limx1;
                break;}
            
            case 2:{
		this.x++;
		if (this.x>this.limx2) 
                    this.x=this.limx2;
		break;}
            
            case 3:{
		this.y++;
		if (this.y>this.limy2) 
                    this.y=this.limy2;
		break;}
            
            case 4:{
		this.y--;
		if (this.y<this.limy1) 
                    this.y=this.limy1;
		break;}
            
	}
    }

    public int Leggix()
    {
	return(this.x);
    }

    public int Leggiy()
    {
	return(this.y);
    }

    public String Quale()
    {
	return(this.nome);
    }
}
