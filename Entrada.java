package Segundo_Semestre.Diario;

import java.time.LocalDate;

public class Entrada {
    private String txt;
    private String fecha;

    Entrada(String txt, LocalDate fecha) {
        this.txt = txt;
        this.fecha = fecha.toString();
    }

    public LocalDate getFecha() {
        return LocalDate.parse(fecha);
    }

    public String getTxt() {
        return txt;
    }
}
