import java.util.Objects;

public class Duchess extends Human {
    private BeautyType beautytype;
    private Chin chin;
    private class Chin{
        private Chin(ChinShape chinShape){
            this.chinShape = chinShape;
        }
        private Chin(){
            chinShape = ChinShape.SHARP;
        }
        private ChinShape chinShape;
        private ChinShape getChinShape() {
            return chinShape;
        }
        private void putChin(){
            System.out.printf("%s: достаточно приблизилась и положила %s подбородок\n",getName(),getChinShape());
        }
    }

    public ChinShape getChinShape(){
        return chin.getChinShape();
    }

    public BeautyType getBeautyType() {
        return this.beautytype;

    }

    public Duchess(){
        setName("Герцогиня");
        chin =  new Chin(ChinShape.SHARP);
        this.beautytype = BeautyType.UGLY;
        setLocation(100);
    }
    public Duchess(String name){
        setName(name);
        chin =  new Chin(ChinShape.SHARP);
        this.beautytype = BeautyType.UGLY;
        setLocation(100);
    }
    public Duchess(String name, ChinShape chinShape){
        setName(name);
        chin =  new Chin(chinShape);
        this.beautytype = BeautyType.UGLY;
        setLocation(100);
    }
    public Duchess(String name, ChinShape chinShape, BeautyType beautyType, int location){
        setName(name);
        chin =  new Chin(chinShape);
        this.beautytype = beautyType;
        setLocation(location);
    }
    @Override
    public void sayPhrase() {
        System.out.println(getName()+": \"Что ты деточка, во всём есть мораль, надо только уметь её найти!\"");
    }

    public boolean randomMove(FieldSeller alice, DrinkableTea alice1) {
        System.out.println();
        while (Math.abs(getLocation()-alice.locationSeller())>10) {
            int newLocation = (int) (Math.random() * 100);
            switch (compareLocation(getLocation(),alice.locationSeller(),newLocation)){
                case 1:
                    System.out.println(getName()+" приблизилась");
                    break;
                case 2:
                    System.out.println(getName()+" отдалилась");
                    break;
                case 3:
                    System.out.println(getName() + " осталась на месте");
                    break;
                case 4:
                    System.out.println(getName() + " переместилась, но осталось на том же расстоянии");
                    break;
                default:
                    System.out.println(getName() + " перестилась во времени и пространстве");
            }
            setLocation(newLocation);
            System.out.printf("Положение экземпляра %s - %s\n", getName(), getLocation());
            alice1.LetsDrinkTea();
            System.out.println();
        }
        chin.putChin();
        return true;
    }
    private int compareLocation(int duchessLocation, int aliceLocation, int newLocation){
        if(Math.abs(duchessLocation-aliceLocation)-Math.abs(newLocation-aliceLocation)>0){
            return 1;
        }
        if(Math.abs(duchessLocation-aliceLocation)-Math.abs(newLocation-aliceLocation)<0){
            return 2;
        }
        if(Math.abs(duchessLocation-aliceLocation)-Math.abs(newLocation-aliceLocation)==0){
            if(newLocation==duchessLocation) {
                return 3;
            } else {
                return 4;
            }
        }
        return 0;
    }
 public void changingCondition(ChangeableCondition alice1, FieldSeller alice2, SayPhraseSeller alice3){
             if((getChinShape()!=ChinShape.DULL)&&(getBeautyType()!=BeautyType.BEAUTIFULL)){
            System.out.printf("У экземпляра %s острый подбородок (%s), ну и на вид тоже так себе (%s)\n",
                    getName(),
                    getChinShape(),
                    getBeautyType());
                alice1.changeCondition();
            System.out.println( alice2.nameSeller()+" не любит, когда так делают");
            if (alice2.politenessSeller()==Politeness.RUDE){
                System.out.printf("%s не очень вежлива (%s)\n", alice2.nameSeller(), alice2.politenessSeller());
                alice3.sayPhraseSeller();
            }
            else {
                System.out.printf("%s не груба (%s)\n", alice2.nameSeller(),alice2.politenessSeller());
                System.out.println(alice2.nameSeller()+" промолчала");
            }
        }
        else {
            System.out.printf("возможно, %s даже красива (%s), а возможно, подбородок, не такой острый (%s)\n",
                    getName(),
                    getBeautyType(),
                    getChinShape());
            System.out.println( alice2.nameSeller() + "\"Я спокойна\"");
        }
 }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Duchess duchess = (Duchess) obj;
        return getChinShape() == duchess.getChinShape() &&
                getBeautyType() == duchess.getBeautyType();
    }

    @Override
    public String toString() {
        return "Класс: Duchess\n" + "Подбородок: chinShape = " + getChinShape() +"\n"+ "Красота: beautytype = " + beautytype + "\nhashCode: " + Integer.toHexString(hashCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChinShape(), getBeautyType());
    }

}
