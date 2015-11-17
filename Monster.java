/*
Team Club Pengueen -- Janet Zhang, Kevin Hwang, Dorothy Ng
APCS1 pd5
HW31 -- Ye Olde Role Playing Game, Unchained
2015-11-16
*/

public class Monster extends Character{
    
    public Monster(){ 
        //super (int hp,int str, int def, double atk, String t)
        super( 150 , 20+(int)(Math.random()*45) , 20 , 1.0 , "Monster" ); 
    }
    
    public void normalize() {}
    
    public void specialize() {}
    
    public String about() {
        String ret="The Monster is not a mindless beast the hero must slay. He is but a creature trying to survive in this world just like the hero is. ";
        ret+="The Monster, however, is an obstacle that the hero must overcome in his journey. ";
        return ret; }
}
