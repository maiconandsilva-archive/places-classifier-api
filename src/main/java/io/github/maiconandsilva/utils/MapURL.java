package io.github.maiconandsilva.utils;

import io.github.maiconandsilva.entities.embeddables.Coordenadas;


public class MapURL {
    public static String buildURLWith(Coordenadas coordenadas) {
        String url = System.getenv("URL_MAP");
        if (url != null)
            return String.format(url, coordenadas.latitude, coordenadas.longitude);
        return "";
    }
}
