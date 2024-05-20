package com.example;

public class TArbolGenerico<T> {
    public TNodoArbolGenerico<T> raiz;

    public boolean Insertar(String unaEtiqueta, String etiquetaPadre) {
        if (raiz == null) {
            if (etiquetaPadre.isEmpty()) {
                raiz = new TNodoArbolGenerico<T>(null, unaEtiqueta);
                return true;
            } else {
                return false;
            }
        } else {
            if (etiquetaPadre.isEmpty()) {
                TNodoArbolGenerico nodo = new TNodoArbolGenerico<T>(null, unaEtiqueta);
                nodo.hijos[0] = raiz;
                return true;
            } else {
                TNodoArbolGenerico nodo = this.Buscar(etiquetaPadre);
                if (nodo == null) {
                    return false;
                }
                TNodoArbolGenerico<T> nodoAInsertar = new TNodoArbolGenerico<T>(null, unaEtiqueta);
                for (int i = 0; i < nodo.hijos.length; i++) {
                    if (nodo.hijos[i] == null) {
                        nodo.hijos[i] = nodoAInsertar;
                        nodo.hijos[i].nivel = nodo.nivel + 1;
                        return true;
                    }
                }
                TNodoArbolGenerico<T>[] nuevoHijos = new TNodoArbolGenerico[nodo.hijos.length * 2];
                for (int i = 0; i < nodo.hijos.length; i++) {
                    nuevoHijos[i] = nodo.hijos[i];
                }
                int nuevoIndice = nodo.hijos.length;
                nodo.hijos = nuevoHijos;
                nodo.hijos[nuevoIndice] = nodoAInsertar;
                nodo.hijos[nuevoIndice].nivel = nodo.nivel + 1;
                return true;
            }
        }
    }

    public TNodoArbolGenerico<T> Buscar(String unaEtiqueta) {
        if (raiz == null) {
            return null;
        } else {
            return raiz.Buscar(unaEtiqueta);
        }
    }

    public String listaIndentado() {
        if (raiz == null) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            raiz.listaIndentado(sb);
            return sb.toString();
        }
    }
}
