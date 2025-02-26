public interface IConst {
    double PI = 3.14; //число ПИ
    double g = 9.81; //ускорение свободного падения

    int MIN = 1;
    int MAX = 5;
}


class IConstImpl implements IConst {

    double pi = 3.241;


    public void printPi() {
        pi = 1;
        System.out.println(pi == PI);
    }
}
