import java.lang.Math;
public class Main {

    public static void main(String[] args) {
        Contador c = new Contador("test");
        for (int i = 0; i < 10; ++i){
            c.incrementar();
        }
        // 10
        System.out.println(c);

        System.out.println();

        Punto p = new Punto(10, 20);
        // 0,0
        System.out.printf("Punto: {%f, %f}\n", p.x(), p.y());
        // 1*sqrt(2)
        System.out.println("Radio Polar: "+ p.radioPolar());
        // -45
        System.out.println("Angulo Polar: "+ Math.toDegrees(p.anguloPolar()) +" Grados" );//Grados
        // 2
        System.out.println("Distancia: "+ p.distanciaEuclidiana(new Punto(0, 0))+ "\n");
        //System.out.println("Angulo Polar: "+ p.distanciaEuclidiana(new Punto(0, 0)));

        System.out.println("Segundo Punto :  \n");
        Fecha f1 = new Fecha(1, 8, 2017);
        Fecha f2 = new Fecha(1, 8, 2017);

        System.out.println(f1);
        System.out.println(f2);
        System.out.println();

        System.out.println("si la fecha es menor que la otra retorna -1. \n si la fecha es igual que la otra retorna 0. \n si la fecha es mayor que la otra retorna 1.");

        System.out.println();

        // 1
        System.out.println("Comparacion de fechas :"+ f1.comparar(f2));
    }

}