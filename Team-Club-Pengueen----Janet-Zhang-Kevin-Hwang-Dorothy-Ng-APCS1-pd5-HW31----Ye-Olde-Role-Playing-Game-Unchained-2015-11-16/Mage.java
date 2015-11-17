/*
Team Club Pengueen -- Janet Zhang, Kevin Hwang, Dorothy Ng
APCS1 pd5
HW31 -- Ye Olde Role Playing Game, Unchained
2015-11-16
*/

public class Mage extends Character{ 
    
    public Mage(String n) {
        super( 100 , 23 , 20 , .5 , "Mage" );
        name=n;
        sStr=(int)(origStr*1.15);
        sDef=(int)(origDef*.89);
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
        String ret="The Mage specializes in the magic granted by mysterious spirits. ";
        ret+="Despite having low strength and defense, with help from the mysterious spirits, he is a force to be reckoned with. ";
        return ret; }
}
