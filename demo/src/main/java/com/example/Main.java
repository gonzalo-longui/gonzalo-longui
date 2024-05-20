package com.example;

public class Main {
    public static void main(String[] args) {
        TArbolGenerico<String> arbol = new TArbolGenerico<String>();
        arbol.Insertar("Rectoría", "");
        arbol.Insertar("Vicerrectoría del Medio Universitario", "Rectoría");
        arbol.Insertar("Vicerrectoría Académica", "Rectoría");
        arbol.Insertar("Vicerrectoría Administrativa", "Rectoría");
        arbol.Insertar("Facultad de Ciencias Empresariales", "Vicerrectoría Académica");
        arbol.Insertar("Facultad de Ciencias Humanas", "Vicerrectoría Académica");
        arbol.Insertar("Facultad de Ingeniería y Tecnologías", "Vicerrectoría Académica");
        arbol.Insertar("Facultad de Psicología", "Vicerrectoría Académica");
        arbol.Insertar("Departamento de Informática y Ciencias de la Computación", "Facultad de Ingeniería y Tecnologías");
        arbol.Insertar("Departamento de Ingeniería Eléctrica", "Facultad de Ingeniería y Tecnologías");
        arbol.Insertar("Departamento de Matemáticas", "Facultad de Ingeniería y Tecnologías");

        System.out.println(arbol.listaIndentado());
        System.out.println("-".repeat(60));
        System.out.println(arbol.Buscar("Facultad de Arquitectura"));
        System.out.println(arbol.Buscar("Centro Ágora"));
        System.out.println(arbol.Buscar("Departamento de Estudios Organizacionales"));
        System.out.println(arbol.Buscar("Facultad de Psicología"));
    }
}