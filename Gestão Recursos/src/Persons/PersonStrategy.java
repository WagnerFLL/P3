package Persons;

public abstract class PersonStrategy {

    private String name;
    private int ID;

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public abstract void setAtributs(int a);

}
