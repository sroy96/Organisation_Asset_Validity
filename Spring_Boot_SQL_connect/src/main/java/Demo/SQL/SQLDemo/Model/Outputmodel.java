package Demo.SQL.SQLDemo.Model;

public class Outputmodel {

    private boolean result;
    private String name;

    public Outputmodel() {
    }

    public Outputmodel(boolean result, String name) {
        this.result = result;
        this.name = name;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
