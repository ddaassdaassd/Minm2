package com.example.robacobres_androidclient.callbacks;

import com.example.robacobres_androidclient.models.FAQ;
import java.util.List;

public interface FAQCallback {
    // Método que se llama cuando la llamada API es exitosa y retorna las preguntas frecuentes
    void onFAQCallback(List<FAQ> faqs);

    // Método que se llama cuando hay un error o un mensaje para mostrar al usuario
    void onMessage(String message);
}