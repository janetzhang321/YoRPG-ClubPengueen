/*
Team Club Pengueen -- Janet Zhang, Kevin Hwang, Dorothy Ng
APCS1 pd5
HW31 -- Ye Olde Role Playing Game, Unchained
2015-11-16
*/

public class Rogue extends Character{
    
    public Rogue(String n) {
        super( 50 , 150 , 31 , .75 , "Rogue");
        name=n;
        sStr=(int)(origStr*1.75);
        sDef=(int)(origDef*.35);
    }
    
    public void normalize() {
        def=origDef;
        str=origStr;
    }
    
    public void specialize() {
        def=sDef;
        str=sStr;
    }
    
    public String about() {
        String ret="The Rogue is a nimble attacker. His attacks are on point, just like his choice of weapon, daggers. ";
        ret+="However, while he has high strength, he also has low HP and low defense. Getting hit will definitely hurt a lot. ";
        return ret; }
    
}
