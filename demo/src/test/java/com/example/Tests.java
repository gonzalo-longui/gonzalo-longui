package com.example;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Tests {
    @Test
    public void InsertNodeInEmptyTree() {
        TArbolGenerico<String> arbol = new TArbolGenerico<String>();
        
        assertTrue(arbol.Insertar("nodo insertado", ""));
        assertTrue(arbol.raiz.etiqueta.equals("nodo insertado"));
    }

    @Test
    public void InsertNodeInTree() {
        TArbolGenerico<String> arbol = new TArbolGenerico<String>();
        arbol.Insertar("raiz", "");
        arbol.Insertar("nivel 1 nodo a", "raiz");
        arbol.Insertar("nivel 1 nodo b", "raiz");
        arbol.Insertar("nivel 1 nodo c", "raiz");
        arbol.Insertar("nivel 2 nodo a.a", "nivel 1 nodo a");
        arbol.Insertar("nivel 2 nodo b.a", "nivel 1 nodo b");
        arbol.Insertar("nivel 3 nodo b.a.a", "nivel 2 nodo b.a");
        arbol.Insertar("nivel 3 nodo b.a.b", "nivel 2 nodo b.a");
        arbol.Insertar("nivel 3 nodo b.a.c", "nivel 2 nodo b.a");

        TNodoArbolGenerico nodoPadre = arbol.Buscar("nivel 2 nodo b.a");

        int largoBefore = 0;
        int largoAfter = 0;

        for (int i = 0; i < nodoPadre.hijos.length; i++) {
            if (nodoPadre.hijos[i] == null) {
                largoBefore = i;
                break;
            }
        }

        arbol.Insertar("nivel 3 nodo b.a.d", "nivel 2 nodo b.a");

        for (int i = 0; i < nodoPadre.hijos.length; i++) {
            if (nodoPadre.hijos[i] == null) {
                largoAfter = i;
                break;
            }
        }

        assertEquals(arbol.raiz.hijos[0].etiqueta, "nivel 1 nodo a");
        assertEquals(largoBefore, largoAfter - 1);
    }

    @Test
    public void SearchTreeWithElement() {
        TArbolGenerico<String> arbol = new TArbolGenerico<String>();
        arbol.Insertar("raiz", "");
        arbol.Insertar("nivel 1 nodo a", "raiz");
        arbol.Insertar("nivel 1 nodo b", "raiz");
        arbol.Insertar("nivel 1 nodo c", "raiz");
        arbol.Insertar("nivel 2 nodo a.a", "nivel 1 nodo a");
        arbol.Insertar("nivel 2 nodo b.a", "nivel 1 nodo b");
        arbol.Insertar("nivel 3 nodo b.a.a", "nivel 2 nodo b.a");
        arbol.Insertar("nivel 3 nodo b.a.b", "nivel 2 nodo b.a");
        arbol.Insertar("nivel 3 nodo b.a.c", "nivel 2 nodo b.a");

        String etiquetaABuscar = "nivel 2 nodo b.a";
        TNodoArbolGenerico<String> nodo = arbol.Buscar(etiquetaABuscar);

        assertNotNull(nodo);
    }

    @Test
    public void SearchTreeWithoutElement() {
        TArbolGenerico<String> arbol = new TArbolGenerico<String>();
        arbol.Insertar("raiz", "");
        arbol.Insertar("nivel 1 nodo a", "raiz");
        arbol.Insertar("nivel 1 nodo b", "raiz");
        arbol.Insertar("nivel 1 nodo c", "raiz");
        arbol.Insertar("nivel 2 nodo a.a", "nivel 1 nodo a");
        arbol.Insertar("nivel 2 nodo b.a", "nivel 1 nodo b");
        arbol.Insertar("nivel 3 nodo b.a.a", "nivel 2 nodo b.a");
        arbol.Insertar("nivel 3 nodo b.a.b", "nivel 2 nodo b.a");
        arbol.Insertar("nivel 3 nodo b.a.c", "nivel 2 nodo b.a");

        String etiquetaABuscar = "nivel 2 nodo b.b";
        TNodoArbolGenerico<String> nodo = arbol.Buscar(etiquetaABuscar);

        assertNull(nodo);
    }

    @Test
    public void IndentedTreeTest() {
        TArbolGenerico<String> arbol = new TArbolGenerico<String>();
        arbol.Insertar("raiz", "");
        arbol.Insertar("nivel 1 nodo a", "raiz");
        arbol.Insertar("nivel 1 nodo b", "raiz");
        arbol.Insertar("nivel 1 nodo c", "raiz");
        arbol.Insertar("nivel 2 nodo a.a", "nivel 1 nodo a");
        arbol.Insertar("nivel 2 nodo b.a", "nivel 1 nodo b");
        arbol.Insertar("nivel 3 nodo b.a.a", "nivel 2 nodo b.a");
        arbol.Insertar("nivel 3 nodo b.a.b", "nivel 2 nodo b.a");
        arbol.Insertar("nivel 3 nodo b.a.c", "nivel 2 nodo b.a");

        String listaIndentada = arbol.listaIndentado();
        String esperado = "\nraiz\n  nivel 1 nodo a\n    nivel 2 nodo a.a\n  nivel 1 nodo b\n    nivel 2 nodo b.a\n      nivel 3 nodo b.a.a\n      nivel 3 nodo b.a.b\n      nivel 3 nodo b.a.c\n  nivel 1 nodo c";

        assertEquals(esperado, listaIndentada);
    }
}
