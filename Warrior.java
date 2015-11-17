/*
Team Club Pengueen -- Janet Zhang, Kevin Hwang, Dorothy Ng
APCS1 pd5
HW31 -- Ye Olde Role Playing Game, Unchained
2015-11-16
*/

public class Warrior extends Character{

    public Warrior(String n) {
        super( 200 , 50 , 100 , .4 , "Warrior");
        name=n; 
        sStr=(int)(origStr*1.5);
        sDef=(int)(origDef*.5);
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
        String ret="The Warrior is primarily a defender. His main job is the take the brunt of attacks for his teammates. ";
        ret+="Because of this, the Warrior has higher HP and defense than other classes do.";
        return ret;
    }
}

