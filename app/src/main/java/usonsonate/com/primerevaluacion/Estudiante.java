package usonsonate.com.primerevaluacion;

import java.io.Serializable;

public class Estudiante implements Serializable{

    private String Nombre;
    private String Codigo;
    private String Materia;
    private Double Parcial_1;
    private Double Parcial_2;
    private Double Parcial_3;
    private Double Promedio;

    public Estudiante(String nombre, String codigo, String materia, Double parcial_1, Double parcial_2, Double parcial_3, Double promedio) {
        Nombre = nombre;
        Codigo = codigo;
        Materia = materia;
        Parcial_1 = parcial_1;
        Parcial_2 = parcial_2;
        Parcial_3 = parcial_3;
        Promedio = promedio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String materia) {
        Materia = materia;
    }

    public Double getParcial_1() {
        return Parcial_1;
    }

    public void setParcial_1(Double parcial_1) {
        Parcial_1 = parcial_1;
    }

    public Double getParcial_2() {
        return Parcial_2;
    }

    public void setParcial_2(Double parcial_2) {
        Parcial_2 = parcial_2;
    }

    public Double getParcial_3() {
        return Parcial_3;
    }

    public void setParcial_3(Double parcial_3) {
        Parcial_3 = parcial_3;
    }

    public Double getPromedio() {
        return Promedio;
    }

    public void setPromedio(Double promedio) {
        Promedio = promedio;
    }
}
