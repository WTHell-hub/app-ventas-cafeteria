package Segundo_Semestre.Diario;

import java.util.List;

public class Guardar_Listas {
    private List<String> metas;
    private List<Entrada> diario;

    Guardar_Listas(List<String> metas, List<Entrada> diario) {
        this.metas = metas;
        this.diario = diario;
    }

    public List<String> getMetas() {
        return metas;
    }

    public List<Entrada> getDiario() {
        return diario;
    }
}
