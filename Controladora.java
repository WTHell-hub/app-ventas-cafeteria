package Segundo_Semestre.Diario;

import com.formdev.flatlaf.FlatDarkLaf;
import com.google.gson.Gson;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Controladora {

    private static List<String> metas = new ArrayList<>();
    private static List<Entrada> diario = new ArrayList<>();

    public static void addDiario(Entrada diario) {
        Controladora.diario.add(diario);
    }

    public static List<String> getMetas() {
        return metas;
    }

    public static void addMetas(String metas) {
        Controladora.metas.add(metas);
    }

    static Guardar_Listas listas() {
        return new Guardar_Listas(metas, diario);
    }

    public static List<Entrada> getDiario() {
        return diario;
    }

    static void Guardar() {
        Gson gson = new Gson();
        try(FileWriter writer = new FileWriter("Datos Diariojson")) {
            gson.toJson(listas(), writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Guardar_Listas Llamar_Datos() {
        Gson gson = new Gson();

        try(FileReader reader = new FileReader("Datos Diario.json")) {
            return gson.fromJson(reader, Guardar_Listas.class);
        } catch (Exception e) {
            return new Guardar_Listas(null, null);
        }
    }

    static void Iniciar() {
        Guardar_Listas aux = Llamar_Datos();

        if(aux.getMetas() != null) {
            metas = aux.getMetas();
            diario = aux.getDiario();

            new Interfas_Principal();
        } else  {
            new Crear_Metas();
        }
    }

    static List<LocalDate> fechas() {
        List<LocalDate> temp = new ArrayList<>();
        for (Entrada e: diario) {
            temp.add(e.getFecha());
        }
        return temp;
    }

    static int Contar_Racha() {
        if (!diario.isEmpty() && diario.getLast().getFecha().plusDays(1).equals(LocalDate.now())) {
            Set<LocalDate> listaLimpia = new HashSet<>(fechas());
            List<LocalDate> listaOrdenada = new ArrayList<>(listaLimpia);
            Collections.sort(listaOrdenada);

            int contador = 1;

            for (int i = 1; i < listaOrdenada.size(); i++) {
                LocalDate anterior = listaOrdenada.get(i-1);
                LocalDate actual = listaOrdenada.get(i);

                if (anterior.plusDays(1).equals(actual)) {
                    contador++;
                } else {
                    contador = 1;
                }
            }

            return contador;

            //ESTA INTERESANTE LO Q PASA CON ESTA CONDICIONAL ME PARECE Q ES CON EL SIGNO ! PERO FUNCIONA SIN EL, HAY Q ABERIGUAR PQ
        } else if (diario.isEmpty() || diario.getLast().getFecha().plusDays(1).equals(LocalDate.now())) {
            return 0;
        }
        return 1;
    }

    static List<Entrada> OrdenarDiario() {
        return diario.stream().sorted(Comparator.comparing(Entrada::getFecha).reversed()).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        FlatDarkLaf.setUseNativeWindowDecorations(false);

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("No se pudo aplicar FlatDarkLaf");
        }

        Controladora.Iniciar();
    }
}
