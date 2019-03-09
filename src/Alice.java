import java.util.Objects;



public class Alice extends Human implements ChangeableCondition, FieldSeller, SayPhraseSeller, DrinkableTea, Comparable<Alice> {
    private Politeness politeness;
    private Condition condition = Condition.NORMAL;
    private CupOfTea cap;


    @Override
    public void LetsDrinkTea() {
        try {
            cap.drink();
        } catch (TeaNullException e) {
            try {
                setCondition(Condition.ANNOYED);
            } catch (Throwable er) {
                System.out.println(er.getMessage());
                setPoliteness(Politeness.RUDE);
            }
            System.out.println(e.getMessage());
        }
    }

    private static class CupOfTea {
        public CupOfTea(String s) {
            nameOfUser = s;
            //System.out.println(nameOfUser + ": Беру я чаёк, наливаю в стакан, щас мне будет легко");
        }
        public CupOfTea(String s,int par){
            nameOfUser=s;
            fullness = par;
        }

        private int getFullness(){
            return fullness;
        }
        private String nameOfUser;
        private int fullness = 100;

        private void drink() throws TeaNullException {
            if (fullness == 0) {
                throw new TeaNullException("ГДЕ МОЙ ЧАЙ!?!?!?\n" + nameOfUser + ":состояние - ANNOYED", nameOfUser);
            } else {
                fullness -= 20;
                System.out.println(nameOfUser + ": пью чаёк, флюп-флюп");
            }
        }
    }

    public void setCondition(Condition condition) throws DoubleAnnoyedException {
        if (this.condition == Condition.ANNOYED)
            throw new DoubleAnnoyedException(getName() + ": Я В ЯРОСТИ!!!", getName());
        else this.condition = condition;
    }

    public Condition getCondition() {

        return this.condition;
    }
public int getfullness(){
        return cap.getFullness();
}
    @Override
    public void sayPhrase() {
        System.out.println(getName() + ": \"Ах ты, старая карга\"");
    }

    private boolean setPoliteness(Politeness politeness) {
        this.politeness = politeness;
        return true;
    }

    public Politeness getPoliteness() {
        return this.politeness;
    }

    public Alice(String name, Politeness politeness, int location,int fullness) {
        setName(name);
        setLocation(location);
        this.politeness = politeness;
        cap = new CupOfTea(name,fullness);
    }

    public Alice() {
        setName("Алиса");
        setLocation(0);
        this.politeness = Politeness.POLITE;
        cap = new CupOfTea("Алиса");
    }

    public Alice(String name) {
        setName(name);
        setLocation(0);
        this.politeness = Politeness.POLITE;
        cap = new CupOfTea(name);
    }

    public Alice(String name, Politeness politeness) {
        setName(name);
        setLocation(0);
        this.politeness = politeness;
        cap = new CupOfTea(name);
    }

    public Alice(String name, Politeness politeness, int location) {
        setName(name);
        setLocation(location);
        this.politeness = politeness;
        cap = new CupOfTea(name);
    }

    @Override
    public void changeCondition() {
        try {
            setCondition(Condition.ANNOYED);
            System.out.println(getName() + ": состояние поменялось на ANNOYED");
        } catch (DoubleAnnoyedException e) {
            System.out.println(e.toString());
            setPoliteness(Politeness.RUDE);
            System.out.println(getName() + "*ругается как старый сапожник*" + '(' + getPoliteness() + ')');
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Alice alice = (Alice) obj;
        return getPoliteness() == alice.getPoliteness() && getCondition() == alice.getCondition() && getName().equals(alice.getName()) && getfullness() == alice.getfullness();
    }




    @Override
    public int hashCode() {
        return Objects.hash(getPoliteness(), getCondition(),getfullness(),getName(),getLocation());
    }

    @Override
    public String toString() {
        return "\nКласс: Alice\n" + "Имя: " + getName() + "\nВежливость: politeness = " + politeness + '\n' + "Состояние: condition = " + condition + "\nHashcode: " + Integer.toHexString(hashCode())+ "\nКоордината: "+getLocation()+"\ncap: \n\tNameOfUser: " +getName()+"\n\tFullness :"+ cap.getFullness()+'\n';
    }

    @Override
    public String nameSeller() {
        return getName();
    }

    @Override
    public Condition conditionSeller() {
        return getCondition();
    }

    @Override
    public Politeness politenessSeller() {
        return getPoliteness();
    }

    @Override
    public int locationSeller() {
        return getLocation();
    }

    @Override
    public void sayPhraseSeller() {
        sayPhrase();
    }

    @Override
    public int compareTo(Alice alice) {
//        int value1 = this.getLocation() * 1000 + this.getfullness();
//        int value2 = alice.getLocation() * 1000 + alice.getfullness();
//        if (this.getCondition() == Condition.NORMAL) {
//            value1 += 1;
//        }
//        if (alice.getCondition() == Condition.NORMAL) {
//            value2 += 1;
//        }
//        if (this.getPoliteness() == Politeness.POLITE) {
//            value1 += 5;
//        }
//        if (alice.getPoliteness() == Politeness.POLITE) {
//            value2 += 5;
//        }
//        if (value1 > value2) return 1;
//        if (value2 > value1) return -1;
//        return this.getName().compareTo(alice.getName());
        return getLocation()-alice.getLocation();
    }
}
