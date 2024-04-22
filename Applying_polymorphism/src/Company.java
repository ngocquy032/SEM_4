// class này kế thừa từ class cha Taxpayer
public class Company extends Taxpayer  {
    @Override
    public double pay() {
        return 1000;
    }
}
