/*
Team Club Pengueen -- Janet Zhang, Kevin Hwang, Dorothy Ng
APCS1 pd5
HW31 -- Ye Olde Role Playing Game, Unchained
2015-11-16
*/

public abstract class Character{
    protected int hp;
    protected int str;
    protected int def;
    protected double atk;
    protected String name;
    protected int origStr;
    protected int sStr;
    protected int origDef;
    protected int sDef;
    protected String type;
    
    protected String info;
    
    
    public Character(int h,int s, int d, double a, String t){
        hp=h;
        str=s;
        def=d;
        atk=a;
        origStr=str;
        origDef=def;
        type=t;
    }
    
    public boolean isAlive() {return hp>0;}
    public String getName(){return name;}
    public int getDefense(){return def;}
    public void lowerHP(int dmg){hp-=dmg;}
    public String getClassRPG() {return type;}
    
    
    public int attack(Character other) {
        int damage=(int)(str*atk-other.getDefense());
        if (damage<0) {
            if ((other.getClassRPG()).equals("Ducky")) damage=0;
            else damage=1; }
        other.lowerHP(damage);
        return damage;
    }
    
    public abstract void normalize();
    
    public abstract void specialize();
    
    public abstract String about();
}
