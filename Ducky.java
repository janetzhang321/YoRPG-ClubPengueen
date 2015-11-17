/*
Team Club Pengueen -- Janet Zhang, Kevin Hwang, Dorothy Ng
APCS1 pd5
HW31 -- Ye Olde Role Playing Game, Unchained
2015-11-16
*/

public class Ducky extends Character {
    
    public Ducky(String n) {
        super( 1 , 1 , 1000000000 , .1337 , "Ducky");
        name=n;
        sStr=(int)(origStr*1000000000);
        sDef=(int)(origDef*2.5);
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
        String ret="The Ducky is the defender of the World and the only one who has a 99.7% chance of defeating the Boss. ";
        ret+="While his strength and HP is abysmal, he has incredibly high defense, likened to a solid firewall.";
        return ret; }
}
