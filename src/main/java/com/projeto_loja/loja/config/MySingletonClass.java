package com.projeto_loja.loja.config;

public class MySingletonClass {

    // Instância única da classe
    private static MySingletonClass instance;

    // Construtor privado para impedir instanciamento externo
    private MySingletonClass() {

    }

    // Método público para fornecer acesso à instância
    public static synchronized MySingletonClass getInstance() {
        if (instance == null) {
            instance = new MySingletonClass();
        }
        return instance;
    }
}
