package maquina;
import java.util.Scanner;

public class Main {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            MaquinaDeCafe maquina = new MaquinaDeCafe();
            maquina.setCafetera(new Cafetera(500)); // mililitros
            maquina.setAzucarero(new Azucarero(200)); // gramos

            maquina.setVasosPequeno(new Vaso(10, 100)); // 10 vasos de 100ml
            maquina.setVasosMediano(new Vaso(10, 200)); // 10 vasos de 200ml
            maquina.setVasosGrande(new Vaso(10, 300)); // 10 vasos de 300ml

            System.out.println("== Bienvenido a la Maquina de Cafe ==");

            System.out.print("Elige el tamaño de vaso (pequeno/mediano/grande): ");
            String tipoVaso = scanner.nextLine().toLowerCase();

            Vaso vaso = maquina.getTipoVaso(tipoVaso);
            if (vaso == null) {
                System.out.println("Tipo de vaso no valido.");
                return;
            }

            System.out.print("¿Cuántos cafes deseas?: ");
            int cantidadVasos = scanner.nextInt();

            System.out.print("¿Cuanta azucar por vaso? (gramos): ");
            int azucarPorVaso = scanner.nextInt();

            String resultado = maquina.getVasoDeCafe(vaso, cantidadVasos, azucarPorVaso);
            System.out.println("Resultado: " + resultado);

            System.out.println("Gracias por usar la máquina.");
            scanner.close();
        }
    }


