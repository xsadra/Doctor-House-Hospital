package de.sadrab.UI.model;

public class LocalInvoice {
    private String name;
    private String illness;
    private String cost;
    private String time;

    public LocalInvoice() {
    }

    public LocalInvoice(String name, String illness, String cost, String time) {
        this.name = name;
        this.illness = illness;
        this.cost = cost;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "LocalInvoice{" +
                "name='" + name + '\'' +
                ", illness='" + illness + '\'' +
                ", cost='" + cost + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
