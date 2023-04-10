public class Moba {
    public static void stageAttack(Attack o){o.attack();}
    public static void stageMagic(Magic o){o.magic();}

    public static void main(String[] args) {
        Valhein v = new Valhein("Peter");
        Carry c = new Carry();
        stageAttack(v);
        stageAttack(c);
        v.magic();
        //stageMagic(c);
        stageMagic(v);
        System.out.println(v.name);
        //System.out.println(c.magicNum);

        try {
            c.heal(3);
        }
        catch (RuntimeException e){
            System.out.println("Fail to heal");
        }
        finally {
            System.out.println("Skill is cooling down");
        }
    }
}
