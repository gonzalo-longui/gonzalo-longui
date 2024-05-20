package com.example;

public class TNodoArbolGenerico<T> {
    public String etiqueta;
    public T dato;
    public TNodoArbolGenerico<T>[] hijos;
    public Integer nivel = 0;


    public TNodoArbolGenerico(T unDato, String unaEtiqueta) {
        this.dato = unDato;
        this.etiqueta = unaEtiqueta;
        this.hijos = new TNodoArbolGenerico[5];
    }

    public TNodoArbolGenerico<T> Buscar(String unaEtiqueta) {
        if (this.etiqueta.equals(unaEtiqueta)) {
            return this;
        } else {
            for (TNodoArbolGenerico<T> hijo : this.hijos) {
                TNodoArbolGenerico nodo = null;
                if (hijo != null) {
                    nodo = hijo.Buscar(unaEtiqueta);
                    if (nodo != null) {
                        return nodo;
                    }
                }
            }
        }
        return null;
    }

    public void listaIndentado(StringBuilder sb) {
        sb.append("\n").append("  ".repeat(this.nivel)).append(this.etiqueta);
        for (TNodoArbolGenerico<T> nodo : this.hijos) {
            if (nodo != null) {
                nodo.listaIndentado(sb);
            }
        }
    }
}